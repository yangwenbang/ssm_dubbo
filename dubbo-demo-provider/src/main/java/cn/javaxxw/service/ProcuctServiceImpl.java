package cn.javaxxw.service;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import cn.javaxxw.mapper.ProductMapper;
import cn.javaxxw.model.Product;

@Service("productService")
public class ProcuctServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper productMapper;
	
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
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

	

	public void sendMessage(Destination destination,final String msg){
		System.out.println("Send " + msg + " to Destination " + destination.toString());
        MessageCreator messageCreator = new MessageCreator(){

            public Message createMessage(Session session) throws JMSException {

                return session.createTextMessage(msg);
           }
            
        };
        jmsTemplate.send(destination, messageCreator);
    }
	
	public void sendMessage(final String msg){
		Destination destination = jmsTemplate.getDefaultDestination();
        System.out.println("Send " + msg + " to Destination " + destination.toString());
        MessageCreator messageCreator = new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                // TODO Auto-generated method stub
                return session.createTextMessage(msg);
            }
            
        };
        jmsTemplate.send(messageCreator);
	}
}
