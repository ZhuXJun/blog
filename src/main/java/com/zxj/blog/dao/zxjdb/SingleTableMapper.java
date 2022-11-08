package com.zxj.blog.dao.zxjdb;

import com.zxj.blog.entity.zxjdb.SingleTable;
import com.zxj.blog.entity.zxjdb.SingleTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SingleTableMapper {
    long countByExample(SingleTableExample example);

    int deleteByExample(SingleTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SingleTable row);

    int insertSelective(SingleTable row);

    List<SingleTable> selectByExample(SingleTableExample example);

    SingleTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") SingleTable row, @Param("example") SingleTableExample example);

    int updateByExample(@Param("row") SingleTable row, @Param("example") SingleTableExample example);

    int updateByPrimaryKeySelective(SingleTable row);

    int updateByPrimaryKey(SingleTable row);
}