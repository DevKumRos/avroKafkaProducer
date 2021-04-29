package com.kumar.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kumar.domain.Person;
import com.kumar.domain.generated.Employee;
import com.kumar.producer.EmployeeProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class EmployeeRestService {

    @Autowired
    EmployeeProducer employeeProducer;

    @PostMapping("/v1/createEmployee")
    public ResponseEntity<?> createPerson(@Valid @RequestBody Person employee) throws JsonProcessingException {

        employeeProducer.sendEmployee_Approach(employee);

        return ResponseEntity.status(HttpStatus.OK).body("Created SuccessFully");
    }

    @PostMapping("/v2/createEmployee")
    public ResponseEntity<?> createEmpolyee(@Valid @RequestBody Employee employee) throws JsonProcessingException {

        employeeProducer.sendEmployee_Approach2(employee);

        return ResponseEntity.status(HttpStatus.OK).body("Created SuccessFully");
    }
}
