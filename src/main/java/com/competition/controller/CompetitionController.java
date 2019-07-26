package com.competition.controller;

import com.competition.model.entity.Competition;
import com.competition.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/competition")
public class CompetitionController {
    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(final CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllCompetitions() {
        try {
            return ResponseEntity.ok(competitionService.getAllCompetitions());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @PostMapping("/postNew")
    public ResponseEntity postNewCompetition(@RequestBody Competition competition) {
        try {
            return ResponseEntity.ok(competitionService.postNewCompetition(competition));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCompetitions() {
        competitionService.deleteAllCompetitions();
    }
}
