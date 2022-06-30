package com.zhoujc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 25975
 */
@Data
@TableName("user")
public class User {

    private long id;
    private String name;
    private String url;
    private String alexa;
    private String country;

}
