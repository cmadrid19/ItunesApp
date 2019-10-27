package com.example.itunesapp.dto;


import java.io.Serializable;

public class Cancion implements Serializable {

    private String artistName;
    private int trackId;
    private String trackName;

    public Cancion ()
    {

    }

    public Cancion(String artistName, int trackId, String trackName) {
        this.artistName = artistName;
        this.trackId = trackId;
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
}