package com.ABCShop.service;

import com.ABCShop.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType record);

    GoodsType selectByPrimaryKey(Integer id);

    List<GoodsType> selectAll();

    int updateByPrimaryKey(GoodsType record);

    int count();
}
