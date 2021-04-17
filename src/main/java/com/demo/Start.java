package com.demo;

import com.demo.config.DemoConfig;
import com.martian.annotation.MartianScan;
import com.martian.starter.StartMartian;

@MartianScan(scanPackage = {"com.demo.controller"})
public class Start {

    public static void main(String[] args) {
        StartMartian.start(Start.class, new DemoConfig());
    }
}
