package com.daily.routine.routine;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService {


    private final RoutineRepository routineRepository;

    @Override
    public void register(Routine routine) {

    }

    @Override
    public void fixRoutine(Long routineId) {

    }

    @Override
    public void deleteRoutine(Long routineId) {

    }

    @Override
    public List<Routine> findAllRoutines() {
        return List.of();
    }

    @Override
    public List<Routine> findTodayRoutines() {
        return List.of();
    }
}
