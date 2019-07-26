package com.competition.controller;

import com.competition.model.entity.Competitor;
import com.competition.service.CompetitorService;
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
@RequestMapping("/competitor")
public class CompetitorController {
    private final CompetitorService competitorService;

    @Autowired
    public CompetitorController(final CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllCompetitors() {
        try {
            return ResponseEntity.ok(competitorService.getAllCompetitors());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @PostMapping("/postNew")
    public ResponseEntity postNewCompetitor(@RequestBody Competitor competitor) {
        try {
            return ResponseEntity.ok(competitorService.postNewCompetitor(competitor));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCompetitors() {
        competitorService.deleteAll();
    }
}
