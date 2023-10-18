package com.okky.okkyclone.Main.controller;

import lombok.Getter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Getter
@Validated
@RequestMapping("/main")
@RestController
public class MainController {
}
