package com.ABCShop.service;

import com.ABCShop.entity.Goods;

import java.util.List;

public interface GoodsService {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll(int page,int limit,String keyword);

    int updateByPrimaryKey(Goods record);
    int count(String keyword);


}
