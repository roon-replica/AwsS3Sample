package org.roon.awss3sample.controller;

import com.amazonaws.services.s3.model.Bucket;
import org.roon.awss3sample.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class S3ApiController {
    @Autowired
    private S3Service s3Service;

    @PostMapping("/buckets/{bucketName}")
    public Bucket create(@PathVariable String bucketName) {
        return s3Service.createBucket(bucketName);
    }

    @GetMapping("/buckets")
    public List<Bucket> list() {
        return s3Service.getBucketList();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> illegalArgsException(IllegalArgumentException e) {
        e.printStackTrace();
        return new ResponseEntity<>("duplicated bucket name", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<Void> exception(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
