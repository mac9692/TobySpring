package com.spring.tobyspring.user;

import com.spring.tobyspring.user.dao.DaoFactory;
import com.spring.tobyspring.user.dao.UserDao;
import com.spring.tobyspring.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("white7");
        user.setName("박진성");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + "등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회 성공");
//        DaoFactory factory = new DaoFactory();
//        UserDao dao1 = factory.userDao();
//        UserDao dao2 = factory.userDao();
//        System.out.println(dao1);
//        System.out.println(dao2);
//        System.out.println(dao1.equals(dao2));
//        System.out.println(dao1==dao2);
//
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//
//        UserDao dao3 = context.getBean("userDao", UserDao.class);
//        UserDao dao4 = context.getBean("userDao", UserDao.class);
//
//        System.out.println(dao3);
//        System.out.println(dao4);
//        System.out.println(dao3.equals(dao4));
//        System.out.println(dao3==dao4);
    }
}
