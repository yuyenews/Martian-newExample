package com.demo.service;

import com.demo.dao.DemoDAO;
import com.demo.dao.model.DemoDTO;

import java.util.List;

public class DemoService {

    private DemoDAO demoDAO = new DemoDAO();

    public List<DemoDTO> selectList() throws Exception {
        DemoDTO demo3 = new DemoDTO();
        demo3.setName("testName");

        return demoDAO.selectList(demo3);
    }
}
