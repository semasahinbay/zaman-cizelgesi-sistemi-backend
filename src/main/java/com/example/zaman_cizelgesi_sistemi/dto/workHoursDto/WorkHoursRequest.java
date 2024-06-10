package com.example.zaman_cizelgesi_sistemi.dto.workHoursDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class WorkHoursRequest {
    private Long userId;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
}
