package org.example.application;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTime {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        LocalDate dt01 = LocalDate.now();
        LocalDateTime dt02 = LocalDateTime.now();
        Instant dt03 = Instant.now();
        LocalDate dt04 = LocalDate.parse("2023-01-01");
        LocalDateTime dt05 = LocalDateTime.parse("2023-01-01T12:00:00");
        Instant dt06 = Instant.parse("2023-01-01T12:00:26Z");
        Instant dt07 = Instant.parse("2023-01-01T12:00:26-03:00");
        LocalDate dt08 = LocalDate.parse("31/08/2023", formatter);
        LocalDateTime dt09 = LocalDateTime.parse("31/08/2023 13:00", formatter2);
        LocalDate dt10 = LocalDate.of(2023, 8, 31);
        LocalDateTime dt11 = LocalDateTime.of(2023, 8, 31, 13, 0);

        System.out.println(dt01);
        System.out.println(dt02);
        System.out.println(dt03);
        System.out.println(dt04);
        System.out.println(dt05);
        System.out.println(dt06);
        System.out.println(dt07);
        System.out.println(dt08);
        System.out.println(dt09);
        System.out.println(dt10);
        System.out.println(dt11);
        System.out.println(dt05.format(formatter));
        System.out.println(formatter.format(dt05));
        System.out.println(formatter3.format(dt06));

        for (String s : ZoneId.getAvailableZoneIds()) {
            System.out.println(s);
        }

        System.out.println(LocalDate.ofInstant(dt06, ZoneId.systemDefault()));
        System.out.println(LocalDate.ofInstant(dt06, ZoneId.of("Portugal")));

        System.out.println(dt04.minusDays(2));
        System.out.println(dt05.minusMonths(3));
        System.out.println(dt06.plus(1, ChronoUnit.DAYS));

        Duration dut = Duration.between(dt05, dt05.plusDays(7));
        Duration dut2 =Duration.between(dt04.atTime(0, 0), dt04.minusDays(2).atTime(12, 0));
        System.out.println(dut.toDays());
        System.out.println(dut2.toDays());
    }
}
