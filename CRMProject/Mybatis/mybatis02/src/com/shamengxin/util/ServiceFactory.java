package com.shamengxin.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceFactory {

    //自我改进，将TransactionInvocationHandler类与ServiceFactory类中的功能在一起实现
    public static Object getService(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                SqlSession session=null;
                Object obj=null;

                try {

                    session=SqlSessionUtil.getSession();

                    //处理业务逻辑
                    obj=method.invoke(target,args);

                    //处理业务逻辑完毕后，提交事务
                    //就是功能增强
                    session.commit();

                } catch (Exception e) {

                    session.rollback();

                    e.printStackTrace();
                }finally {
                    SqlSessionUtil.myClose(session);
                }

                return obj;
            }
        });
    }

    // 传递对象的过程
    /*public static Object getService(Object service){
        return  new TransactionInvocationHandler(service).getProxy();
    }*/

}
