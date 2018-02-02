package cn.javaxxw.service;

import java.util.List;

import cn.javaxxw.model.Product;

public interface ProductService {

    /**
     *新增用户
     * @param
     * @return
     */
    Product addProduct(String pname,double price);

    /**
     *查询所有用户
     * @return
     */
    List<Product> findAllProducts();
}
