package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domian.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domian.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.TeamNameIsExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.TeamNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final StudentRepository studentRepository;

    public TeamService(TeamRepository teamRepository, StudentRepository studentRepository){
        this.teamRepository = teamRepository;
        this.studentRepository = studentRepository;
    }

    public List<Team> groupStudents() {
        return teamRepository.groupStudents();
    }

    public List<Team> getGroupList() {
        return teamRepository.findAll();
    }

    public void updateTeamName(int id, String teamName) throws TeamNotExistException, TeamNameIsExistException {
        Optional<Team> foundTeam = teamRepository.findTeamById(id);
        List<Team> teams = teamRepository.findAll();
        List<Team> filterTeam = teams.stream().filter(team -> team.getName().equals(teamName)).collect(Collectors.toList());
        if (filterTeam.size()>0){
            throw new TeamNameIsExistException("该组名已存在");
        }
        if (!foundTeam.isPresent()){
            throw new TeamNotExistException("该组不存在");
        }
        foundTeam.get().setName(teamName);
    }
}
