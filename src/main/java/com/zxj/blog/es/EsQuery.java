package com.zxj.blog.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

public class EsQuery {
    public static String index = "user_java";


    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200))
        );
        //1、全量查询
        //SearchRequest searchRequest = new SearchRequest();
        //SearchSourceBuilder query = new SearchSourceBuilder();
        //searchRequest.indices(index);
        //query.query(QueryBuilders.matchAllQuery());
        //searchRequest.source(query);
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //SearchHits hits = searchResponse.getHits();
        //System.out.println("查询条数" + hits.getTotalHits());
        //System.out.println("查询时间" + searchResponse.getTook());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}
        //2、条件查询
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices(index);
        //searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("username","1114")));
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //SearchHits hits = searchResponse.getHits();
        //System.out.println("查询条数" + hits.getTotalHits());
        //System.out.println("查询时间" + searchResponse.getTook());
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}
        //3、分页查询 并且排序
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices(index);
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //builder.from(0);
        //builder.size(100);
        ////排序
        //builder.sort("role", SortOrder.DESC);
        //searchRequest.source(builder);
        //SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //System.out.println("查询条数" + response.getHits().getTotalHits());
        //System.out.println("查询时间" + response.getTook());
        //for (SearchHit hit : response.getHits().getHits()) {
        //    System.out.println(hit.getSourceAsString());
        //}
        //4、过滤字段
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(index);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(0);
        builder.size(100);
        //排除
        String[] excludes = {};
        String[] includes = {"id","nickname"};
        builder.fetchSource(includes, excludes);
        searchRequest.source(builder);
        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("查询条数" + response.getHits().getTotalHits());
        System.out.println("查询时间" + response.getTook());
        for (SearchHit hit : response.getHits().getHits()) {
            System.out.println(hit.getSourceAsString());
        }
        esClient.close();
    }
}
