package cn.halfangel.mq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducerTest {
    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "test";

    @Autowired
    public KafkaProducerTest(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    @KafkaListener(id = "test-consumer", topics = {TOPIC})
//    public void listen(ConsumerRecord<String, String> cr) throws Exception {
//        log.debug(Thread.currentThread().getName() + "  {}", cr.value());
//    }

    public String test() {
        kafkaTemplate.send(TOPIC, "UUID", "hahaha");

        return "ahah";
    }
}