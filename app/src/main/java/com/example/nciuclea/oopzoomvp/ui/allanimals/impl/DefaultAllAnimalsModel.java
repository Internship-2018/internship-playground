package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.util.Log;

import com.example.nciuclea.oopzoomvp.network.ApiServiceBuilder;
import com.example.nciuclea.oopzoomvp.network.NetworkError;
import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.storage.dao.AnimalWithZoosDao;
import com.example.nciuclea.oopzoomvp.storage.dao.AnimalZoopark;
import com.example.nciuclea.oopzoomvp.storage.dao.Zoopark;
import com.example.nciuclea.oopzoomvp.storage.datasource.DBHelper;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataUpdatedCallback;
import com.example.nciuclea.oopzoomvp.util.loaders.DataFetcher;
import com.example.nciuclea.oopzoomvp.util.loaders.DataLoadCallback;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefaultAllAnimalsModel implements AllAnimalsModel, DataLoadCallback<List<Animal>> {
    private boolean fetchApi = true;
    private final DataFetcher dataFetcher;
    private DataUpdatedCallback<List<Animal>> dataUpdatedCallback;
    private DBHelper dbHelper;
    private AnimalWithZoosDao animalDao;
    private Dao<Zoopark, Integer> zooparkDao;
    private Dao<AnimalZoopark, Integer> animalZooparkDao;

    public DefaultAllAnimalsModel(DBHelper dbHelper, DataFetcher dataFetcher) {
        this.dbHelper = dbHelper;
        this.dataFetcher = dataFetcher;
        try {
            animalDao = dbHelper.getAnimalWithZoosDao();
            zooparkDao = dbHelper.getZooparkDao();
            animalZooparkDao = dbHelper.getAnimalZooparkDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestData(DataUpdatedCallback<List<Animal>> dataUpdatedCallback, boolean forceFetchApi) {
        this.dataUpdatedCallback = dataUpdatedCallback;
        if(fetchApi || forceFetchApi) {
            pullFromApi();
            fetchApi = false;
        }
        else {
            pullFromDB();
        }
    }

    @Override
    public void addAnimal(final Animal animal) {
        ApiServiceBuilder.getZooApiService().addAnimal(animal).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() != 201) {
                    dataUpdatedCallback.onDataFetchError(new NetworkError(response.code()));
                    return;
                }
                try {
                    animalDao.create(animal);
                } catch (SQLException e) {
                    dataUpdatedCallback.onDataFetchError(new NetworkError(
                            new Throwable("Animal adding in DB failed!")));
                    e.printStackTrace();
                    return;
                }
                pullFromDB();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                dataUpdatedCallback.onDataFetchError(new NetworkError(t));
            }
        });
    }

    @Override
    public void deleteAnimal(final int id) {
        ApiServiceBuilder.getZooApiService().deleteAnimal(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() != 204) {
                    dataUpdatedCallback.onDataFetchError(new NetworkError(response.code()));
                    return;
                }
                try {
                    animalDao.deleteById(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                pullFromDB();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                dataUpdatedCallback.onDataFetchError(new NetworkError(t));
            }
        });
    }

    @Override
    public void onDataLoaded(List<Animal> data) {
        dataUpdatedCallback.onDataUpdated(new ArrayList<>(data));
    }

    private void pullFromDB() {
        Log.d("PROF_LOG", "before Model calls dataFetcher.fetchData()");
        dataFetcher.fetchData();
    }

    private void pullFromApi() {
        final ArrayList<Animal> apiAnimalList = new ArrayList<>();
        final ArrayList<Zoopark> zooparkList = new ArrayList<>();

        //Pulling Animals from API
        ApiServiceBuilder.getZooApiService().getAnimals().enqueue(new Callback<List<Animal>>() {

            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
                if (response.code() != 200) {
                    dataUpdatedCallback.onDataFetchError(new NetworkError(response.code()));
                    pullFromDB();
                    return;
                }
                apiAnimalList.addAll(response.body());

                //Pulling Zooparks from API
                ApiServiceBuilder.getZooApiService().getZooparks().enqueue(new Callback<List<Zoopark>>() {

                    @Override
                    public void onResponse(Call<List<Zoopark>> call, Response<List<Zoopark>> response) {
                        if (response.code() != 200) {
                            dataUpdatedCallback.onDataFetchError(new NetworkError(response.code()));
                            pullFromDB();
                            return;
                        }
                        zooparkList.addAll(response.body());

                        ArrayList<AnimalZoopark> animalZooparkList = new ArrayList<>();
                        //generating hashmap
                        HashMap<Integer, Zoopark> zooparkHashMap = new HashMap<>();
                        for(Zoopark zoo: zooparkList){
                            zooparkHashMap.put(zoo.getId(), zoo);
                        }
                        //Filling animals (with references to zoos) and AnimalZoo table
                        for(int i = 0; i < apiAnimalList.size(); i++) {
                            for(int j = 0; j < apiAnimalList.get(i).getZooIds().size(); j++) {
                                Animal animalToAdd = apiAnimalList.get(i);
                                Zoopark zooToAdd = zooparkHashMap.get(apiAnimalList.get(i).getZooIds().get(j));
                                animalZooparkList.add(new AnimalZoopark(animalToAdd, zooToAdd));
                                // apiAnimalList.get(i).addZooPark(zooToAdd); now using data from DB on UI
                            }
                        }

                        //Writing lists to db
                        try {
                            dbHelper.onNewApiFetch();
                            animalDao.create(apiAnimalList);
                            zooparkDao.create(zooparkList);
                            animalZooparkDao.create(animalZooparkList);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        //pulling written data from DB
                        pullFromDB();

                    }

                    @Override
                    public void onFailure(Call<List<Zoopark>> call, Throwable t) {
                        dataUpdatedCallback.onDataFetchError(new NetworkError(t));
                        pullFromDB();
                    }

                });

            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {
                dataUpdatedCallback.onDataFetchError(new NetworkError(t));
                pullFromDB();
            }
        });

    }

}
