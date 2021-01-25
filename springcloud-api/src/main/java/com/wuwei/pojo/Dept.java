package com.wuwei.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {
        private long deptno; //部门号
        private String dname; //部门名称
        //微服务，同一个信息可以存在不同的数据库
        private String db_source; //数据库名称
        public Dept(String dname){
            this.dname=dname;
        }
}
