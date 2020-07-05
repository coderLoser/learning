package com.bin.design.proxy;

import com.bin.pojo.StuDO;

import java.util.List;

public interface StuMapper {
    List<StuDO> listStuByAge(int age);
    long countStu();
    StuDO getStu(int id);
}
