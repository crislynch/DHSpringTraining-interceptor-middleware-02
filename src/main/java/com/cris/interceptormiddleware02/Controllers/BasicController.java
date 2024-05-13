package com.cris.interceptormiddleware02.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BasicController {
    @GetMapping
    public String welcome() {
        return "WellCome!";
    }
}
