package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("Track already Exists do not add Second Time");
        }
        Track savedTrack = trackRepository.save(track);
        if (savedTrack == null) {
            throw new TrackAlreadyExistsException("Track already Exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public boolean updateTrack(Track track) {
        if (!trackRepository.findById(track.getId()).isPresent())
            return false;

        // track.setId(id);
        trackRepository.save(track);
        return true;

    }

    @Override
    public boolean deleteTrack(int id) throws TrackNotFoundException {
        if (!trackRepository.existsById(id)) {
            throw new TrackNotFoundException("Track is not available to delete");
        }
        trackRepository.deleteById(id);
        return true;
    }
}


