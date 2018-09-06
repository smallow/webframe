package com.smallow.webframe.core.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class MyControllerAdvice {

    @ModelAttribute(name = "ctxPath")
    public String ctxPath(HttpServletRequest request) {
        return request.getContextPath();
    }
}
