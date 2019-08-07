package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrackServiceImpl implements TrackService {

   private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public boolean updateTrack(Track track, int id)
    {
        if(!trackRepository.findById(id).isPresent())
            return false;
        track.setId(id);
        trackRepository.save(track);
        return  true;
    }

    @Override
    public void deleteTrack(int id)
    {
        trackRepository.deleteById(id);
    }
}