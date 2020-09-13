package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domian.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentsNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.getStudentList();
    }

    public void addStudent(Student student) {
        studentRepository.add(student);
    }

    public void deleteStudent(int id) throws StudentsNotExistException {
        Optional<Student> student = studentRepository.findStudentById(id);
        if (!student.isPresent()){
            throw new StudentsNotExistException("该学生不存在");
        }
        studentRepository.deleteStudentById(id);
    }

    public Student getOneStudent(int id) throws StudentsNotExistException {
        Optional<Student> student = studentRepository.findStudentById(id);
        if (!student.isPresent()){
            throw new StudentsNotExistException("该学生不存在");
        }
        return student.get();
    }
}
