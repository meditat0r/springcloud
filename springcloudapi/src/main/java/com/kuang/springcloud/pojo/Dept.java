package com.kuang.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author meditat0r
 * @create 2021/11/25 14:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    /**
     * 这个字段记录该数据存在哪个数据库
     * 一个服务对应一个数据库
     * 同一个信息可能存在不同的数据库
     */
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
