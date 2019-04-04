package com.rohlik.spotify_degustator.model.paging;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagingParent {

    String href;
    int limit;
    String next;
    int offset;
    String previous;
    int total;

    public PagingParent() {}

    public PagingParent(String href, int limit, String next, int offset, String previous, int total) {
        this.href = href;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
    }
}
