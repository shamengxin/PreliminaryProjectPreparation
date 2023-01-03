package com.shamengxin.test;

import com.shamengxin.dao.StudentDao;
import com.shamengxin.domain.Student;
import com.shamengxin.util.SqlSessionUtil;
import com.shamengxin.vo.StudentAndClassroomvo;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {

        StudentDao studentDao= SqlSessionUtil.getSession().getMapper(StudentDao.class);

        //测试：parameterType 使用简单数据类型 String
        /*Student s =studentDao.select1("A0001");
        System.out.println(s);*/

        //测试：parameterType 使用简单数据类型 int
        //查询除所有年龄为23岁的学员的详细信息
        /*List<Student> sList = studentDao.select2(23);
        for(Student s:sList){
            System.out.println(s);
        }*/

        //3.测试：parameterType
        //需求：查询出姓名为wyf，年龄为23的学员信息
        /*
            绝对不可以像下面的案例一样同时为sql语句传递多个参数
        */
        /*List<Student> sList = studentDao.select3("wyf",23);
        for(Student s:sList){
            System.out.println(s);
        }*/

        // 如果我们要为sql语句传递多个参数，我们应该将者多个参数封装到一个domain对象中，或者是打包到一个map集合中
        //4.测试：parameterType，使用domain为参数 Student s
        // 需求：查询出姓名为wyf，年龄为23岁的学员信息
        /*Student s=new Student();
        s.setName("wyf");
        s.setAge(23);
        List<Student> sList = studentDao.select4(s);
        for(Student s1:sList){
            System.out.println(s1);
        }*/

        //5.测试：parameterType，使用map为参数
        // 需求：查询出姓名为wyf，年龄为23岁的学员信息
        /*Map<String, Object> map=new HashMap<String,Object>();
        map.put("name","wyf");
        map.put("age",23);
        List<Student> sList = studentDao.select5(map);
        for (Student s:sList){
            System.out.println(s);
        }*/

        /*

            总结：
                在实际项目开发中，使用daomain引用类型，或者是使用map集合类型都可以为sql语句同时传递多个参数

                一般情况下，我们使用domain就可以了
                当domain不符合需求的情况下，我们一定要考虑使用map来传值

                需求：请查询出 姓名为wyf，班级为一年一班的学员的详细信息

                select
                *
                from tbl_student s
                join tbl_classroom c
                on s.classroomId=c.id

                where s.name=#{wyf} and c.name=#{一年一班}

        */

        /*
            在实际项目开发中，一定要学会使用为sql传值的这几种方式
            但是对于在<select>中的parameterType属性，一般我们都是省略不写的
         */

        //6.测试：根据id查单条 sql使用${}来接收值
        /*Student s=studentDao.select6("A0001");
        System.out.println(s);*/

        //7.测试，like模糊查询 方式1：使用${} 了解
        /*List<Student> sList= studentDao.select7("z");
        for (Student s:sList) {
            System.out.println(s);
        }*/

        //8.测试：like模糊查询 方式2：使用#{} 了解
        /*List<Student> sList= studentDao.select8("%z%");
        for (Student s:sList) {
            System.out.println(s);
        }*/

        //9.测试：like模糊查询 方式3：使用#{} 掌握
        /*List<Student> sList= studentDao.select9("z");
        for (Student s:sList) {
            System.out.println(s);
        }*/

        //10.测试：resultType 返回String类型
        // 需求：查询出编号为A0001的学员
        /*String name=studentDao.select10("A0001");
        System.out.println(name);*/

        //11.测试：resultType 返回String类型集合
        // 需求：查询出所有学生的姓名
        /*List<String> sList=studentDao.select11();
        for(String name:sList){
            System.out.println(name);
        }*/

        //12.测试：resultType 返回int类型
        // 需求：查询出表中一共有多少条信息
        /*int count=studentDao.select12();
        System.out.println(count);*/

        //13.测试：resultType 返回domain引用类型Student 略过

        //14.测试：resultType 返回map类型
        /*

            <select id="" resultType="Student">

                select * from tbl_student

            </select>

            当我们执行了sql语句之后，通过查询得到的结果 id，name，age
            根据返回值类型，会自动为我们创建出来一个该类型的对象，由该对象将查询的结果封装起来
            Student s1=new Student();
            s1.setId("A0001");
            s1.setName("wyf");
            s1.setAge(23);

            当查询出来第二条记录，根据返回值类型，再一次创建出来一个对象，封装第二条记录的值
            Student s2=new Student();
            s2.setId("A0002");
            s2.setName("lh");
            s2.setAge(24);
            ......
            ......
            Student s6=new Student();
            s6.setId("A0006");
            s6.setName("cxk");
            s6.setAge(24);

            多条记录封装成为了多个Student对象
            系统会自动为我们创建出来一个List集合来保存这些对象
            List<Student> sList=new ArrayList<>();
            sList.add(s1);
            sList.add(s2);
            ...
            sList.add(s6);
            --------------------------------------------------------------------

            <select id="select14" resultType="map">

                select * from tbl_student

            </select>
            当执行了sql语句之后，通过查询得到的结果 id，name,age
            根据返回值类型，会自动为我们创建出来一个该类型的对象，由该对象将查询的结果保存起来
            Map<String,Object> map1 = new HashMap();
            map1.put("id","A0001");
            map1.put("name","wyf");
            map1.put("age",23);

            当查询出来第二条记录，根据返回值类型，再一次创建出来一个对象，封装第二条记录的值
            Map<String,Object> map2 = new HashMap();
            map2.put("id","A000");
            map2.put("name","lh");
            map2.put("age",24);
            ...
            ..
            map6

            多条记录封装成为了多个map对象
            系统会自动为我们创建出来一个List集合来保存map对象
            List<Map<String,Object>> sList=new ArrayList<>();
            sList.add(map1);
            sList.add(map2);
            ...
            sList.add(map6);
         */

        /*

            对于sql语句查询的结果，我们使用domain来封装这些结果多方便，为什么还要使用map呢？

            因为对于查询的结果，有很多情况，使用domain封装不了，所以我们回想到使用map来保存结果

            例如：
                需求根据姓名分组，查询出来每一个姓名对应的数量
                叫wyf的有多少人
                叫lh的有多少人
                ...

                select

                name,count(*)

                from tab_student

                group by name

                对于以上的查询结果，使用domain能封装查询结果吗？
                不能！因为domain有name属性，但是没有count属性

                使用返回map一定可以保存查询的到的结果


         */
        /*List<Map<String , Object>> mapList=studentDao.select14();
        for (Map<String,Object> map:mapList){

            Set<String> set = map.keySet();
            for (String key:set){
                System.out.println("key="+key);
                System.out.println("value="+map.get(key));
            }
            System.out.println("-------------------------------------");

        }*/

        //15.测试：resultType 当数据库表字段名称和domain类属性名称不一致时的处理 方式1：起别名
       /*List<Student> sList = studentDao.select15();
        for (Student s:sList) {
            System.out.println(s);
        }*/

        //16.测试：resultType 当数据库表字段名称和domain类属性名称不一致时的处理 方式2：resultMap
        /*List<Student> sList = studentDao.select16();
        for (Student s:sList) {
            System.out.println(s);
        }*/

        //17.测试：动态sql，where标签+if标签
        /*Student s = new Student();
        // s.setName("y");
        s.setAddress("a");
        List<Student> sList=studentDao.select17(s);
        for (Student s1:sList) {
            System.out.println(s1);
        }*/

        //18.测试：动态sql foreach标签
        //查询编号为A0001，A0002,A0003
        /*String strArr[]={"A0001","A0002","A0003"};
        List<Student> sList=studentDao.select18(strArr);
        for (Student s1:sList) {
            System.out.println(s1);
        }*/

        //19.测试：sql片段
        /*Student s=studentDao.select19("A0001");
        System.out.println(s);*/

        //20.测试：多表联查 （1）查询出学生姓名和班级名称
        /*List<Map<String,Object>> mapList = studentDao.select20();
        for (Map<String,Object> map:mapList){
            Set<String> set = map.keySet();
            for(String key:set){
                System.out.println("key:"+key);
                System.out.println("value:"+map.get(key));
            }
            System.out.println("------------------------------------");
        }*/

        //21.测试：多表联查 查询出学生和班级所有信息，加VO（value Object）
        /*

            在实际项目开发中，如果需要为前端展现的数据，使用一个domain类型不足以表现出阿里这些数据
            这时我们可以考虑使用两种技术来实现
            分别为：
                使用map以及使用vo

            例如我们现在的需求
                查询学生和班级的所有信息
                得到的结果 使用学生的domain或者班级的domain都不能够封装这些结果

                所以我们可以使用map去保存这些信息
                同时我们也可以使用vo类来保存这些信息

                vo指的是创建出来一个类，这个类中的属性是完全由我们自己去定义，属性会包含所有需要展现的信息
                例如我们现在的这个例子，我们可以使用vo来封装所有与学生和班级相关的信息

                vo
                    student
                    classroom
         */

        /*List<StudentAndClassroomvo> voList = studentDao.select21();
        for (StudentAndClassroomvo vo:voList){

            System.out.println(vo);

        }*/

        //22.测试：多表联查 查询出带有字母z的学生和班级所有信息
        /*List<StudentAndClassroomvo> voList = studentDao.select22("z");
        for (StudentAndClassroomvo vo:voList){

            System.out.println(vo);

        }*/

        /*

            实际项目开发中，如果要为前端同时提供多组值，那么我们应该使用map还是vo呢？

            如果前端的需求的重复率不高，那么我们选择临时使用map就可以了
            如果前端对于该需求的重复率较高，那么我们可以创建一个vo类来使用，非常方便

        */

    }
}
