package com.project.universe.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;


/** Class responsible for creating a RestTemplate bean. */
@Configuration
public class RestTemplateConfig {

  /**
   * Method responsible for creating a RestTemplate Bean.
   *
   * @param restTemplateBuilder for the RestTemplate object.
   * @return RestTemplate for consuming others RESTful services.
   */
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    RestTemplate restTemplate = restTemplateBuilder.build();
    restTemplate.setInterceptors(addInterceptors(restTemplate));
    return restTemplate;
  }

  /**
   * Method responsible for add interceptors in RestTemplate.
   *
   * @param RestTemplate for consuming others RESTful services.
   * @return ClientHttpRequestInterceptor list.
   */
  private List<ClientHttpRequestInterceptor> addInterceptors(RestTemplate restTemplate) {
    List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
    if (CollectionUtils.isEmpty(interceptors)) {
      interceptors = new ArrayList<>();
    }
    interceptors.add(new RestTemplateHeaderModifierInterceptor());
    return interceptors;
  }
}

