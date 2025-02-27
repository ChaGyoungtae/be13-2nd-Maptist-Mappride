package com.maptist.mappride.mappride.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberController {

    @GetMapping("/test")
    public ResponseEntity<String> test() {

        return ResponseEntity.ok().body("ok");
    }

}
