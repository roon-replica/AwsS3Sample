package org.roon.awss3sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class S3Controller {
    @GetMapping("upload")
    public String uploadForm(){
        return "upload";
    }
}
