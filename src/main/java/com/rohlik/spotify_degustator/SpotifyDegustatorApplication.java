package com.rohlik.spotify_degustator;

import com.rohlik.spotify_degustator.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyDegustatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotifyDegustatorApplication.class, args);
    }

}
