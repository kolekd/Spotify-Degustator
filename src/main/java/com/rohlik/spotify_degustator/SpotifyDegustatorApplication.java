package com.rohlik.spotify_degustator;

import com.rohlik.spotify_degustator.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyDegustatorApplication implements CommandLineRunner {

    SpotifyService spotifyService;

    @Autowired
    public SpotifyDegustatorApplication(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpotifyDegustatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        spotifyService.authorize();
    }
}
