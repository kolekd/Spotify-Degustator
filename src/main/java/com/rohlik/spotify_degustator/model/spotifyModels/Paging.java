package com.rohlik.spotify_degustator.model.spotifyModels;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Paging {

    String href;
    List<Object> items = new ArrayList<>();
    int limit;
    String next;
    int offset;
    String previous;
    int total;

    public Paging() {}

    public Paging(String href, List<Object> items, int limit, String next, int offset, String previous, int total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
    }
}
