package com.rohlik.spotify_degustator.model.paging;

import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagingArtists extends PagingParent{

    List<Artist> items = new ArrayList<>();

    public PagingArtists() {}

    public PagingArtists(String href, int limit, String next, int offset, String previous, int total, List<Artist> items) {
        super(href, limit, next, offset, previous, total);
        this.items = items;
    }
}
