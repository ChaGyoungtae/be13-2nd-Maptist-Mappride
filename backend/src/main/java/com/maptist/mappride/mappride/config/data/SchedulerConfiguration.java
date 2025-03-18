package com.maptist.mappride.mappride.config.data;

import com.maptist.mappride.mappride.grade.GradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SchedulerConfiguration {

    private final GradeService gradeService;

    @Scheduled(cron = "0 0 0 * * FRI") // 매주 금요일
    //@Scheduled(cron = "*/10 * * * * *") // 10초 마다
    public void runSetGrade(){
        gradeService.setGrade();
    }
}
