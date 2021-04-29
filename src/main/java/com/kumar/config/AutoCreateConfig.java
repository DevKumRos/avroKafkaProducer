package com.kumar.config;


import com.kumar.domain.generated.Employee;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import io.confluent.kafka.serializers.KafkaAvroSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AutoCreateConfig {

	private String KAFKA_BROKERS = "localhost:9092, localhost:9093, localhost:9094";

	@Bean
	public KafkaTemplate<Integer, String> kafkaTemplate_SerializerAndDeserializer() {
		final KafkaTemplate<Integer, String> kafkaTemplate = new KafkaTemplate(this.producerFactory_SerializerAndDeserializer());
		return kafkaTemplate;
	}
	@Bean
	public KafkaTemplate<Integer, Employee> kafkaTemplate_AvroSerializerAndDeserializer() {
		final KafkaTemplate<Integer, Employee> kafkaTemplate = new KafkaTemplate(this.producerFactory_AvroSerializerAndDeserializer());
		return kafkaTemplate;
	}

	private ProducerFactory<String, Employee> producerFactory_SerializerAndDeserializer() {
		final Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKERS);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return new DefaultKafkaProducerFactory<>(props);
	}

	private ProducerFactory<String, Employee> producerFactory_AvroSerializerAndDeserializer() {
		final Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKERS);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
		props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,"http://localhost:8081");

		return new DefaultKafkaProducerFactory<>(props);
	}
}
