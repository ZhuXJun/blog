package com.zxj.blog.dao;

import com.zxj.blog.entity.DictCollegeType;
import java.util.List;

public interface DictCollegeTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictCollegeType record);

    DictCollegeType selectByPrimaryKey(Integer id);

    List<DictCollegeType> selectAll();

    int updateByPrimaryKey(DictCollegeType record);
}