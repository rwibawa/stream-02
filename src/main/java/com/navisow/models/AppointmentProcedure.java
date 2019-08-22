package com.navisow.models;

import lombok.Value;

@Value
public class AppointmentProcedure {
    private boolean primaryProcedure;
    private int historyId;
}
