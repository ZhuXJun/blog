package com.zxj.blog.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zxj.blog.dao.DictCollegeNewMapper;
import com.zxj.blog.entity.DictCollegeNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@Slf4j
public class EasyExcelUtil {

    @Autowired
    private static DictCollegeNewMapper collegeNewMapper;

    public static void read(String file) {
        try {
            String fileName = "C:\\Users\\xiang\\Desktop\\"+file+".xls";
            //String fileName = "C:\\Users\\xiang\\Desktop\\college-985.xlsx";
            //String fileName = "C:\\Users\\xiang\\Desktop\\college-2111.xlsx";
            EasyExcel.read(fileName, DictCollegeNew.class,new PageReadListener<DictCollegeNew>(dataList -> {
                for (DictCollegeNew dictCollegeNew : dataList) {
                    collegeNewMapper.insert(dictCollegeNew);
                }

            })).sheet().doRead();
        }catch (Exception e){
            log.error("报错了：{}",e);
        }
    }
}
