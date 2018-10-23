package com.chenfu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
@Getter
@Setter
public class Police {
    @Id
    private String policeid;

    private Integer sex;

    private String address;

    private String organization;

    private String nickname;

    private String password;

}