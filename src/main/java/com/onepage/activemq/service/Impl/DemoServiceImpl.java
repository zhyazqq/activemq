package com.onepage.activemq.service.Impl;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
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
		
		Thread tt=new Thread(()-> {
			
			System.out.println("hashhhhh");
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
			System.out.println("conn success");
			try(Connection connection = connectionFactory.createConnection()){
				connection.start();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("-------------start producer---------------->>>>>>>>>");
//				connection.setExceptionListener((ExceptionListener) this);
				
				 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				 
				 Destination destination = session.createQueue("TEST.FOO");
				 System.out.println("-------------here producer---------------->>>>>>>>>");
				 MessageConsumer consumer = session.createConsumer(destination);
				 Message message = consumer.receive(1000);
				  if (message instanceof TextMessage) {
	                  TextMessage textMessage = (TextMessage) message;
	                  String text = textMessage.getText();
	                  System.out.println("Received: " + text);
	              } else {
	                  System.out.println("Received: " + message);
	              }
			}catch (Exception e) {
				System.out.println("error------------->"+e.getMessage());
			}
			
		});
		tt.setDaemon(false);
		tt.start();
//	System.out.println("hashhhhh");
//		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
//		System.out.println("conn success");
//		try(Connection connection = connectionFactory.createConnection()){
//			connection.start();
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			System.out.println("-------------start producer---------------->>>>>>>>>");
////			connection.setExceptionListener((ExceptionListener) this);
//			
//			 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			 
//			 Destination destination = session.createQueue("TEST.FOO");
//			 System.out.println("-------------here producer---------------->>>>>>>>>");
//			 MessageConsumer consumer = session.createConsumer(destination);
//			 Message message = consumer.receive(1000);
//			  if (message instanceof TextMessage) {
//                  TextMessage textMessage = (TextMessage) message;
//                  String text = textMessage.getText();
//                  System.out.println("Received: " + text);
//              } else {
//                  System.out.println("Received: " + message);
//              }
//		}catch (Exception e) {
//			System.out.println("error------------->"+e.getMessage());
//		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ActiveMQConnectionFactory factory1 =new ActiveMQConnectionFactory();
		System.out.println("-------------here consumer---------------->>>>>>>>>");
		try(Connection connection=factory1.createConnection()){
			connection.start();
			//创建会话
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		System.out.println("-------------here consumer---------------->>>>>>>>>");
		Destination destination= session.createQueue("TEST.FOO");
		MessageProducer producer =session.createProducer(destination);
		System.out.println("-------------here consumer---------------->>>>>>>>>");
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		//创建消息
		System.out.println("打印消息-----------》");
		 String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
         TextMessage message = session.createTextMessage(text);
         //发送消息
         producer.send(message);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
}
