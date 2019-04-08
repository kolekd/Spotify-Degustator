package com.rohlik.spotify_degustator;

import com.rohlik.spotify_degustator.service.DegustatorService;
import com.rohlik.spotify_degustator.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyDegustatorApplication implements CommandLineRunner {

    SpotifyService spotifyService;
    DegustatorService degustatorService;

    @Autowired
    public SpotifyDegustatorApplication(SpotifyService spotifyService, DegustatorService degustatorService) {
        this.spotifyService = spotifyService;
        this.degustatorService = degustatorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpotifyDegustatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        spotifyService.authorize();
    }
}
