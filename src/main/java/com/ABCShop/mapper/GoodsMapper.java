package com.ABCShop.mapper;

import com.ABCShop.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll(@Param("gname") String gname);

    int updateByPrimaryKey(Goods record);

    //查询结果总数
    int count(@Param("gname")String gname);
}