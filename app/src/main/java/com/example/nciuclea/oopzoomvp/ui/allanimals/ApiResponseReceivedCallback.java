package com.example.nciuclea.oopzoomvp.ui.allanimals;

import java.util.List;

public interface ApiResponseReceivedCallback<T> {

    void onSuccess(T data);

    void onFailure();
}
