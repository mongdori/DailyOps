package com.daily.routine.routine.dto;

import com.daily.routine.routine.Category;
import com.daily.routine.routine.Cycle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class RoutineCreateRequestDto {

    private String title;
    private String script;
    private Category category;
    private Cycle cycle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
