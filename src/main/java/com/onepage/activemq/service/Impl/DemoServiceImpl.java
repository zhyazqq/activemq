package com.onepage.activemq.service.Impl;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;
import com.onepage.activemq.service.DemoService;
@Service
public class DemoServiceImpl  implements DemoService {
//	@Resource
//	private ActiveMQConsumer consumer;
//	@Resource
//	private ActiveMQProducer producer; 
	@Override
	public void doIt() {
//		Thread thread=new Thread();
		
//		Thread tt=new Thread(()-> {
			
			System.out.println("hashhhhh");
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			System.out.println("conn success");
			try(Connection connection = connectionFactory.createConnection()){
				System.out.println("--------------開始了");
				connection.start();
				System.out.println("-------------start producer---------------->>>>>>>>>");
//				connection.setExceptionListener((ExceptionListener) this);
				
				 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				 //创建一个目标
				 Destination destination = session.createQueue("TEST.FOO");
				 System.out.println("-------------here producer---------------->>>>>>>>>");
				 //创建一个生产者
				 MessageProducer producer = session.createProducer(destination);
				 //设置消息模式  非持久
				 producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
				 //创建一个消息
				 String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
				 TextMessage message = session.createTextMessage(text);
	                //發送消息
				 producer.send(message);
	              
			}catch (Exception e) {
				System.out.println("error------------->"+e.getMessage());
			}
			//接受消息
//		ActiveMQConnectionFactory factory1 =new ActiveMQConnectionFactory("tcp://localhost:61616");
		System.out.println("-------------here consumer---------------->>>>>>>>>");
		try(Connection connection=connectionFactory.createConnection()){
			//生產者鏈接成功
			System.out.println("生產者鏈接成功");
			connection.start();
			//创建会话
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		System.out.println("-------------here consumer---------------->>>>>>>>>");
		//創建一個目標
		Destination destination= session.createQueue("TEST.FOO");
		//創建一個消費者
		 MessageConsumer consumer = session.createConsumer(destination);
		System.out.println("-------------here consumer---------------->>>>>>>>>");
		//等待消息
		Message message = consumer.receive(1000);
		 if (message instanceof TextMessage) {
             TextMessage textMessage = (TextMessage) message;
             String text = textMessage.getText();
             System.out.println("Received: " + text);
         } else {
             System.out.println("Received: " + message);
         }
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
}
