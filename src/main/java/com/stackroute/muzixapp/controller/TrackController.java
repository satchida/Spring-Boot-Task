package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;
import com.stackroute.muzixapp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="api/v1")
public class TrackController {

        TrackService trackService;
        TrackRepository trackRepository;


        @Autowired
        public TrackController(TrackService trackService) {
            this.trackService = trackService;
        }

        @PostMapping("track")
        public ResponseEntity<?> saveTrack(@RequestBody Track track) throws  TrackAlreadyExistsException{

            ResponseEntity responseEntity;
            try{
                trackService.saveTrack(track);
                responseEntity=new ResponseEntity("Successfully Created", HttpStatus.CREATED);
            }catch (Exception e)
            {
                responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            }
            return responseEntity;

        }

        @PostMapping("tracks")
        public ResponseEntity<?> saveTrackFromJasonFile(@RequestBody List<Track> track) throws TrackAlreadyExistsException {

            ResponseEntity responseEntity;
            for (Track t:track
                 ) {
                trackService.saveTrack(t);
            }
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
            return responseEntity;
        }

        @GetMapping("tracks")
        public ResponseEntity<?> getAllTracks(){

            System.out.println(trackService.findByTrackName("Abinash").toString());
            System.out.println(trackService.getTrackByNameSortByName("Abinash").toString());
            return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
        }


    @PutMapping(value = "/track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackAlreadyExistsException
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Succesfully Updated",HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping(value = "/track/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        trackService.deleteTrack(id);
        responseEntity=new ResponseEntity<String>("Succesfully deleted",HttpStatus.NO_CONTENT);
        return responseEntity;

    }
    }


