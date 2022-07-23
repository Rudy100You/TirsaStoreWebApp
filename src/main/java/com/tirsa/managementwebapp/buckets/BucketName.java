package com.tirsa.managementwebapp.buckets;

public enum BucketName {
    DATA("tirsa-data");

    private final String bucketName;
    BucketName(String bucketName)
    {
        this.bucketName = bucketName;
    }

    public String getBucketName(){
        return bucketName;
    }
}

