package com.daily.routine.record;

import com.daily.routine.routine.Routine;

import java.time.LocalDateTime;
import java.util.List;

public interface RecordService {

    boolean isDoneChecked(LocalDateTime time);

    void saveRecord(boolean isDone);

    List<Routine> checkDone(boolean isDone, LocalDateTime time);

    List<Routine> readHistory(LocalDateTime time);

}
