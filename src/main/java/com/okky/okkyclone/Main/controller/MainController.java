package com.okky.okkyclone.Main.controller;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@Getter
@Validated
@RequestMapping("/main")
@RestController
public class MainController {

    @GetMapping
    public ResponseEntity<Void> getMain(@Positive @RequestParam int page,
                                        @Positive @RequestParam int size){


    }
}
