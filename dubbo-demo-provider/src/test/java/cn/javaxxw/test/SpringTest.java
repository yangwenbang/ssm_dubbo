package cn.javaxxw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import cn.javaxxw.model.User;
import cn.javaxxw.service.UserService;
import cn.javaxxw.utils.MD5Util;

/**
 * @author tuyong
 * @version 1.0
 * @desc
 * @create 2017-11-29 15:54
 **/
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-context.xml")
public class SpringTest {
   
    @Autowired
    private UserService userService;

    @Test
    public void testAddUser(){
        List<User> user = userService.findAllUsers();
        System.out.println(user);
    }


}
*/