package com.competition.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response getTeams() {
        return Response.status(200).entity("Henk").build();
    }

}
