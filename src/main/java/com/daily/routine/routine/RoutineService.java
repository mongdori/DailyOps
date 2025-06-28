package com.daily.routine.routine;

import com.daily.routine.routine.dto.RoutineCreateRequestDto;

import java.time.LocalDateTime;
import java.util.List;

public interface RoutineService {

    void register(RoutineCreateRequestDto createRequestDto);

    void fixRoutine(Long routineId);

    void deleteRoutine(Long routineId);

    List<Routine> findAllRoutines();

    List<Routine> findTodayRoutines();
}
