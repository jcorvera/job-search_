package com.jobSearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface IApiFunction {
    static <T> T buildAPI(Class<T> clazz, String url) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(clazz, url);
    }
}
