package com.htsc.domain;

/**
 * <h3>mabatisdemo</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-09-02 15:26
 **/
public class QueryVo {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}