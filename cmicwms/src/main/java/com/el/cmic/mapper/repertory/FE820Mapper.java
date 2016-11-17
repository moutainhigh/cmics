package com.el.cmic.mapper.repertory;

import org.apache.ibatis.annotations.Select;

import com.el.cfg.domain.FE8WMS20;

import java.util.List;

public interface FE820Mapper {

    @Select("select * from FE8WMS20 where LSE8HZBM = ${value}")
    public FE8WMS20 selectFE8WMS20ByKcoo(String kcoo);

    @Select("select * from FE8WMS20")
    public List<FE8WMS20> selectAllFE8WMS20();

    @Select("select * from FE8WMS20 where LSE8HZBM = ${value}")
    public FE8WMS20 selectFE8WMS20ByWmsCo(String wmsCo);
}
