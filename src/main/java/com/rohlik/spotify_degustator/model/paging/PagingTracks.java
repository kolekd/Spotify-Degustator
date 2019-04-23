package com.rohlik.spotify_degustator.model.paging;

import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagingTracks extends PagingParent{

    List<Track> items = new ArrayList<>();

    public PagingTracks() {}

    public PagingTracks(String href, int limit, String next, int offset, String previous, int total, List<Track> items) {
        super(href, limit, next, offset, previous, total);
        this.items = items;
    }
}
