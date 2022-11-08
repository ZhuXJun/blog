package com.zxj.blog.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.zxj.blog.dao.DictCollegeNewMapper;
import com.zxj.blog.dao.DictCollegeTypeRelationMapper;
import com.zxj.blog.dao.zxjdb.SingleTableMapper;
import com.zxj.blog.entity.DictCollegeNew;
import com.zxj.blog.entity.DictCollegeTypeRelation;
import com.zxj.blog.entity.zxjdb.SingleTable;
import com.zxj.blog.service.UtilService;
import com.zxj.blog.util.EasyExcelUtil;
import com.zxj.blog.util.RandomUtil;
import com.zxj.blog.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@Slf4j
public class UtilServiceImpl implements UtilService {

    private static final String path = "C:\\Users\\xiang\\Desktop\\";

    @Autowired
    private DictCollegeNewMapper dictCollegeNewMapper;
    @Autowired
    private DictCollegeTypeRelationMapper dictCollegeTypeRelationMapper;

    @Override
    public Boolean doRead(String fileName,Integer type) {
        String file = path+fileName+".xlsx";
        EasyExcel.read(file, DictCollegeNew.class,new PageReadListener<DictCollegeNew>(dataList -> {
            for (DictCollegeNew dictCollegeNew : dataList) {
               this.doInsert(dictCollegeNew,type);
            }
        })).sheet().doRead();
        return true;
    }

    private void doInsert(DictCollegeNew dictCollegeNew,Integer type){
        DictCollegeTypeRelation dictCollegeTypeRelation = new DictCollegeTypeRelation();
        switch (type){
            case 1:
                dictCollegeNewMapper.insert(dictCollegeNew);
                dictCollegeTypeRelation.setCollegeid(dictCollegeNew.getId());
                dictCollegeTypeRelation.setTypeid(type);
                dictCollegeTypeRelationMapper.insert(dictCollegeTypeRelation);
                break;
            case 2:
            case 3:
            default:
                DictCollegeNew data = dictCollegeNewMapper.selectByName(dictCollegeNew.getName());
                if (Objects.nonNull(data)){
                    dictCollegeNew=data;
                }else {
                    dictCollegeNewMapper.insert(dictCollegeNew);
                }
                dictCollegeTypeRelation.setCollegeid(dictCollegeNew.getId());
                dictCollegeTypeRelation.setTypeid(type);
                dictCollegeTypeRelationMapper.insert(dictCollegeTypeRelation);
                break;

        }
    }


    @Autowired
    private SingleTableMapper singleTableMapper;

    /**
     * @param times
     * @return
     */
    @Override
    public Boolean doGenerator(Integer times) {
        if (Objects.isNull(times)){
            return false;
        }
        for (Integer i = 0; i < times; i++) {
            SingleTable singleTable = SingleTable
                    .builder()
                    .key1(StringUtil.getRandomString2(1))
                    .key2(i)
                    .key3(RandomUtil.GetRandomString(3,5))
                    .keyPart1(RandomUtil.getRandomString(4,5))
                    .keyPart2(RandomUtil.getRandomString(5,5))
                    .keyPart3(RandomUtil.getRandomString(5,5))
                    .commonField(RandomUtil.getRandomString(7,5))
                    .build();
            try {
                singleTableMapper.insert(singleTable);
            } catch (Exception e) {
                log.info("重复数据：{}",i);
            }
        }
        return null;
    }

}
