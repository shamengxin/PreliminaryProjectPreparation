package com.shamengxin.dao;

import com.shamengxin.domain.Student;

public interface StudentDao {

    public Student getById(String id);

    public void save(Student s);

}
