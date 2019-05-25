package com.siva.cricketcards.client.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RetryableException;
import feign.Retryer;
import feign.codec.ErrorDecoder;

@Configuration
public class RetryClientConfiguration {

    @Bean
    @Qualifier("clientRetryer")
    public Retryer retryer() {
        return new ServiceRetryer();
    }

    @Bean
    public ErrorDecoder clientErrorDecoder() {
        return new ClientErrorDecoder();
    }
}

class ServiceRetryer implements Retryer {

    private final int maxAttempts;
    private final long backoff;
    int attempt;

    public ServiceRetryer() {
        this(1000, 3);
    }

    public ServiceRetryer(long backoff, int maxAttempts) {
        this.backoff = backoff;
        this.maxAttempts = maxAttempts;
        this.attempt = 1;
    }

    @Override
    public void continueOrPropagate(RetryableException e) {
        if (attempt++ >= maxAttempts) {
            throw e;
        }

        try {
            Thread.sleep(backoff);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Retryer clone() {
        return new ServiceRetryer(backoff, maxAttempts);
    }

}
