package com.interview.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class CourierAddDto {

    private String firstName;
    private String lastName;
    private String company;
}
