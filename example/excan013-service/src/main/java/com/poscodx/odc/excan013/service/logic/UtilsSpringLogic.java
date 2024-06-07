package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.UtilsLogic;
import io.minio.MinioClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UtilsSpringLogic extends UtilsLogic
{
    public UtilsSpringLogic(MinioClient minioClient) {
        super(minioClient);
    }
}
