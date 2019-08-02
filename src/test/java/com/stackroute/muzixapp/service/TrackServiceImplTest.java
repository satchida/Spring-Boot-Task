package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class TrackServiceImplTest {

    Track track,track1;

    //Create a mock for UserRepository
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
   TrackServiceImpl trackServiceimpl;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track1=new Track();
        track.setId(2);
        track.setName("Sabyasachi");
        track.setComment("Sahoo");
        list = new ArrayList();
        list.add(track);
        track1.setId(3);
        track1.setName("Sabya");
        track1.setComment("Sahu");
        list.add(track1);


    }

    @Test
    public void saveTrackTest() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackServiceimpl.saveTrack(track);
        Assert.assertEquals(track,savedTrack);
        verify(trackRepository,times(1)).save(track);
    }


    @Test
    public void getAllTrackTest() throws Exception {
        trackRepository.save(track);
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> getlist = trackServiceimpl.getAllTracks();
        Assert.assertEquals(list,getlist);
        verify(trackRepository,times(1)).findAll();
    }

    @Test
    public  void updateTrackTest() throws  Exception {
        trackRepository.save(track);
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track updatedTrack = trackServiceimpl.saveTrack(track);
        Assert.assertEquals(track,updatedTrack);
    }

    @Test
    public void deleteTrackTest() throws  Exception {
     trackRepository.delete(track);
     boolean deletedTrack=trackRepository.existsById(2);
     assertEquals(false,deletedTrack);
    }

}