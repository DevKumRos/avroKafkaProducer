package com.kumar.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {
    @NotNull
    private Integer empId;
    @NotBlank
    private String empName;
    @NotBlank
    private String department;
}
