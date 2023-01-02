package com.shamengxin.service.impl;

import com.shamengxin.dao.StudentDao;
import com.shamengxin.dao.impl.StudentDaoImpl;
import com.shamengxin.domain.Student;
import com.shamengxin.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public Student getById(String id) {

        Student s = studentDao.getById(id);

        return s;
    }

    @Override
    public void save(Student s) {

        studentDao.save(s);

    }
}
