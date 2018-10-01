package com.example.nciuclea.oopzoomvp.ZooScreen;

public class ZooPresenterImpl implements ZooPresenter {
    private ZooView view;
    private ZooModel model;


    public ZooPresenterImpl(ZooView view, ZooModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onRecyclerViewReady() {
        view.updateAnimalList(model.getAnimalList());
    }
}
