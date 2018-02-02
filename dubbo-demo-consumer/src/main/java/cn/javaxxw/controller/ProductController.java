package cn.javaxxw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.javaxxw.model.Product;
import cn.javaxxw.service.ProductService;

/**
 * @author tuyong
 * @version 1.0
 * @desc
 * @create 2017-11-29 15:38
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("add")
    public Object add(String pname,double price){
        Product product = productService.addProduct(pname,price);
        return product.toString();
    }
    //xxx12345
    @GetMapping("findProduct")
    public ModelAndView findProduct(){
    	List<Product> list = productService.findAllProducts();
    	Map<String, List> map = new HashMap<>();
    	map.put("product", list);
    	return new ModelAndView("index",map);
    }

}
