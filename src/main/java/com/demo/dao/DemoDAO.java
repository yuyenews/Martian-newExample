package com.demo.dao;

import com.demo.dao.model.DemoDTO;
import com.magician.jdbc.helper.templete.JdbcTemplate;

import java.util.List;

public class DemoDAO {

    /**
     * 根据主键查询一条数据
     * @return
     * @throws Exception
     */
    public DemoDTO getDemoDTO(int id) throws Exception {
        return JdbcTemplate.create()
                .getOneByPrimaryKey("test",
                        "id",
                        id,
                        DemoDTO.class);
    }

    /**
     * 查询符合条件的数据
     * @return
     * @throws Exception
     */
    public List<DemoDTO> selectList(DemoDTO demo3) throws Exception {
        return JdbcTemplate.create().selectList("select * from test where name=#{name}", demo3, DemoDTO.class);
    }
}
