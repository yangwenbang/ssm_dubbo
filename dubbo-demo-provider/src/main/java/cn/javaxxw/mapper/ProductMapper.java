package cn.javaxxw.mapper;

import java.util.List;

import cn.javaxxw.model.Product;

public interface ProductMapper {
	 /**
     * 插入记录
     * @param user
     * @return
     */
    int insert(Product product);
    /**
     * 查询所有记录
     * @return
     */
    List<Product> selectAll();
}
