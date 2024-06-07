package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanAccessToken;

import java.util.List;


public interface ExcanAccessTokenService {

    List<ExcanAccessToken> findByToken(String token);
    ExcanAccessToken register(ExcanAccessToken entity);
}
