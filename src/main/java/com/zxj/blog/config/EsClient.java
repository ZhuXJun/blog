package com.zxj.blog.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class EsClient {

    @Value("${ES.host}")
    private String esHost;

    @Value("${ES.port}")
    private Integer port;

    public static RestHighLevelClient restHighLevelClient;

    static {
        //restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(esHost, port)));
    }

    public static CreateIndexResponse doCreateIndex(String index) throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
        CreateIndexResponse createIndexResponse =
                restHighLevelClient.indices()
                        .create(createIndexRequest, RequestOptions.DEFAULT);
        return createIndexResponse;
    }

    public static void doCreateIndexMapping() {
    }

    public static void doAddProporeties() {
    }

    public static void doGetRequest() {
    }

    public static void doPostRquest() {
    }

    public static void doPutRequest() {
    }

    public static void doDeleteRequest() {
    }
}
