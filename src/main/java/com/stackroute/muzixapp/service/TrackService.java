package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService  {


    Track saveTrack(Track track) throws TrackAlreadyExistsException;

    List<Track> getAllTracks();

    boolean updateTrack(Track track);

    boolean deleteTrack(int id) throws TrackNotFoundException;

}
