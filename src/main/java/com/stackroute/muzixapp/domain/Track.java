package com.stackroute.muzixapp.domain;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Track {


    @Id
    //@Value("${track.id}")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    int Id;
//@Value("{track.name}")
    String name;
//@Value("{track.comment}")
    String comment;

}
