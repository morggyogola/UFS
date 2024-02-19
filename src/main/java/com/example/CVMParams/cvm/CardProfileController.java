package com.example.CVMParams.cvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardProfileController {
        @Autowired
        private CardProfileService cardProfileService;

        @GetMapping("/generateFile/{profileId}")
        public String generateSimulatedData(@PathVariable("profileId") Long profileId) {
            cardProfileService.generateSimulatedData(profileId);
            return "Simulated data generated successfully!";
        }
    }
