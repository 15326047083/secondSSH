package com.ambow.second.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 部门
 */
@Entity
@Table(name = "dept")
public class Dept {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id; // 主键
    @Column(name = "name")
    private String name; // 部门名称
    @Column(name = "info")
    private String info; // 部门信息
    @Column(name = "num")
    private int num; // 部门下人员数量
    @Column(name = "userId")
    private String userId; // 部门经理ID
    @Column(name = "alive")
    private int alive; // 部门状态（0为正常 1为注销）

    public Dept() {

    }

    public Dept(String id, String name, String info, int num, String userId, int alive) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.num = num;
        this.userId = userId;
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", num=" + num +
                ", userId='" + userId + '\'' +
                ", alive=" + alive +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAlive() {
        return alive;
    }

    public void setAlive(int alive) {
        this.alive = alive;
    }
}
