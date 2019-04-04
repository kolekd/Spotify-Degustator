package com.rohlik.spotify_degustator.storage;

public class Settings {

    boolean onlyOneVersionOfSong;

    public Settings() {
        this.onlyOneVersionOfSong = true;
    }

    public boolean isOnlyOneVersionOfSong() {
        return onlyOneVersionOfSong;
    }

    public void setOnlyOneVersionOfSong(boolean onlyOneVersionOfSong) {
        this.onlyOneVersionOfSong = onlyOneVersionOfSong;
    }
}
