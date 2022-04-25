package org.roon.awss3sample.controller;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import org.roon.awss3sample.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // bucket이 비어있지 않으면 예외 발생
    // com.amazonaws.services.s3.model.AmazonS3Exception: The bucket you tried to delete is not empty
    @DeleteMapping("/buckets/{bucketName}")
    public void deleteBucket(@PathVariable String bucketName) {
        s3Service.deleteBucket(bucketName);
    }

    //list all the available objects in our S3 bucket:
    @GetMapping("/buckets/{bucketName}/objects")
    public ObjectListing objectList(@PathVariable String bucketName) {
        return s3Service.getObjectList(bucketName);
    }

    @GetMapping("/buckets/{bucketName}/objects/{objectKey}")
    public S3Object download(@PathVariable String bucketName, @PathVariable String objectKey) {
        return s3Service.getObject(bucketName, objectKey);
    }

    @DeleteMapping("/buckets/{bucketName}/objects/{objectKey}")
    public void deleteObject(@PathVariable String bucketName, @PathVariable String objectKey) {
        s3Service.deleteObject(bucketName, objectKey);
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
