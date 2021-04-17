package com.demo.controller;

import com.demo.dao.model.DemoDTO;
import com.demo.service.DemoService;
import com.magician.web.core.annotation.Route;

import java.util.List;

@Route("/DemoDbController")
public class DemoDbController {

    private DemoService demoService = new DemoService();

    @Route("getDemoDTO")
    public DemoDTO getDemoDTO() throws Exception {
        return demoService.getDemoDTO();
    }

    @Route("selectList")
    public List<DemoDTO> selectList() throws Exception {
        return demoService.selectList();
    }
}
