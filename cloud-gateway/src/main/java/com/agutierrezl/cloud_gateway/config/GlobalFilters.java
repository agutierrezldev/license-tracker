package com.agutierrezl.cloud_gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Component
public class GlobalFilters implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // PreFilter
        Long startime = System.currentTimeMillis();
        log.info("[GlobalFilters] - [filter]: PreFilter");
        log.info("Time elapsed PreFilter: "+startime);

        Optional<String> appCallName = Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("appCallerName"));

        if(appCallName.isEmpty()){
            exchange.getRequest().mutate().header("appCallerName","Cloud Gateway");
        }

        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            // PostFilter
            log.info("[GlobalFilters] - [filter]: PostFilter");
            log.info("Time elapsed PostFilter: "+(System.currentTimeMillis() - startime));
            exchange.getResponse().getHeaders().add("appCallerName",
                    exchange.getRequest().getHeaders().getFirst("appCallerName"));
            exchange.getResponse().getCookies().add("appCallerName",
                    ResponseCookie.from("AppCallerName",exchange.getRequest().getHeaders().getFirst("appCallerName")).build());
        }));
    }
}
