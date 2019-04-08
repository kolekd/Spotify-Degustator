package com.rohlik.spotify_degustator.service;

import com.rohlik.spotify_degustator.model.DegustatorAlbum;
import com.rohlik.spotify_degustator.model.DegustatorArtist;
import com.rohlik.spotify_degustator.model.spotifyModels.Album;
import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import com.rohlik.spotify_degustator.storage.LocalStorage;
import com.rohlik.spotify_degustator.storage.Settings;
import com.rohlik.spotify_degustator.util.SafeIndex;
import com.rohlik.spotify_degustator.util.UniqueTrackChecker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class DegustatorService {

    LocalStorage localStorage;
    SpotifyService spotifyService;

    Random r = new Random();

    @Autowired
    public DegustatorService(LocalStorage localStorage, SpotifyService spotifyService) {
        this.localStorage = localStorage;
        this.spotifyService = spotifyService;
    }

    public ResponseEntity checkTokenPresence() {
        if((!(localStorage.getToken() == null) && localStorage.getToken().length() > 0)) {
            return ResponseEntity.ok("Token present.");
        } return ResponseEntity.ok("No token present.");
    }

    public String checkToken() {
        return localStorage.getToken();
    }

    public DegustatorArtist checkSavedArtist() {
        return localStorage.getArtist();
    }

    public Settings checkSettings() {
        return localStorage.getSettings();
    }

    public DegustatorArtist saveArtist(String id) {
        List<Track> allTracks = new ArrayList<>();
        Artist artist = spotifyService.getArtist(id);

        log.info("Saving artist ID: " + artist.getId());

        for (Album album : spotifyService.getAlbumsByArtist(id).getItems()) {
            List<Track> tracksFromThisAlbum = spotifyService.getTracksFromAlbum(album.getId());
            allTracks.addAll(tracksFromThisAlbum);
        }

        DegustatorArtist degustatorArtist = new DegustatorArtist(artist.getId(), artist.getName(), allTracks);

        localStorage.setArtist(degustatorArtist);
        log.info("Saved artist: " + degustatorArtist.getName() + ",  ID: " + degustatorArtist.getId());

        return degustatorArtist;
    }

    public List<Track> generatePlaylist() {
        List<Track> trackList = new ArrayList<>();
        List<Track> artistTracks = new ArrayList<>();

        Iterator<Track> iterator = (localStorage.getArtist().getAllTracks()).iterator();
        boolean goodToGo;
        Track track;
        while (iterator.hasNext()) {
            goodToGo = true;
            track = iterator.next();

            if(localStorage.getSettings().isOriginalsOnly()) {
                if (!UniqueTrackChecker.isOriginal(track.getName())) {
                    goodToGo = false;
                }
            }

            if (UniqueTrackChecker.isDuplicate(track.getName(), artistTracks)){
                goodToGo = false;
            }

            if (goodToGo) {
                artistTracks.add(track);
            }

            iterator.remove();
        }

        int generatedPlaylistSize = 20;
        if (artistTracks.size() < 20) {
            generatedPlaylistSize = artistTracks.size();
        }

        Track currentTrack;
        while (trackList.size() < generatedPlaylistSize) {
            currentTrack = artistTracks.get(SafeIndex.nullPointerPreventer((r.nextInt(artistTracks.size() - 0) + 1) + 0, artistTracks));
            if (!UniqueTrackChecker.isDuplicate(currentTrack.getName(), trackList)){
                trackList.add(currentTrack);
            }
        }

        log.info("Playlist generated.");
        localStorage.setTrackList(trackList);

        System.out.println("| Generated playlist |");
        for (int i = 0; i < trackList.size(); i++) {
            System.out.println("Track #" + (i + 1) + "  " + trackList.get(i).getName());
        }

        return trackList;
    }

}
