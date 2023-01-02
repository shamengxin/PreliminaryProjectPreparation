package com.shamengxin.service;

import com.shamengxin.domain.Student;

import java.util.List;

public interface StudentService {

    public Student getById(String id);

    public void save(Student s);

    List<Student> getAll();
}
