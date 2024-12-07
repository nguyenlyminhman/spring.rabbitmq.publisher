package spring.rabbitmq.publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.rabbitmq.publisher.service.RabbitMQSender;

@RestController
@RequestMapping("/api/rabbitmq")
public class RabbitMQController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String type, @RequestParam String message) {
        rabbitMQSender.sendMessage(type, message);
        return "Message sent: " + message;
    }
}
