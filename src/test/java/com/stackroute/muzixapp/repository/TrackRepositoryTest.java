package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@DataMongoTest
@RunWith(SpringRunner.class)
public class TrackRepositoryTest {

    @Autowired
    TrackRepository trackRepository;
    Track track1;

    @Before
    public void setUp()
    {
        track1 = new Track();
        track1.setId(30);
        track1.setName("Believe");
        track1.setComment("Cher");
    }

    @After
    public void tearDown(){
        trackRepository.deleteAll();
    }

    @Test
    public void saveTrack() throws  Exception{
        trackRepository.save(track1);
        Track fetchUser = trackRepository.findById(track1.getId()).get();
        Assert.assertEquals(30,fetchUser.getId());
    }

    @Test
    public  void getAllTracks() throws  Exception{

        Track tracktest = new Track(4,"James","alfred");
        Track tracktest2 = new Track(7,"Gary","carlos");
        trackRepository.save(tracktest);
        trackRepository.save(tracktest2);
        List<Track> list =trackRepository.findAll();
        Assert.assertEquals("James",list.get(0).getName());
    }

    @Test
    public void updateComment(){
        trackRepository.save(track1);
        track1.setComment("good");
        trackRepository.save(track1);
        String comment = (trackRepository.findById(30).get()).getComment();
        Assert.assertEquals("good", comment);
    }

    @Test
    public void saveUserFailure(){
        Track testTrack = new Track(34,"Sabyas","Sahu");
        trackRepository.save(track1);
        Track fetchTrack = trackRepository.findById(track1.getId()).get();
        Assert.assertNotSame(testTrack,track1);
    }
}
