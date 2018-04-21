package cn.javaxxw.utils;

import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	public void commonSendMail() throws Exception{
		Properties props = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/mail.properties");
		props.load(in);
		// 验证账号及密码，密码需要是第三方授权码 在邮箱里设置
		Authenticator auth = new MailAuthenticator("gent_yang@163.com","130971ywb");
	    Session session = Session.getInstance(props, auth);
	
	    // 2.创建一个Message，它相当于是邮件内容
	     Message message = new MimeMessage(session);
	     // 设置发送者
	     message.setFrom(new InternetAddress("gent_yang@163.com"));
	     //设置发送方式与接收者
	     message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("1471275556@qq.com"));
	     // 设置主题
	     message.setSubject("测试发送邮件");
	     // 设置内容
	     message.setContent("hello world", "text/html;charset=utf-8");
	     // 设置发送日期
	     message.setSentDate(new Date());
	     // 3.创建 Transport用于将邮件发送
	     Transport.send(message);
	}
}
