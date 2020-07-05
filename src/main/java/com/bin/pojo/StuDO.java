package com.bin.pojo;

import java.time.LocalDate;

public class StuDO {
    private int id;
    private String name;
    private int age;
    private int sex;
    private LocalDate birthday;
    private String addr;

    private StuPhoto stuPhoto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public StuPhoto getStuPhoto() {
        return stuPhoto;
    }

    public void setStuPhoto(StuPhoto stuPhoto) {
        this.stuPhoto = stuPhoto;
    }

    @Override
    public String toString() {
        return "StuDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", addr='" + addr + '\'' +
                ", stuPhoto=" + stuPhoto +
                '}';
    }
}
