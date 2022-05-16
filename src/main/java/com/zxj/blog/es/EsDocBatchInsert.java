package com.zxj.blog.es;

import com.alibaba.fastjson.JSONObject;
import com.zxj.blog.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Date;

public class EsDocBatchInsert {


    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200))
        );
        //批量插入数据
        BulkRequest bulkRequest = new BulkRequest();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(Long.parseLong(1006+i+""));
            user.setAvatar("循环" + (1006+i) + "号");
            user.setCreatetime(new Date());
            //创建对象
            IndexRequest indexRequest = new IndexRequest().index("user_java").id(String.valueOf(1006+i))
                    .source(JSONObject.toJSONString(user),XContentType.JSON)
                    .create(false);
            bulkRequest.add(indexRequest);
        }
        restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

    }
}
