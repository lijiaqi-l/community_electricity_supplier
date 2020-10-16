package com.sqds.ces.gateway.web;

import com.google.code.kaptcha.Producer;
import com.sqds.ces.gateway.config.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * spring 5.0 webFlux 生成验证码
 */
@Slf4j
@Data
@Component
@AllArgsConstructor
public class ImageCodeHandler implements HandlerFunction<ServerResponse> {

   private final   Producer producer;

   private final RedisTemplate redisTemplate;

    /**
     * webFlux 使用nio 异步非阻塞的方式，所以语法和传统的spring 不一样
     * @param serverRequest
     * @return
     */
   @Override
   public Mono<ServerResponse> handle(ServerRequest serverRequest) {
      //生成验证码  数组 定义0-9  random 生成随机的下标从数组里面实现
      String text = producer.createText();
      log.info("准备生成验证码:{}",text);
      BufferedImage image = producer.createImage(text);

      //保存验证码信息
      String randomStr = serverRequest.queryParam("randomStr").get();
      log.info("验证码的随机数：{}",randomStr);
      //把验证码存储到redis 中
      redisTemplate.opsForValue().set(CommonConstants.DEFAULT_CODE_KEY + randomStr, text, 60, TimeUnit.SECONDS);

      log.info("redis 存储的key:{},验证码为{}",CommonConstants.DEFAULT_CODE_KEY + randomStr,redisTemplate.opsForValue().get(CommonConstants.DEFAULT_CODE_KEY + randomStr));
      // 把验证码 转换流信息写出 到页面
      FastByteArrayOutputStream os = new FastByteArrayOutputStream();
      try {
         ImageIO.write(image, "jpeg", os);
      } catch (IOException e) {
         log.error("ImageIO write err", e);
         return Mono.error(e);
      }

      return ServerResponse
         .status(HttpStatus.OK)
         .contentType(MediaType.IMAGE_JPEG)
         .body(BodyInserters.fromResource(new ByteArrayResource(os.toByteArray())));
   }
}