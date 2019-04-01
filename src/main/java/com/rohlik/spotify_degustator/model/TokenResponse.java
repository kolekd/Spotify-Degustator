package com.rohlik.spotify_degustator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenResponse {

    @JsonProperty("access_token")
    String access_token;

    @JsonProperty("token_type")
    String token_type;

    @JsonProperty("expires_in")
    int expires_in;

    public TokenResponse(String access_token, String token_type, int expires_in) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    public TokenResponse() {
    }
}
