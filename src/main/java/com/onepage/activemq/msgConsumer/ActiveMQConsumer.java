package com.onepage.activemq.msgConsumer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;
@Component
public class ActiveMQConsumer {

	public void consumer() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
		try(Connection connection = connectionFactory.createConnection()){
			connection.start();
			
			connection.setExceptionListener((ExceptionListener) this);
			
			 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			 
			 Destination destination = session.createQueue("TEST.FOO");
			 
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
			System.out.println(e);
		}
		
        
	}
}
