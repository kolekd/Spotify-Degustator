package com.rohlik.spotify_degustator.storage;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class LocalStorage {

    private String token;

    public LocalStorage() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
