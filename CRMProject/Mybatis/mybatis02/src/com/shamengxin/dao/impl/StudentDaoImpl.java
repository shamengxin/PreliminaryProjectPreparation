package com.shamengxin.dao.impl;

import com.shamengxin.dao.StudentDao;
import com.shamengxin.domain.Student;
import com.shamengxin.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student getById(String id) {

        SqlSession session= SqlSessionUtil.getSession();

        Student s = session.selectOne("test1.getById",id);

        return s;

    }

    @Override
    public void save(Student s) {

        SqlSession session= SqlSessionUtil.getSession();

        session.insert("test1.save",s);

    }
}
