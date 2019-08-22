package com.navisow.processes;

import com.navisow.models.AppointmentProcedure;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Sort01 implements Process {
    private static final Logger logger = Logger.getLogger(Sort01.class);

    public void go() {
        List<AppointmentProcedure> appointmentProcedures = new ArrayList<>();
        appointmentProcedures.add(new AppointmentProcedure(true, 1));
        appointmentProcedures.add(new AppointmentProcedure(false, 2));
        appointmentProcedures.add(new AppointmentProcedure(true, 3));
        appointmentProcedures.add(new AppointmentProcedure(false, 4));
        appointmentProcedures.add(new AppointmentProcedure(true, 5));

        logger.info("appointmentProcedures:");
        appointmentProcedures.forEach(p ->
            logger.info(String.format("{ historyId: %d, primaryProcedure: %b }",
                p.getHistoryId(), p.isPrimaryProcedure()))
        );

        List<AppointmentProcedure> sortedAppointments =
            appointmentProcedures.stream()
                .filter(AppointmentProcedure::isPrimaryProcedure)
                .sorted((p1, p2) -> Integer.compare(p2.getHistoryId(), p1.getHistoryId()))
                .collect(toList());

        logger.info("sortedAppointments:");
        sortedAppointments.forEach(p ->
            logger.info(String.format("{ historyId: %d, primaryProcedure: %b }",
                p.getHistoryId(), p.isPrimaryProcedure()))
        );
    }
}
