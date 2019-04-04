package com.rohlik.spotify_degustator.controller;

import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    List<Artist> artistList = new ArrayList<>();

    @PostConstruct
    public void init() {
        artistList.add(new Artist("Ajtakrajta Label"));
        artistList.add(new Artist("Metallica"));
        artistList.add(new Artist("Glass Animals"));
        artistList.add(new Artist("Ventolin"));
        artistList.add(new Artist("Foals"));
        artistList.add(new Artist("Mojito Gallery"));
        artistList.add(new Artist("Tame Impala"));
        artistList.add(new Artist("The HU"));
        artistList.add(new Artist("Vesna"));
    }

    @GetMapping
    public String index() {
        return "redirect:/artists";
    }

    @GetMapping("/artists")
    public String getArtist(Model model) {
        model.addAttribute("artists", artistList);
        return "artists";
    }
}
