package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="api/v1")
public class TrackController {

        private TrackService trackService;

        @Autowired
        public TrackController(TrackService trackService) {
            this.trackService = trackService;
        }

        @PostMapping("track")
        public ResponseEntity<?> saveTrack(@RequestBody Track track){

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

        @GetMapping("tracks")
        public ResponseEntity<?> getAllTracks(){

            return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
        }

    @PutMapping(value = "track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)
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
    @DeleteMapping(value = "/track")
    public ResponseEntity<?> deleteUser(@PathVariable int id)
    {
        ResponseEntity responseEntity;
        trackService.deleteTrack(id);
        responseEntity=new ResponseEntity<String>("Succesfully deleted",HttpStatus.NO_CONTENT);
        return responseEntity;
    }
    }
