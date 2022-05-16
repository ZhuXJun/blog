package com.zxj.blog.es;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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
import org.elasticsearch.index.get.GetResult;

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
        getRequest.index("user_java").id("zxj-06");
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        User user = JSONObject.parseObject(documentFields.getSourceAsString(), User.class);
        //UpdateRequest updateRequest = new UpdateRequest();
        //updateRequest.index("user_java").id("zxj-06");
        //user.setAvatar("不知道是什么意思更新后");
        //updateRequest.doc(JSONObject.toJSONString(user),XContentType.JSON);
        //UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        //System.out.println(updateResponse.getGetResult());
        //局部更新
        UpdateRequest request = new UpdateRequest();
        request.index("user_java").id("zxj-06");
        request.doc(XContentType.JSON,"role",2);
        restHighLevelClient.update(request, RequestOptions.DEFAULT);
    }
}
