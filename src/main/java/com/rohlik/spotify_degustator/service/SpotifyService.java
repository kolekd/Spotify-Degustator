package com.rohlik.spotify_degustator.service;

import com.rohlik.spotify_degustator.model.Artist;
import com.rohlik.spotify_degustator.model.TokenResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyService {

    private String token;

    public void authorize() {
        final String uri = "https://accounts.spotify.com/api/token";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Basic NjI1OWNjNTgxMGJkNGM4N2I4NDVjMjZlYTBiNTEzOGE6ZGY5YTY3YzA0MGY0NGE1MThmZjA4MDQzNzdmNzMyMDY=");
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "client_credentials");

        HttpEntity httpEntity = new HttpEntity(form, httpHeaders);

        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(uri, httpEntity, TokenResponse.class);

        System.out.println(response.getBody().getAccess_token());
    }

    public Artist getArtist(String id){
        final String uri = "https://api.spotify.com/v1/artists/" + id;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth("BQBXo2lmfiMCvURqzwXNIfsB1-aO0G2USQiaUqkl_JjV_sPSCUfWDLzBQj6LI3gMMfbgvIrWAzAAkp9MNFc");
        HttpEntity httpEntity = new HttpEntity("parameters", httpHeaders);

        ResponseEntity<Artist> result = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Artist.class);

        return result.getBody();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
