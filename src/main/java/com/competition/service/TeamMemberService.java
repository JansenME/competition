package com.competition.service;

import com.competition.model.Teammember;
import com.competition.repository.TeamMemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamMemberService {
    private static final Logger LOG = LoggerFactory.getLogger(TeamMemberService.class);

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public List<Teammember> getAllTeamMembers(){
        if (teamMemberRepository != null && teamMemberRepository.findAll() != null) {
            return teamMemberRepository.findAll();
        } else {
            return new ArrayList<>();
        }
    }

    public Teammember getOneTeamMember(Long teamMemberId) {
        return teamMemberRepository.findOne(teamMemberId);
    }

    public void saveTeamMember(Teammember teammember) {
        try {
            teamMemberRepository.save(teammember);
            LOG.info("Teammember ({}) was saved succesfully.", teammember.fullName());
        } catch (Exception e) {
            LOG.error("Teammember ({}) was not saved succesfully. Stacktrace:", teammember.fullName(), e.fillInStackTrace());
        }
    }

    public ResponseEntity handleException(Exception e) {
        LOG.error("There was an error in TeamMemberController. Stacktrace:", e.fillInStackTrace());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
