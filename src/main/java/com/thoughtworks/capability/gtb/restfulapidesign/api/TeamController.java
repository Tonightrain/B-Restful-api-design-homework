package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domian.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.TeamNameIsExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.TeamNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/teams/group")
    public ResponseEntity groupStudents(){
        return ResponseEntity.ok(teamService.groupStudents());
    }

    @GetMapping("/teams")
    public ResponseEntity getGroupList(){
        return ResponseEntity.ok().body(teamService.getGroupList());
    }

    @PatchMapping("/teams/{id}")
    public ResponseEntity updateTeamName(@PathVariable int id, @RequestBody String teamName) throws TeamNotExistException, TeamNameIsExistException {
        teamService.updateTeamName(id,teamName);
        return ResponseEntity.ok().build();
    }
}
