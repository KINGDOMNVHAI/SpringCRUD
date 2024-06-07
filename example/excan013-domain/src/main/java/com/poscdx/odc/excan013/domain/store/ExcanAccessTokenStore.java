package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanAccessToken;

import java.util.List;


public interface ExcanAccessTokenStore {
    List<ExcanAccessToken> findByToken(String token);
    ExcanAccessToken register(ExcanAccessToken entity);
}
