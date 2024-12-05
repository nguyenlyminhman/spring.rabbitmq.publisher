package spring.rabbitmq.publisher.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // TODO: Phải tạo queue trước khi push msg vào RabbitMQ
    String queue = "Neko.Queue";

    public void sendMessage(String message) {
        try {
             rabbitTemplate.convertAndSend(queue, message);
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("Message sent: " + message);
    }
}
