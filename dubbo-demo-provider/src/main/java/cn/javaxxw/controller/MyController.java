package cn.javaxxw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.javaxxw.model.User;
import cn.javaxxw.service.UserService;

/**
 * @author tuyong
 * @version 1.0
 * @desc
 * @create 2017-11-29 15:38
 **/
@RestController
@RequestMapping("/user")
public class MyController {

    @Autowired
    private UserService userService;

    //ywb222
    @GetMapping("findProduct")
    public ModelAndView findProduct(){
    	List<User> list = userService.findAllUsers();
    	Map<String, List> map = new HashMap<>();
    	map.put("user", list);
    	return new ModelAndView("index",map);
    }

}
