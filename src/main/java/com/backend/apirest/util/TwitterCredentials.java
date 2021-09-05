package com.backend.apirest.util;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class TwitterCredentials {

  @Value("${oauth.consumerKey}")
  private String consumerKey;
  @Value("${oauth.consumerSecret}")
  private String consumerSecret;
  @Value("${oauth.accessToken}")
  private String accessToken;
  @Value("${oauth.accessTokenSecret}")
  private String accessTokenSecret;

}
