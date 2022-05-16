package com.zxj.blog.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ESClientConf {

    @Value("${ES.host}")
    private String host;
    @Value("${ES.port}")
    private Integer port;
    @Bean
    public RestHighLevelClient highLevelClient(){
        RestHighLevelClient highLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(host,port,"http")));
        return highLevelClient;
    }
}
