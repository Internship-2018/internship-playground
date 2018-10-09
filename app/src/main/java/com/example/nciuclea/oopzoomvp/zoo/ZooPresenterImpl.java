package com.example.nciuclea.oopzoomvp.zoo;

public class ZooPresenterImpl implements ZooPresenter {
    private ZooView view;
    private ZooModel model;


    public ZooPresenterImpl(ZooView view, ZooModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onInitRecyclerView() {
        view.updateAnimalList(model.getAnimalList());
    }
}
