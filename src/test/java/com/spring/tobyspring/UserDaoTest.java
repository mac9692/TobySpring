package com.spring.tobyspring;

import com.spring.tobyspring.user.dao.DaoFactory;
import com.spring.tobyspring.user.dao.UserDao;
import com.spring.tobyspring.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {

    private User user;
    private User user2;
    private UserDao userDao;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("white10");
        user.setName("박진성");
        user.setPassword("1234");

        userDao.add(user);

        User user2 = userDao.get(user.getId());
    }

    @Test
    void addTest() throws SQLException, ClassNotFoundException {
        userDao.deleteAll();

        if (!user.getName().equals(user2.getName())) {
            System.out.println("테스트 실패 : name");
        } else if (!user.getPassword().equals(user2.getPassword())) {
            System.out.println("테스트 실패 : password");
        } else {
            System.out.println("조회 테스트 성공");
        }
    }
}
