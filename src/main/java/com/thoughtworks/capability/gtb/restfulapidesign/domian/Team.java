package com.thoughtworks.capability.gtb.restfulapidesign.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private int id;
    private String name;
    private String note;
    private List<Student> teamStudentList;

    public Team(int id,String name){
        this.id = id;
        this.name = name;
    }

    public void clean() {
        teamStudentList.clear();
    }

    public void add(Student student) {
        teamStudentList.add(student);
    }
}
