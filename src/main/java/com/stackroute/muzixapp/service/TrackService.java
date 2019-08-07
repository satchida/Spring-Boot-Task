package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;

import java.util.List;

public interface TrackService  {

    public Track saveTrack(Track track);

    public List<Track> getAllTracks();


    boolean updateTrack(Track track);

    boolean deleteTrack(int id);
}
