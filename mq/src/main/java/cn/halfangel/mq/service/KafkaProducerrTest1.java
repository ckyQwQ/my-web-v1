package cn.halfangel.mq.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaProducerrTest1 {
    private final KafkaProducer<String, String> producer;
    private final String topic;

    public KafkaProducerrTest1(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.0.2.59:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        this.producer = new KafkaProducer<>(props);
        this.topic = topicName;
    }

    public Future<RecordMetadata> send() {
        return producer.send(new ProducerRecord<>(topic, "Message", "dfadfasdf"));
    }
}
