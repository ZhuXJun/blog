package com.zxj.blog.es;

import com.alibaba.fastjson.JSONObject;
import com.zxj.blog.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EsBatchOperation {
    private static RestHighLevelClient restHighLevelClient;

    static {
        restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200))
        );
    }



    /**
     * 批量新增用户
     * @param list
     * @return
     * @throws IOException
     */
    public Boolean batchInster(List<User> list) throws IOException {
        list.addAll(new User().getUserList(10));
        BulkRequest bulkRequest = new BulkRequest();
        if (list.size() != 0){
            list.stream().forEach(item -> {
                IndexRequest indexRequest = new IndexRequest().index("user").source(item,XContentType.JSON);
                bulkRequest.add(indexRequest);
            });
            BulkResponse response = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        }
        return true;
    }
}
