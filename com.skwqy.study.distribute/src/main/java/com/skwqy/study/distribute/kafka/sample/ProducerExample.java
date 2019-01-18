package com.skwqy.study.distribute.kafka.sample;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/23 6:27 PM
 */
public class ProducerExample {

    private static final Logger LOG = LoggerFactory.getLogger(ProducerExample.class);
    public static void main(String[] args) {
        LOG.info("Producer begin");
        System.out.println("Producer begin");
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Topic 不存在的话会自动创建topic
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<>("topic1", Integer.toString(i), "skwqy"+Integer.toString(i)));
            LOG.info("send info by index = {}",i);
        }
        producer.close();
        LOG.info("Producer end");
    }
}
