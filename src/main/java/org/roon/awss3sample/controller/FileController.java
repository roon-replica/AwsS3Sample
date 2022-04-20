package org.roon.awss3sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// 폼 제출, 응답 과정
// 1. form submits to the /greeting endpoint by using a POST call
// 2. controller receives the 'formData' object
//    'formData' bound to the incoming form content
// 3. 전달받은 데이터를 result view로 렌더

@Controller
public class FileController {
    @PostMapping("/upload")
    public String upload(@ModelAttribute FormData formData, Model model) {   // MultipartFile class provides access to details about the uploaded file
        model.addAttribute(formData);
        return "upload_result";
    }

    @GetMapping("/upload")
    public String upload(Model model) {
        model.addAttribute("formData", new FormData());
        return "upload";
    }
}
