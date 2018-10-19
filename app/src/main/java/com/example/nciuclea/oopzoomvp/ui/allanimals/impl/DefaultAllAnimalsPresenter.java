package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.util.Log;
import android.view.View;

import com.example.nciuclea.oopzoomvp.network.NetworkError;
import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.storage.dao.Zoopark;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsPresenter;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsView;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsWireframe;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class DefaultAllAnimalsPresenter implements AllAnimalsPresenter, DataUpdatedCallback<List<Animal>> {
    private final AllAnimalsView allAnimalsView;
    private final AllAnimalsModel allAnimalsModel;
    private final AllAnimalsWireframe allAnimalsWireframe;


    public DefaultAllAnimalsPresenter(DefaultAllAnimalsView view, AllAnimalsModel model, AllAnimalsWireframe wireframe) {
        this.allAnimalsView = view;
        this.allAnimalsModel = model;
        this.allAnimalsWireframe = wireframe;
    }

    @Override
    public void onViewInitialized() {
        Log.d("PROF_LOG", "requested data from model in presenter / onViewInitialized");
        allAnimalsModel.requestData(this, false);
    }

    @Override
    public void onDataUpdated(List<Animal> data) {
        Log.d("PROF_LOG", "got data from model");
        allAnimalsView.updateData(data);
    }

    @Override
    public void onDataFetchError(NetworkError error) {
        allAnimalsView.showNetworkError(error.getMsg());
    }

    @Override
    public void onClick(View v, int id) {
        allAnimalsWireframe.showAnimalDescription(v, id);
    }

    @Override
    public void onLongClick(View itemView, int id) {
        allAnimalsModel.deleteAnimal(id);
    }

    @Override
    public void onRefresh() {
        allAnimalsModel.requestData(this, true);
    }

    @Override
    public void onFabClick(View v) {
        Animal doge = new Animal("DOGE",
                "https://i.kym-cdn.com/photos/images/masonry/000/674/934/422.jpg",
                "Internet", "MEMEnia",
                "Doge is an Internet meme that became popular in 2013. The meme typically" +
                        " consists of a picture of a Shiba Inu dog accompanied by multicolored text" +
                        " in Comic Sans font in the foreground. The text, representing a kind of" +
                        " internal monologue, is deliberately written in a form of broken English.\n" +
                        "\n" +
                        "The meme is based on a 2010 photograph, and became popular in late 2013," +
                        " being named as Know Your Meme's \"top meme\" of that year." +
                        " A cryptocurrency based on Doge, the Dogecoin, was launched in December 2013, " +
                        "and the Shiba Inu has been featured on Josh Wise's NASCAR car as part of " +
                        "a sponsorship deal. Doge has also been referenced by members of " +
                        "the United States Congress, a safety video for Delta Air Lines, " +
                        "a Google Easter egg, and the video for " +
                        "the song \"Word Crimes\" by \"Weird Al\" Yankovic.");
        allAnimalsModel.addAnimal(doge);
    }
}
