package com.zxj.blog.dao;

import com.zxj.blog.entity.DictCollegeNew;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictCollegeNewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictCollegeNew record);

    DictCollegeNew selectByPrimaryKey(Integer id);

    List<DictCollegeNew> selectAll();

    int updateByPrimaryKey(DictCollegeNew record);

    int batchInsert(List<DictCollegeNew> list);

    DictCollegeNew selectByName(@Param("name") String name);
}