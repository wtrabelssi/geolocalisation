package com.example.demo.tasks;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.model.Mobile;
import com.example.demo.model.Reclamations;
import com.example.demo.model.Boundary;
import com.example.demo.repo.MobileRepository;
import com.example.demo.repo.ReclamationsRepository;




@Component
public class ReclamationTask {
    @Autowired
    private MobileRepository mobileRepository;

    @Autowired
    private ReclamationsRepository reclamationsRepository;



    @Scheduled(fixedDelay = 1) // Run every 60 seconds (adjust as needed)
    public void checkMobileTable() {
        // Retrieve all unprocessed entries from the mobile table
        List<Mobile> unprocessedEntries = mobileRepository.findUnprocessedEntries();

        for (Mobile mobile : unprocessedEntries) {
            int cin = mobile.getCin();
            int altitude =mobile.getAltitude() ;
            int langtitude =mobile.getLangtitude() ;
            Blob photo = mobile.getPhoto();

            // Retrieve the corresponding localisation based on the GPS coordinates
            List<String> localisationList = Boundary.findBoundary(altitude,langtitude);

            if (localisationList != null && !localisationList.isEmpty()) {
                for (String location : localisationList) {
                    // Create a new Reclamations object
                    Reclamations reclamation = new Reclamations();
                    reclamation.setCin(cin);
                    reclamation.setEtat(0);
                    reclamation.setLocalisation(location);
                    reclamation.setPhoto(photo);

                    try {
                        // Save the new Reclamations object in the database
                        reclamationsRepository.save(reclamation);
                    } catch (Exception e) {
                        // Handle any exceptions that occur during the saving process
                        e.printStackTrace(); // Print the stack trace for debugging purposes
                        // You can add additional error handling here as needed
                    }
                }

                // Mark the mobile entry as processed
                mobile.setProcessed(true);
                mobileRepository.save(mobile);
            }

        }
    }
}
