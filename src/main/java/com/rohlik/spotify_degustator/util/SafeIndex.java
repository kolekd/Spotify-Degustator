package com.rohlik.spotify_degustator.util;

import java.util.List;

public class SafeIndex {

    public static int nullPointerPreventer(int index, List list) {
        if(list.size() == 1) {
            return 0;
        } else if(index == list.size()) {
            return index - 1;
        } return index;
    }

}
