package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;

import java.util.List;

public interface TrackService  {


    Track saveTrack(Track track);

    List<Track> getAllTracks();

    boolean updateTrack(Track track, int id);

    void deleteTrack(int id);
}
