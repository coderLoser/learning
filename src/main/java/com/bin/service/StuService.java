package com.bin.service;

import com.bin.pojo.StuDO;

import java.util.List;

public interface StuService {
    List<StuDO> listStus(int age);
    StuDO getStu(int id);
}
