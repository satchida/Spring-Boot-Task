//package com.stackroute.muzixapp.seedData;
//
//
//import com.stackroute.muzixapp.domain.Track;
//import com.stackroute.muzixapp.repository.TrackRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ApplicationContextRefresh implements ApplicationListener<ApplicationReadyEvent>, CommandLineRunner {
//    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextRefresh.class);
//    @Autowired
//    private TrackRepository trackRepository;
//
//
//    @Value("${id}")
//    private int id;
//
//    @Value("${name}")
//    private String name;
//
//    @Value("${comment}")
//    private String comment;
//
//
//    @Override
//    public void onApplicationEvent(final ApplicationReadyEvent event) {
//        trackRepository.save(new Track(id, name, comment));
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        trackRepository.save(new Track(id, name, comment));
//        trackRepository.findAll().forEach((track) -> {
//            logger.info("{}", track);
//        });
//    }
//}
//
