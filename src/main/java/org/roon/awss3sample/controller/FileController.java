package org.roon.awss3sample.controller;

import org.roon.awss3sample.service.S3Service;
import org.roon.awss3sample.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;

// 폼 제출, 응답 과정
// 1. form submits to the /greeting endpoint by using a POST call
// 2. controller receives the 'formData' object
//    'formData' bound to the incoming form content
// 3. 전달받은 데이터를 result view로 렌더

@Controller
public class FileController {
    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public String upload(@ModelAttribute FormData formData, Model model) throws IOException {
        model.addAttribute(formData);

        s3Service.upload(formData.getBucketName(), formData.getObjKey(), FileUtil.multipartToFile(formData.getFile()));

        return "upload_result";
    }

    @GetMapping("/upload")
    public String upload(Model model) {
        model.addAttribute("formData", new FormData());
        return "upload";
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<Void> exception(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
