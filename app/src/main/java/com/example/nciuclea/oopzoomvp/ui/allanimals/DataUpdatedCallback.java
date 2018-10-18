package com.example.nciuclea.oopzoomvp.ui.allanimals;

import com.example.nciuclea.oopzoomvp.network.NetworkError;

public interface DataUpdatedCallback<T> {
    void onDataUpdated(T data);

    void onDataFetchError(NetworkError error);
}
