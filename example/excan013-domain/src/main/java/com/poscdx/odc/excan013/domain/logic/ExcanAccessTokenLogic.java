package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanAccessToken;
import com.poscdx.odc.excan013.domain.spec.ExcanAccessTokenService;
import com.poscdx.odc.excan013.domain.store.ExcanAccessTokenStore;

import java.util.List;


public class ExcanAccessTokenLogic implements ExcanAccessTokenService
{
    private final ExcanAccessTokenStore store;

    public ExcanAccessTokenLogic(ExcanAccessTokenStore store) {
        this.store = store;
    }

    @Override
    public List<ExcanAccessToken> findByToken(String token) {
        return this.store.findByToken(token);
    }

    @Override
    public ExcanAccessToken register(ExcanAccessToken entity) {
        return this.store.register(entity);
    }
}
