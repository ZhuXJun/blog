package com.zxj.blog.es;

import com.zxj.blog.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsDocBatchUpdate {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200))
        );
        BulkRequest bulkRequest = new BulkRequest();
        for (int i = 1006; i <1011 ; i++) {
            UpdateRequest updateRequest = new UpdateRequest().index("user_java").id(String.valueOf(i)).doc(XContentType.JSON,"role",i--);
            bulkRequest.add(updateRequest);
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.getItems());
    }
}
