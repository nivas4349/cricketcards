package com.siva.cricketcards.client.config;

import java.io.IOException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientErrorDecoder implements ErrorDecoder {

    public ClientErrorDecoder() {
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        Throwable cause = new Default().decode(methodKey, response);
        log.error(String.format("ERROR:: while calling %s: %s", methodKey, cause.getMessage()));
        String errorMessage = getResponseMessage(response.body());
        if (response.status() != HttpStatus.TOO_MANY_REQUESTS.value()) {
            return FeignException.errorStatus(methodKey, response);
        } else {
            log.debug("Response status from service call is :" + response.status() + " and retrying it ");
            return new RetryableException(errorMessage, response.request().httpMethod(), new Date());
        }
    }

    private String getResponseMessage(Response.Body response) {
        if (response == null) {
            return "Empty response from service client";
        }
        String serviceResponse;
        try {
            serviceResponse = Util.toString(response.asReader());
            serviceResponse = StringUtils.replace(serviceResponse, "\r\n", "");
        } catch (IOException e) {
            log.error("IO exception while reading response {} ", e.getMessage(), e);
            return "Exception while reading response from service client:" + e.getMessage();
        }

        return serviceResponse;
    }
}
