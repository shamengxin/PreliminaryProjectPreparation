package com.shamengxin.service.impl;

import com.shamengxin.dao.StudentDao;
import com.shamengxin.domain.Student;
import com.shamengxin.service.StudentService;
import com.shamengxin.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

    @Override
    public Student getById(String id) {

        Student s = studentDao.getById(id);

        return s;
    }

    @Override
    public void save(Student s) {

        studentDao.save(s);

    }

    @Override
    public List<Student> getAll() {

        List<Student> sList = studentDao.getAll();

        return sList;
    }
}
