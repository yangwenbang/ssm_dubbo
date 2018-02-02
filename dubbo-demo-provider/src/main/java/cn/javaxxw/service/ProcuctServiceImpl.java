package cn.javaxxw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javaxxw.mapper.ProductMapper;
import cn.javaxxw.model.Product;
import cn.javaxxw.model.User;
import cn.javaxxw.utils.MD5Util;

@Service("productService")
public class ProcuctServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public Product addProduct(String pname, double price) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setPname(pname);
		product.setPrice(price);
		productMapper.insert(product);
		return null;
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
