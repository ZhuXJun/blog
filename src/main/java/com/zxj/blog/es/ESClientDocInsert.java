package com.zxj.blog.es;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxj.blog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Date;

@Slf4j
public class ESClientDocInsert {

    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200))
        );

        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user_java").id("zxj-06");
        User user = new User();
        user.setId(1L);
        user.setUsername("朱相俊");
        user.setNickname("朱相俊测试ES-01");
        user.setAvatar("不知道是什么意思了");
        user.setEmail("xiangjun_mail@163.com");
        user.setRole(1);
        user.setPassword("1234qwer");
        user.setCreatetime(new Date());
        user.setUpdatetime(new Date());
        indexRequest.source(JSONObject.toJSONString(user), XContentType.JSON);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println();
        log.info("indexResponse.getResult() {}",indexResponse);
        restHighLevelClient.close();
    }
}
