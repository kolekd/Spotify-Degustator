package com.rohlik.spotify_degustator.model.spotifyModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GrantType {

    String grant_type;

    public GrantType(String grant_type) {
        this.grant_type = grant_type;
    }

    public GrantType() {
    }
}
