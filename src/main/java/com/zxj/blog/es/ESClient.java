package com.zxj.blog.es;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class ESClient {

    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200))
        );
        /**
         * 创建索引
         */
        // CreateIndexResponse createIndexResponse = restHighLevelClient.indices()
        //         .create(new CreateIndexRequest("user_java"), RequestOptions.DEFAULT);
        // boolean acknowledged = createIndexResponse.isAcknowledged();
        // log.info("创建索引===》 {} ",acknowledged);
        /**
         * 查询索引
         */
        // GetIndexRequest getIndexRequest = new GetIndexRequest("user_java");
        // GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        // log.info("获取索引=1==》 {} ",getIndexResponse.getAliases());
        // log.info("获取索引=2==》 {} ",getIndexResponse.getMappings());
        // log.info("获取索引=3==》 {} ",getIndexResponse.getSettings());
        /**
         * 删除索引
         */
        // DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("user_java");
        // AcknowledgedResponse deleteIndex = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        // log.info("删除索引==={} ",deleteIndex.isAcknowledged());

        // 闭es客户端
        restHighLevelClient.close();
    }
}
