package com.example.cardrunfast;

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
