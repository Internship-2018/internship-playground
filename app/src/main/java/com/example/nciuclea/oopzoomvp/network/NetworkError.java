package com.example.nciuclea.oopzoomvp.network;

public class NetworkError {
    private String msg;

    public NetworkError(Throwable t){
        msg = "There was a problem with network. \n" +
                t.getMessage() +
                "\n Displaying offline results... ";
    }

    public NetworkError(int code){
        switch (code) {
            case 404: msg = "There is an API problem (404: Resource not found)";
                break;
            default: msg = "There is an API problem with code: " + String.valueOf(code);
                break;
        }
    }

    public String getMsg() {
        return msg;
    }
}
