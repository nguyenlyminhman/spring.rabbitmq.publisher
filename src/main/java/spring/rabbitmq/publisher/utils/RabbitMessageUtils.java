package spring.rabbitmq.publisher.utils;

import org.springframework.amqp.core.MessagePostProcessor;

import java.util.HashMap;
import java.util.Objects;

public class RabbitMessageUtils {


    public static MessagePostProcessor messageHeader(String msgType, HashMap<String, Objects> messageProperties) {
        // Tạo MessagePostProcessor để thêm header
        return msg -> {
            msg.getMessageProperties().getHeaders().put("MsgType", msgType);

            if (messageProperties != null) {
                messageProperties.forEach((key, value) -> {
                    try {
                        msg.getMessageProperties().getHeaders().put(key, value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                });
            }
            return msg;
        };
    }
}
