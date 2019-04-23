package com.rohlik.spotify_degustator.storage;

public class Settings {

    boolean originalsOnly;

    public Settings() {
        this.originalsOnly = true;
    }

    public boolean isOriginalsOnly() {
        return originalsOnly;
    }

    public void setOriginalsOnly(boolean originalsOnly) {
        this.originalsOnly = originalsOnly;
    }
}
