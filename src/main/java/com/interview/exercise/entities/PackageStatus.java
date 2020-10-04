package com.interview.exercise.entities;

import lombok.ToString;

@ToString
public enum PackageStatus {
    WAITING_FOR_COURIER, WENT_TO_COURIER, ON_THE_ROAD, ARRIVED
}
