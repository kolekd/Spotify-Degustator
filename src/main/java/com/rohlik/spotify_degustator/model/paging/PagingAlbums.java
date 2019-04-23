package com.rohlik.spotify_degustator.model.paging;

import com.rohlik.spotify_degustator.model.spotifyModels.Album;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagingAlbums extends PagingParent{

    List<Album> items = new ArrayList<>();

    public PagingAlbums() {}

    public PagingAlbums(String href, int limit, String next, int offset, String previous, int total, List<Album> items) {
        super(href, limit, next, offset, previous, total);
        this.items = items;
    }
}
