package com.poscodx.odc.excan013.store.converter.image;

import com.poscdx.odc.excan013.domain.utils.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeyProperty {

    @Value("${minio.url}")
    public void setUrl(String url) {
        Constants.UPLOAD_URL = url;
    }

    @Value("${minio.bucketName}")
    public void setBucketName(String bucketName) {
        Constants.UPLOAD_BUCKET = bucketName;
    }
}
