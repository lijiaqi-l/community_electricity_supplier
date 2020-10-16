package com.sqds.ces.gateway.config.router;

import com.qpx.jxcgateway.web.ImageCodeHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;


/**
 * webFlux 路由
 */
@Configuration
@AllArgsConstructor
public class RouterFunctionConfiguration {

   private final ImageCodeHandler imageCodeHandler;

   @Bean
   public RouterFunction routerFunction() {
      return RouterFunctions.route(RequestPredicates.GET("/code")
            .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), imageCodeHandler);
   }
}