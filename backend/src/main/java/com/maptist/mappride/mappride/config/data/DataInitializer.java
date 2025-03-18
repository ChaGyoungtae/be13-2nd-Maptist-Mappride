package com.maptist.mappride.mappride.config.data;

import com.maptist.mappride.mappride.grade.Grade;
import com.maptist.mappride.mappride.grade.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final GradeService gradeService;
    private final Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String ddlAuto = environment.getProperty("spring.jpa.hibernate.ddl-auto");

        if ("create".equals(ddlAuto)) {
            System.out.println("✅ ddl-auto가 create이므로 초기 데이터를 삽입합니다.");
            // 데이터 삽입 코드 추가
            Grade beginner = Grade.builder()
                    .name("비기너")
                    .reviewCnt(0)
                    .build();

            Grade bronze = Grade.builder()
                    .name("브론즈")
                    .reviewCnt(50)
                    .build();

            Grade silver = Grade.builder()
                    .name("실버")
                    .reviewCnt(100)
                    .build();

            Grade gold = Grade.builder()
                    .name("골드")
                    .reviewCnt(500)
                    .build();

            gradeService.save(beginner);
            gradeService.save(bronze);
            gradeService.save(silver);
            gradeService.save(gold);

        } else {
            System.out.println("❌ ddl-auto가 create이 아님. 데이터 삽입을 건너뜁니다.");
        }
    }
}
