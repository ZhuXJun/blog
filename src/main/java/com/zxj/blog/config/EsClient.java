package com.zxj.blog.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EsClient {

    @Value("${ES.host}")
    private String esHost;

    @Value("${ES.port}")
    private Integer port;

    private static RestHighLevelClient restHighLevelClient;

    @Bean
    public RestHighLevelClient getRestHighLevelClient() {
        restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(esHost, port)));
        return restHighLevelClient;
    }
}
