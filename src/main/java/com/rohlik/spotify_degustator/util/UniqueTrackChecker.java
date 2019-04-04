package com.rohlik.spotify_degustator.util;

import com.rohlik.spotify_degustator.model.spotifyModels.Track;

import java.util.List;

public class UniqueTrackChecker {

    public static boolean checkIfEquals(String trackName, List<Track> trackList) {
        boolean output = false;

        for(Track currentTrack : trackList) {
            if(currentTrack.getName().equals(trackName)) {
                return true;
            }
        }

        return output;
    }

    public static boolean checkIfContains(String trackName, List<Track> trackList) {
        boolean output = false;

        for(Track currentTrack : trackList) {
            if(currentTrack.getName().contains(trackName)) {
                return true;
            }
        }

        return output;
    }

}
