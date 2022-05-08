package com.zxj.blog.dao;

import com.zxj.blog.entity.DictCollegeTypeRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictCollegeTypeRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictCollegeTypeRelation record);

    DictCollegeTypeRelation selectByPrimaryKey(Integer id);

    List<DictCollegeTypeRelation> selectAll();

    int updateByPrimaryKey(DictCollegeTypeRelation record);
}