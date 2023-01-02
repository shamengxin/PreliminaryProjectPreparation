package com.shamengxin.dao;

import com.shamengxin.domain.Student;

import java.util.List;

public interface StudentDao {

    public Student getById(String id);

    public void save(Student s);

    List<Student> getAll();
}
