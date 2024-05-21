package com.id.project_bd.controllers;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ModelAndView handleError(WebRequest webRequest) {
        Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
        Integer statusCode = (Integer) errorDetails.get("status");
        String errorMessage = (String) errorDetails.get("error");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("statusCode", statusCode);
        mv.addObject("errorMessage", errorMessage);
        return mv;
    }
}
