package com.demo.config;

import com.martian.config.MartianConfig;
import com.martian.config.model.FileUploadConfig;
import com.martian.config.model.RequestConfig;
import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DemoConfig extends MartianConfig {

    @Override
    public int port() {
        return super.port();
    }

    @Override
    public RequestConfig requestConfig() {
        RequestConfig requestConfig = new RequestConfig();
        requestConfig.setReadTimeout(100000);
        requestConfig.setReadSize(1*1024*1024);
        requestConfig.setWriteTimeout(100000);
        return requestConfig;
    }

    /**
     * 限制上传文件的大小
     * @return
     */
    @Override
    public FileUploadConfig fileUploadConfig() {
        FileUploadConfig fileUploadConfig = new FileUploadConfig();
        fileUploadConfig.setFileSizeMax(fileUploadConfig.getFileSizeMax()*100);
        fileUploadConfig.setSizeMax(fileUploadConfig.getSizeMax()*100);
        return fileUploadConfig;
    }

    @Override
    public List<Properties> jdbcProperties() {
        List<Properties> propertiesList = new ArrayList<>();

        Properties properties = new Properties();
        properties.put("name", "local");
        properties.put("url", "jdbc:mysql://127.0.0.1:3306/martian-test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=true&useSSL=false");
        properties.put("username", "root");
        properties.put("password", "123456");
        properties.put("driverClassName", Driver.class.getName());

        propertiesList.add(properties);

        return propertiesList;
    }
}
