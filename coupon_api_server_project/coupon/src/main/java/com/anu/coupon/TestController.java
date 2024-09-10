package com.anu.coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // HTTP GET 메서드
    @GetMapping("/get")
    public String get() {
        return "Hello World";
    }

    // HTTP POST 메서드
    @PostMapping("/post")
    public ResponseEntity<TestRequest> post(@RequestBody TestRequest request) {
        System.out.println(request.getName());

        return ResponseEntity.ok(request);
    }

    // HTTP POST 에서 body 메시지에 전송할 객체
    // DTO - Data Transfer Object
    // Request, Response
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TestRequest {
        private String name;
    }

}
