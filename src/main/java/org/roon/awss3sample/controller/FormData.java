package org.roon.awss3sample.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class FormData {
    private String bucketName;
    private String objKey;
    private MultipartFile file;  // MultipartFile class provides access to details about the uploaded file
}
