package com.demo.dao;

import com.demo.dao.model.DemoDTO;
import com.magician.jdbc.helper.templete.JdbcTemplate;

import java.util.List;

public class DemoDAO {

    /**
     * 查询符合条件的数据
     * @return
     * @throws Exception
     */
    public List<DemoDTO> selectList(DemoDTO demo3) throws Exception {
        return JdbcTemplate.create().selectList("select * from test where name=#{name}", demo3, DemoDTO.class);
    }
}
