package com.example.first.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayWordRequest {
    private LocalDate date;
    private Integer wordId;
}
