package com.mghelas.internship_playground.network;

import com.mghelas.internship_playground.network.sweet.SweetService;

public class APIUtils {
    public static final String BASE_URL = "https://private-7f96a1-marksweets.apiary-mock.com/";

    public static SweetService getSweetService() {
        return RetrofitClient.getClient(BASE_URL).create(SweetService.class);
    }
}
