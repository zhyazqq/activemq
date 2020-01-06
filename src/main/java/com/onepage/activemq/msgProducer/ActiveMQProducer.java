package com.onepage.activemq.msgProducer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;




@Component
public class ActiveMQProducer {

	
	public void producer() {
		//创建来连接工厂
		ActiveMQConnectionFactory factory =new ActiveMQConnectionFactory();
	
		try(Connection connection=factory.createConnection()){
			connection.start();
			//创建会话
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination= session.createQueue("TEST.FOO");
		MessageProducer producer =session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		//创建消息
		 String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
         TextMessage message = session.createTextMessage(text);
         //发送消息
         producer.send(message);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
}
