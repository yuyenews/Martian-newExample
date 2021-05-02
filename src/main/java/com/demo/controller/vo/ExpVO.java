package com.demo.controller.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.magician.web.core.annotation.Verification;
import io.magician.tcp.codec.impl.http.model.MagicianFileUpLoad;

import java.util.Date;
import java.util.List;

/**
 * 所有实体类都支持lombok，这里为了兼容所有的环境，就还是采用的原始的get，set
 */
public class ExpVO {

    @Verification(notNull = true, msg = "名称不可以为空")
    private String name;

    @Verification(notNull = true, msg = "名称们不可以为空", apis = {"get*"})
    private String[] names;

    private List<ExpVO> list;

    /**
     * 这个变量名不需要跟参数key一样，他会把所有的文件都放里面
     * 如果key一致，则只放一个
     */
    private MagicianFileUpLoad[] marsFileUpLoad;

    /**
     * 这个变量名要跟参数key一样
     */
    private MagicianFileUpLoad file;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public MagicianFileUpLoad[] getMarsFileUpLoad() {
        return marsFileUpLoad;
    }

    public void setMarsFileUpLoad(MagicianFileUpLoad[] marsFileUpLoad) {
        this.marsFileUpLoad = marsFileUpLoad;
    }

    public MagicianFileUpLoad getFile() {
        return file;
    }

    public void setFile(MagicianFileUpLoad file) {
        this.file = file;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ExpVO> getList() {
        return list;
    }

    public void setList(List<ExpVO> list) {
        this.list = list;
    }
}
