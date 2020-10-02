package com.interview.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class CourierAddDto {

    private String firstName;
    private String lastName;
    private String company;
}
