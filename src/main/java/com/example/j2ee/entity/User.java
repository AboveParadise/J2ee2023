package com.example.j2ee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "users")
public class User {
    @ApiModelProperty("主键ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("头像")
    private String profile_pic;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("生日")
    private Date birth;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("身份")
    private Integer identity;

    @ApiModelProperty("是否为管理员")
    private Boolean is_admin;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("借书余额")
    private Integer balance;

    @ApiModelProperty("电话")
    private String tel;

    @ApiModelProperty("用户名")
    private String username;

}
