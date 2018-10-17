package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.util.Log;

import com.example.nciuclea.oopzoomvp.network.ApiServiceBuilder;
import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.storage.dao.AnimalWithZoosDao;
import com.example.nciuclea.oopzoomvp.storage.dao.AnimalZoopark;
import com.example.nciuclea.oopzoomvp.storage.dao.Zoopark;
import com.example.nciuclea.oopzoomvp.storage.datasource.DBHelper;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.ApiResponseReceivedCallback;
import com.example.nciuclea.oopzoomvp.util.loaders.DataFetcher;
import com.example.nciuclea.oopzoomvp.util.loaders.DataLoadCallback;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataUpdatedCallback;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefaultAllAnimalsModel implements AllAnimalsModel, DataLoadCallback<List<Animal>> {
    private ArrayList<Animal> animalsList = new ArrayList<>();
    private final DataFetcher dataFetcher;
    private DataUpdatedCallback<List<Animal>> dataUpdatedCallback;
    private ApiResponseReceivedCallback apiResponseReceivedCallback;
    private DBHelper dbHelper;
    private AnimalWithZoosDao animalDao;
    private Dao<Zoopark, Integer> zooparkDao;
    private Dao<AnimalZoopark, Integer> animalZooparkDao;

    @Override
    public void setDataUpdatedCallback(DataUpdatedCallback<List<Animal>> dataUpdatedCallback) {
        this.dataUpdatedCallback = dataUpdatedCallback;
    }

    public void setApiResponseReceivedCallback(ApiResponseReceivedCallback apiResponseReceivedCallback) {
        this.apiResponseReceivedCallback = apiResponseReceivedCallback;
    }

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
    public void pullFromApi() {
        ApiServiceBuilder.getZooApiService().getAnimals().enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
                dbHelper.onNewApiFetch();
                final ArrayList<Animal> apiAnimalList = new ArrayList<>(response.body());
                try {
                    animalDao.create(apiAnimalList);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                ApiServiceBuilder.getZooApiService().getZooparks().enqueue(new Callback<List<Zoopark>>() {
                    @Override
                    public void onResponse(Call<List<Zoopark>> call, Response<List<Zoopark>> response) {
                        ArrayList<Zoopark> zooparkList = new ArrayList<>(response.body());
                        try {
                            zooparkDao.create(zooparkList);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        //generating hashmap
                        HashMap<Integer, Zoopark> zooparkHashMap = new HashMap<>();
                        for(Zoopark zoo: zooparkList){
                            zooparkHashMap.put(zoo.getId(), zoo);
                        }
                        //Filling animals (with references to zoos) and AnimalZoo table
                        for(int i = 0; i < apiAnimalList.size(); i++) {
                            for(int j = 0; j < apiAnimalList.get(i).getZooIds().size(); j++) {

                                Zoopark zooToAdd = zooparkHashMap.get(apiAnimalList.get(i).getZooIds().get(j));
                                apiAnimalList.get(i).addZooPark(zooToAdd);
                                try {
                                    animalZooparkDao.create(new AnimalZoopark(apiAnimalList.get(i), zooToAdd));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        apiResponseReceivedCallback.onSuccess(apiAnimalList);
                    }

                    @Override
                    public void onFailure(Call<List<Zoopark>> call, Throwable t) {
                        apiResponseReceivedCallback.onFailure();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {
                apiResponseReceivedCallback.onFailure();
            }
        });
    }

    @Override
    public void pullFromDB() {
        Log.d("PROF_LOG", "before Model calls dataFetcher.fetchData()");
        dataFetcher.fetchData();
    }

    @Override
    public void onDataLoaded(List<Animal> data) {
        dataUpdatedCallback.onDataUpdated(new ArrayList<>(data));
    }


}
