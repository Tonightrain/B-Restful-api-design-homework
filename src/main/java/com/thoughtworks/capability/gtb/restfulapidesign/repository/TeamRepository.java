package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domian.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domian.Team;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TeamRepository {
    private static final int TEAM_NUMBER = 6;
    private List<Team> teams;
    private final StudentRepository studentRepository;

    public TeamRepository(List<Team> teams, StudentRepository studentRepository){
        this.studentRepository = studentRepository;
        this.teams = new ArrayList<>();
        init();
    }

    public List<Team> init(){
        for (int i = 1; i < TEAM_NUMBER+1 ; i++) {
            Team newTeam = Team.builder().id(i).name("Team " + i).teamStudentList(new ArrayList<>()).build();
            teams.add(newTeam);
        }
        return teams;
    }

    public List<Team> findAll(){
        return teams;
    }

    public Optional<Team> findTeamById(int id) {
        return teams.stream().filter(team -> team.getId() == id).findFirst();
    }

    public List<Team> groupStudents() {
        List<Student> studentList = studentRepository.getStudentList();
        Collections.shuffle(studentList);
        for (Team team : teams) {
            if (team.getTeamStudentList() != null)
            team.clean();
        }
        int team = 0;
        for (Student student : studentList){
            teams.get(team).addStudent(student);
            team = team == 5 ? 0 : team++;
        }
        return teams;
    }
}
