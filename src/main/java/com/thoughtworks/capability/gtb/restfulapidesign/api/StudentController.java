package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domian.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domian.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentsNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) throws StudentsNotExistException {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOneStudent(@PathVariable int id) throws StudentsNotExistException {
        return ResponseEntity.ok(studentService.getOneStudent(id));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @RequestBody Student student) throws StudentsNotExistException {
        studentService.updateStudent(id,student);
        return ResponseEntity.noContent().build();
    }

}