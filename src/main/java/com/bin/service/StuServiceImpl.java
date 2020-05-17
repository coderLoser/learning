package com.bin.service;

import com.bin.pojo.StuDO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StuServiceImpl implements StuService {
    @Override
    public List<StuDO> listStus(int age) {
        System.out.println("查询 age >= " + age + " 的数据；");
        StuDO stu1 = new StuDO() {{
            setId(10001); setName("lwj"); setAge(age); setSex(0);
            setBirthday(LocalDate.of(1994, 2, 23));
            setAddr("火星平行区向阳街");
        }};
        StuDO stu2 = new StuDO() {{
            setId(10001); setName("lwj"); setAge(age); setSex(0);
            setBirthday(LocalDate.of(1994, 2, 23));
            setAddr("火星川湖区火江");
        }};
        return new ArrayList<StuDO>() {{add(stu1); add(stu2);}};
    }

    @Override
    public StuDO getStu(int id) {
        System.out.println("查询 id = " + id + " 的数据；");
        return new StuDO() {{
            setId(10001); setName("lwj"); setAge(18); setSex(0);
            setBirthday(LocalDate.of(1994, 2, 23));
            setAddr("火星川湖区火江");
        }};
    }
}
