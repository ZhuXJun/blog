package com.zxj.blog.es;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxj.blog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Date;

@Slf4j
public class ESClientDocUpdate {

    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200))
        );
        GetRequest getRequest = new GetRequest();
        getRequest.index("user").id("zxj-01");
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        log.info("查询成功=====> {}",documentFields.getField("nickname"));
        log.info("查询成功=====> {}",documentFields);
    }
}
