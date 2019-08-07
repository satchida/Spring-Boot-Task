package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track ,Integer> {

    List<Track> findByName (String Name);


    @Query("from Track where name=?1 order by id")
    List<Track> findByNameSortedById(String name);

}
