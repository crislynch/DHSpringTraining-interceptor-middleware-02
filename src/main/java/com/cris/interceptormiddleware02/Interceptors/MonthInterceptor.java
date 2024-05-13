package com.cris.interceptormiddleware02.Interceptors;

import com.cris.interceptormiddleware02.Entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    public static List<Month> monthList = Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbrario", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni"));

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURL().toString().contains("/months")) {
            String monthNumber = request.getHeader("monthNumber");
            if (monthNumber == null || monthNumber.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return false;
            } else {
                int month = Integer.parseInt(monthNumber);
                Month foundMonth = monthList.stream().filter(m -> m.getMonthNumber() == month).findFirst().orElse(new Month(0, "nope", "nope", "nope"));
                request.setAttribute("month", foundMonth);
                response.setStatus(HttpServletResponse.SC_OK);
                return true;
            }
        } else {
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
