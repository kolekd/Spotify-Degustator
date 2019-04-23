package com.rohlik.spotify_degustator.model.paging;

import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagingObjects extends PagingParent {

    List<Object> items = new ArrayList<>();

    public PagingObjects() {}

    public PagingObjects(String href, int limit, String next, int offset, String previous, int total, List<Object> items) {
        super(href, limit, next, offset, previous, total);
        this.items = items;
    }
}
