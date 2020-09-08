package com.datasource;

import com.datasource.bean.PUser;
import com.datasource.service.PUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceApplicationTests {
    @Autowired
    private PUserService userService;

    @Test
    public void findUser() {
        List<Map<String, Object>> list1 = userService.findUser1();
        List<PUser> list2 = userService.findUser2();
        System.out.println(list1);
        System.out.println(list2);
    }
}
