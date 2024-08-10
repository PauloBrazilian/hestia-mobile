package hestia.ms_notification.framework.adapters.out.queue.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendResponseWelcome(String message) {
        try {
            kafkaTemplate.send("topic", message);
        } catch (Exception e) {
            throw new RuntimeException("Error sending message to Kafka", e);
        }
    }

}