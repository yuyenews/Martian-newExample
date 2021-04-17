package com.demo.controller;

import com.demo.controller.vo.ExpVO;
import com.magician.web.core.annotation.Route;
import com.magician.web.core.util.JSONUtil;
import com.magician.web.execute.model.ResponseInputStream;
import io.magician.tcp.http.constant.ReqMethod;
import io.magician.tcp.http.model.MagicianFileUpLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Route("/demoController")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Route("/getRequest")
    public List<ExpVO> getRequest(ExpVO expVO){
        // 打印接收到的参数，看是否接收成功
        logger.info(expVO.getName());
        logger.info(JSONUtil.toJSONString(expVO.getNames()));
        logger.info(String.valueOf(expVO.getDate()));
        return getExpResultData();
    }

    @Route(value = "/postRequest", requestMethod = ReqMethod.POST)
    public List<ExpVO> postRequest(ExpVO expVO){
        // 打印接收到的参数，看是否接收成功
        logger.info(expVO.getName());
        logger.info(JSONUtil.toJSONString(expVO.getNames()));
        logger.info(String.valueOf(expVO.getDate()));
        List<ExpVO> expVOList = expVO.getList();
        if(expVOList != null){
            for(ExpVO expVO1 : expVOList){
                logger.info("name:{},date:{}",expVO1.getName(), expVO1.getDate());
            }
        }
        // 返回数据
        return getExpResultData();
    }

    @Route(value = "/rawRequest", requestMethod = ReqMethod.POST)
    public List<ExpVO> rawRequest(ExpVO expVO){
        // 打印接收到的参数，看是否接收成功
        logger.info(expVO.getName());
        logger.info(JSONUtil.toJSONString(expVO.getNames()));
        logger.info(String.valueOf(expVO.getDate()));
        List<ExpVO> expVOList = expVO.getList();
        if(expVOList != null){
            for(ExpVO expVO1 : expVOList){
                logger.info("name:{},date:{}",expVO1.getName(), expVO1.getDate());
            }
        }
        // 返回数据
        return getExpResultData();
    }

    @Route(value = "/uploadRequest", requestMethod = ReqMethod.POST)
    public String uploadRequest(ExpVO expVO) throws Exception {
        // 打印接收到的参数，看是否接收成功
        logger.info(expVO.getName());
        logger.info(JSONUtil.toJSONString(expVO.getNames()));
        logger.info(String.valueOf(expVO.getDate()));

        // 打印接收到的文件，看是否接收成功
        MagicianFileUpLoad[] marsFileUpLoads = expVO.getMarsFileUpLoad();
        if(marsFileUpLoads == null){
            return "上传失败";
        }
        for(MagicianFileUpLoad marsFileUpLoad : marsFileUpLoads){
            System.out.println(marsFileUpLoad.getFileName());
            System.out.println(marsFileUpLoad.getInputStream());

            InputStream inputStream = marsFileUpLoad.getInputStream();
            writeToLocal("/Users/yuye/Downloads/aaa/"+marsFileUpLoad.getFileName(),inputStream);
        }
        return "上传成功";
    }

    @Route(value = "/downloadRequest")
    public ResponseInputStream downloadRequest() throws Exception {
        ResponseInputStream responseInputStream = new ResponseInputStream();
        responseInputStream.setName("xxx.zip");
        responseInputStream.setInputStream(new FileInputStream(new File("/Users/yuye/Downloads/vvv2.zip")));
        return responseInputStream;
    }

    /**
     * 这是把返回数据写死了，不然你们还得搭环境，连接数据库
     * @return
     */
    private List<ExpVO> getExpResultData(){
        List<ExpVO> list = new ArrayList<>();

        ExpVO exp = new ExpVO();
        exp.setName("hello world");
        list.add(exp);

        exp = new ExpVO();
        exp.setName("The world dies");
        list.add(exp);

        return list;
    }

    private static void writeToLocal(String destination, InputStream input)
            throws IOException {
        int index;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream(destination);
        while ((index = input.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        downloadFile.close();
        input.close();
    }
}
