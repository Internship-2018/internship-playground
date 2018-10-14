package com.mghelas.internship_playground.network;

public class APIUtils {
    public static final String BASE_URL = "https://private-c61d73-marcghelas.apiary-mock.com/";

    public static SweetService getSweetService() {
        return RetrofitClient.getClient(BASE_URL).create(SweetService.class);
    }
}
