package com.rohlik.spotify_degustator.service;

import com.rohlik.spotify_degustator.model.spotifyModels.Paging;
import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import com.rohlik.spotify_degustator.model.response.TokenResponse;
import com.rohlik.spotify_degustator.storage.LocalStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SpotifyService {

    LocalStorage localStorage;

    @Autowired
    public SpotifyService(LocalStorage localStorage) {
        this.localStorage = localStorage;
    }

    public HttpEntity httpEntityWithHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(localStorage.getToken());
        return new HttpEntity("parameters", httpHeaders);
    }

    public void authorize() {
        final String uri = "https://accounts.spotify.com/api/token";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Basic NjI1OWNjNTgxMGJkNGM4N2I4NDVjMjZlYTBiNTEzOGE6ZGY5YTY3YzA0MGY0NGE1MThmZjA4MDQzNzdmNzMyMDY=");
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "client_credentials");

        HttpEntity httpEntity = new HttpEntity(form, httpHeaders);

        log.info("Requesting token.");
        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(uri, httpEntity, TokenResponse.class);
        log.info("Saving token.");
        localStorage.setToken(response.getBody().getAccess_token());
    }

    public Artist getArtist(String id){
        final String uri = "https://api.spotify.com/v1/artists/" + id;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = httpEntityWithHeaders();

        log.info("Requesting artist ID: " + id + ".");
        ResponseEntity<Artist> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Artist.class);
        log.info("Retrieved artist ID: " + id + ".");

        return response.getBody();
    }

    // TODO - PROGRESS
    public Paging getAlbumsByArtist(String id) {
        final String uri = "https://api.spotify.com/v1/artists/" + id + "/albums";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = httpEntityWithHeaders();

        log.info("Requesting track ID: " + id + ".");
        ResponseEntity<Paging> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Paging.class);
        log.info("Retrieved track ID: " + id + ".");

        return response.getBody();
    }

    // TODO
    public List<Artist> searchArtist(String name) {
        final String uri = "https://api.spotify.com/v1/artists/"; // Find correct endpoint

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(localStorage.getToken());
//        HttpEntity httpEntity = new HttpEntity();

        log.info("Searching artists by name: " + name + ".");
//        ResponseEntity<List<Artist>> response = restTemplate.exchange()
//        log.info("Found " + response + " artists.");

//        return response.getBody();
        return new ArrayList<>();
    }


}
