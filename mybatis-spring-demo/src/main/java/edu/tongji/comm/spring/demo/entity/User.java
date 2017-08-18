package edu.tongji.comm.spring.demo.entity;


import lombok.Data;

/**
 * Created by chen on 2017/6/29.
 */

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String regdata;
}
