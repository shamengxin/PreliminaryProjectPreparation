package com.shamengxin.test;

import com.shamengxin.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        //输入流
        InputStream inputStream = null;
        try {
            //通过加载MyBatis的主配置文件mybatis-config.xml,创建输入流对象
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
            SqlSessionFactoryBuilder：SqlSessionFactory的建造者
                通过该建造者对象调用建造方法，为我们创建一个SqlSessionFactory对象

            SqlSessionFactory对象唯一的作用就是为我们创建SqlSession对象

        */
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

        // 我们未来所有的操作，使用的都是SqlSession对象来完成
        //例如增删改查，处理事务等等，都是统一使用session对象来完成
        SqlSession session = sqlSessionFactory.openSession();

        /*

            需求：根据id查单条

                如果取得的是单条记录，我们调用selectOne方法
                参数1：根据命名空间.sqlId的形式找到我们需要使用sql语句
                参数2：我们要为sql语句中传递的参数

         */
        /*Student s=session.selectOne("test1.getById","A0001");
        System.out.println(s);
        session.close();*/

        //查询学生信息表中所有的记录
        /*List<Student> sList=session.selectList("test1.getAll");
        for (Student s : sList) {
            System.out.println(s);
        }
        session.close();*/

        /*

            MyBatis默认情况下是手动提交事务

         */
        //添加操作
        /*Student s=new Student();
        s.setId("A0006");
        s.setName("cxk");
        s.setAge(23);
        int count = session.insert("test1.save", s);
        session.commit();
        session.close();*/

        //修改操作
       /* Student s=new Student();
        s.setId("A0006");
        s.setName("cxk");
        s.setAge(24);
        session.update("test1.update",s);
        session.commit();
        session.close();*/

        //删除操作
        session.delete("test1.delete","A0006");
        session.commit();
        session.close();
    }

}
