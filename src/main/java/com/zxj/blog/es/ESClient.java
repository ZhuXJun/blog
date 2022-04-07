package com.zxj.blog.es;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ESClient {

    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200))
        );
        //创建索引
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices()
                .create(new CreateIndexRequest("user_java"), RequestOptions.DEFAULT);
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引操作：" + acknowledged);
        //关闭es客户端
        restHighLevelClient.close();
    }
}
