package com.cris.interceptormiddleware02.Controllers;

import com.cris.interceptormiddleware02.Entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {
    @GetMapping
    public Object getMonth(HttpServletRequest request) {
        Month month = (Month) request.getAttribute("MonthInterceptor-month");
        return month;
    }
}
