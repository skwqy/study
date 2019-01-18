package com.skwqy.study.distribute.kafka.sample;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/23 6:27 PM
 */
public class ConsumerExample {
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerExample.class);

    public static void main(String[] args) {
        LOG.info("Consumer begin");
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "testttt");
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("topic1"));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                LOG.info("Get Msg number = {}", records.count());
                for (ConsumerRecord<String, String> record : records) {
                    LOG.info("topic = {}, partition = {},offset = {}, key = {}, value = {}", record.topic(),
                            record.partition(), record.offset(), record.key(), record.value());
                }
            }
        } finally {
            consumer.close();
        }
    }

}
