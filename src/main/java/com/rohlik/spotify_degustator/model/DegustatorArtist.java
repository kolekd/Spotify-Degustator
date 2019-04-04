package com.rohlik.spotify_degustator.model;

import com.rohlik.spotify_degustator.model.spotifyModels.Album;
import lombok.Data;

import java.util.List;

@Data
public class DegustatorArtist {

    String id;
    String name;
    List<DegustatorAlbum> albums;

    public DegustatorArtist() {}

    public DegustatorArtist(String id, String name, List<DegustatorAlbum> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }
}
