package spring.rabbitmq.publisher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rabbitmq.publisher.utils.RabbitMessageUtils;

@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // TODO: Phải tạo queue trước khi push msg vào RabbitMQ
    String queue = "neko_queue";

    public void sendMessage(String type, String message) {
        MsgModel msgModel = new MsgModel();
        msgModel.setMsg(message);
        ObjectMapper mapper = new ObjectMapper();
        try {
            rabbitTemplate.convertAndSend(queue, (Object) mapper.writeValueAsString(msgModel), RabbitMessageUtils.messageHeader(type, null));
            System.out.println("Message " + type + " sent: " + (Object) mapper.writeValueAsString(msgModel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
