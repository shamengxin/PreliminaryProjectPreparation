package com.shamengxin.service;

import com.shamengxin.domain.Student;

public interface StudentService {

    public Student getById(String id);

    public void save(Student s);

}
