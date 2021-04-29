package com.kumar.producer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kumar.domain.Person;
import com.kumar.domain.generated.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class EmployeeProducer {

    private String TOPIC = "employee-events";
    private String PERSON_TOPIC = "person-events";

    @Autowired
    @Qualifier("kafkaTemplate_AvroSerializerAndDeserializer")
    KafkaTemplate<Integer, Employee> kafkaTemplate;

    @Autowired
    @Qualifier("kafkaTemplate_SerializerAndDeserializer")
    KafkaTemplate<Integer, String> kafkaTemplateEmp;

    @Autowired
    ObjectMapper objectMapper;

    public ListenableFuture<SendResult<Integer, String>> sendEmployee_Approach(Person employee) throws JsonProcessingException {
        Integer key = employee.getEmpId();
        String value = objectMapper.writeValueAsString(employee);
        ProducerRecord<Integer, String> producerRecord = createProducerRecord(key, value);
        //read topic from application.properties
        ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplateEmp.send(producerRecord);
        listenableFutureCallbackString(key, value, listenableFuture);
        return listenableFuture;
    }

    public ListenableFuture<SendResult<Integer, Employee>> sendEmployee_Approach2(Employee employee) throws JsonProcessingException {
        Integer key = employee.getEmpId();
        ProducerRecord<Integer, Employee> producerRecord = createProducerRecord(key, employee);
        //read topic from application.properties
        ListenableFuture<SendResult<Integer, Employee>> listenableFuture = kafkaTemplate.send(producerRecord);
        listenableFutureCallback(key, employee, listenableFuture);
        return listenableFuture;
    }

    private ProducerRecord<Integer, String> createProducerRecord(Integer key, String value) {
        // Header to pass additional information & consumer can consume based on header
        List<Header> recordHeader = new ArrayList<>();
        recordHeader.add(new RecordHeader("event-source", "scanner".getBytes()));
        recordHeader.add(new RecordHeader("event-source", "mannual".getBytes()));

        return new ProducerRecord<Integer, String>(PERSON_TOPIC, null, key, value, recordHeader);
    }

    private ProducerRecord<Integer, Employee> createProducerRecord(Integer key, Employee employee) {
        // Header to pass additional information & consumer can consume based on header
        List<Header> recordHeader = new ArrayList<>();
        recordHeader.add(new RecordHeader("event-source", "scanner".getBytes()));
        recordHeader.add(new RecordHeader("event-source", "mannual".getBytes()));

        return new ProducerRecord<Integer, Employee>(TOPIC, null, key, employee, recordHeader);
    }



    private void listenableFutureCallback(Integer key, Employee value, ListenableFuture<SendResult<Integer, Employee>> listenableFuture) {
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, Employee>>() {

            @Override
            public void onSuccess(SendResult<Integer, Employee> result) {
                // TODO Auto-generated method stub
                handleSuccess(key, value, result);
            }


            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);

            }

        });
    }

    private void listenableFutureCallbackString(Integer key, String value, ListenableFuture<SendResult<Integer, String>> listenableFuture) {
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                // TODO Auto-generated method stub
                log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
                log.info("RecordMeta ="+result.getRecordMetadata().toString());
            }


            @Override
            public void onFailure(Throwable ex) {
                log.error("Error while sending the message & exception is {}", ex.getMessage());

            }

        });
    }

    protected void handleFailure(Integer key, Employee value, Throwable ex) {
        log.error("Error while sending the message & exception is {}", ex.getMessage());

    }

    private void handleSuccess(Integer key, Employee value, SendResult<Integer, Employee> result) {
        // TODO Auto-generated method stub
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
        log.info("RecordMeta ="+result.getRecordMetadata().toString());
    }
}
