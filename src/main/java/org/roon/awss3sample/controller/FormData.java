package org.roon.awss3sample.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class FormData {
    private String name;
    private MultipartFile file;
}
