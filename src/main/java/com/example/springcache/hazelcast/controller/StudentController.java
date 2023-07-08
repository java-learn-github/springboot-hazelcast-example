package com.example.springcache.hazelcast.controller;

import com.example.springcache.hazelcast.entity.Student;
import com.example.springcache.hazelcast.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/student")
@CacheConfig(cacheNames = "studentCache")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public List<Student> getStudentList() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id")
    public Student getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping("/{id}")
    @CachePut(key = "#id")
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        return service.updateStudent(student, id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id")
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }
}
