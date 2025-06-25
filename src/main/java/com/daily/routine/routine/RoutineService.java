package com.daily.routine.routine;

import java.time.LocalDateTime;
import java.util.List;

public interface RoutineService {

    void register(Routine routine);

    void fixRoutine(Long routineId);

    void deleteRoutine(Long routineId);

    List<Routine> findAllRoutines();

    List<Routine> findTodayRoutines();
}
