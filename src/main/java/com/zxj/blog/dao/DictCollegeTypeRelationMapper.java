package com.zxj.blog.dao;

import com.zxj.blog.entity.DictCollegeTypeRelation;
import java.util.List;

public interface DictCollegeTypeRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictCollegeTypeRelation record);

    DictCollegeTypeRelation selectByPrimaryKey(Integer id);

    List<DictCollegeTypeRelation> selectAll();

    int updateByPrimaryKey(DictCollegeTypeRelation record);
}