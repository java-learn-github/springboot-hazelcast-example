package com.example.springcache.hazelcast.service;

import com.example.springcache.hazelcast.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Integer studentId);

    Student createStudent(Student student);

    Student updateStudent(Student student, Integer studentId);

    void deleteStudent(Integer studentId);


}
