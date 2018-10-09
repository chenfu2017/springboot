package com.chenfu.pojo;

import javax.persistence.*;

public class Police {
    @Id
    private String policeid;

    private String nickname;

    private String password;

    /**
     * @return policeid
     */
    public String getPoliceid() {
        return policeid;
    }

    /**
     * @param policeid
     */
    public void setPoliceid(String policeid) {
        this.policeid = policeid;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}