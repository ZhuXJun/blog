package com.zxj.blog.dao;

import com.zxj.blog.entity.DictCollegeNew;
import java.util.List;

public interface DictCollegeNewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictCollegeNew record);

    DictCollegeNew selectByPrimaryKey(Integer id);

    List<DictCollegeNew> selectAll();

    int updateByPrimaryKey(DictCollegeNew record);
}