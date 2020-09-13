package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domian.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domian.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> studentList;

    public StudentRepository() {
        this.studentList = new ArrayList<>();
        Student student = Student.builder().id(1).name("Mike").gender(Gender.FEMALE).note("new student").build();

        studentList.add(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void add(Student student) {
        student.setId(studentList.size()+1);
        studentList.add(student);
    }

    public Optional<Student> findStudentById(int id) {
        return studentList.stream().filter(student -> student.getId() == id).findFirst();
    }

    public void deleteStudentById(int id) {
        studentList.remove(id-1);
    }

    public List<Student> getStudentListByGender(Integer gender) {
        List<Student> studentListByGender = studentList.stream().filter(student -> student.getGender().getOrdinal() == gender.intValue()).collect(Collectors.toList());
        return studentListByGender;
    }
}
