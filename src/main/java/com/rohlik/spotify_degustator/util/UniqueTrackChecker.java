package com.rohlik.spotify_degustator.util;

import com.rohlik.spotify_degustator.model.spotifyModels.Track;

import java.util.List;

public class UniqueTrackChecker {

    public static boolean isDuplicate(String trackName, List<Track> trackList) {
        trackName = trackName.toLowerCase();

        for(Track currentTrack : trackList) {
            if(currentTrack.getName().toLowerCase().equals(trackName)) {
                return true;
            }

            if (bonusTrackHandler(currentTrack.getName().toLowerCase(), trackName)) {
                return true;
            }
        }

        return false;
    }

    public static boolean bonusTrackHandler(String track1, String track2) {
        if(track1.toLowerCase().contains("bonus track")) {
            if(track1.substring(0, track1.length() - 14).toLowerCase().contains(track2.toLowerCase())) {
                return true;
            }
        }

        if(track2.toLowerCase().contains("bonus track")) {
            if(track1.toLowerCase().contains(track2.substring(0, track2.length() - 14).toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public static boolean isOriginal(String trackName) {
        boolean output = true;

        String lowerCase = trackName.toLowerCase();

        if(lowerCase.contains("- live") || lowerCase.contains("remix") || lowerCase.contains("- radio edit") ||
           lowerCase.contains("rework") || lowerCase.contains("- stripped")) {
            return false;
        }

        return output;
    }

}
