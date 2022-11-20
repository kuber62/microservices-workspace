package com.uniktech.api.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        Long start = System.currentTimeMillis();
        String requestParams = printRequestParams(request);
        log.info("Received request - Path={} -- Params={}",
                request.getPath(), requestParams);

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long end = System.currentTimeMillis();
            log.info("Response - Path={} -- Params={} -- ExecutionTimeInMs={} -- Status={}",
                    request.getPath(), requestParams, end - start, exchange.getResponse().getStatusCode());
        }));
    }

    private String printRequestParams(ServerHttpRequest request) {
        StringBuilder requestParams = new StringBuilder();
        request.getQueryParams().forEach((key, value) -> requestParams.append(key + "=" + value + ","));
        return requestParams.length() > 0 ? requestParams.substring(0, requestParams.length()-1) : requestParams.toString();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
