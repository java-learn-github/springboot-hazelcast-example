package com.example.springcache.hazelcast.service;

import com.example.springcache.hazelcast.entity.Student;
import com.example.springcache.hazelcast.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {
        log.info("fetching student information by id from database");
        return repository.findById(Long.valueOf(studentId)).orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Integer studentId) {
        Student stu = repository.findById(Long.valueOf(studentId)).orElse(null);
        Student updateStudent;
        if (null != stu) {
            stu.setAge(student.getAge());
            stu.setFirstName(student.getFirstName());
            stu.setLastName(student.getLastName());
            updateStudent = repository.save(stu);
        } else {
            updateStudent = repository.save(student);
        }

        return updateStudent;
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Student stu = repository.findById(Long.valueOf(studentId)).orElse(null);
        if (null != stu) {
            repository.deleteById(Long.valueOf(studentId));
        }
    }
}
