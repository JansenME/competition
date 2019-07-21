package com.competition.controller;

import com.competition.service.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompetitorController {
    private final CompetitorService competitorService;

    @Autowired
    public CompetitorController(final CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @GetMapping("/getAllCompetitors")
    public ResponseEntity getAllCompetitors() {
        try {
            return ResponseEntity.ok(competitorService.getAllCompetitors());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @PostMapping("/postNewCompetitor")
    public ResponseEntity postNewCompetitor(@RequestParam(value = "firstName", required = false) String firstName,
                                  @RequestParam(value = "lastName", required = false) String lastName,
                                  @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                                  @RequestParam(value = "email", required = false) String email) {
        try {
            return ResponseEntity.ok(competitorService.postNewCompetitor(firstName, lastName, phoneNumber, email));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }
}
