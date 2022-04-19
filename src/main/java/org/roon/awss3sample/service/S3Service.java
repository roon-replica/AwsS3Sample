package org.roon.awss3sample.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S3Service {
    @Autowired
    private AmazonS3 s3client;

    public Bucket createBucket(String name) {
        if (s3client.doesBucketExistV2(name)) {
            throw new IllegalArgumentException("already exist bucket name");
        }

        return s3client.createBucket(name);
    }

    public List<Bucket> getBucketList(){
        return s3client.listBuckets();
    }
}
