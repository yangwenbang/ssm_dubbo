package cn.javaxxw.service;

import java.util.List;

import javax.jms.Destination;

import cn.javaxxw.model.Product;

public interface ProductService {

    /**
     *新增用户
     * @param
     * @return
     */
	public Product addProduct(String pname,double price);

    /**
     *查询所有用户
     * @return
     */
	public List<Product> findAllProducts();
    
    public void sendMessage(final String msg);
    
    public void sendMessage(Destination destination, final String msg);
    
}
