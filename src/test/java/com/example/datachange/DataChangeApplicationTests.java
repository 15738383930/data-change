package com.example.datachange;

import com.example.datachange.model.GirlfriendDb;
import com.example.datachange.model.Print;
import com.example.datachange.model.code.GirlfriendCode;
import com.example.datachange.utils.DateUtils;
import com.stars.datachange.utils.DataChangeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataChangeApplicationTests {

    @Test
    void contextLoads() throws Exception {

        // 女朋友字典转换
        Print.print(DataChangeUtils.dataChange(GirlfriendDb.builder()
                .name("刚子")
                .favoriteFood("1,3,5")
                .type(2)
                .socialTime(DateUtils.parse("2018-06-18 00:00:00")).build()));


        // 女朋友差异对比:数据字典模式

        // 女朋友：刚子
        GirlfriendDb girlfriend1 = GirlfriendDb.builder()
                .name("刚子")
                .favoriteFood("1,3,5")
                .type(Integer.parseInt(GirlfriendCode.TYPE_2.getK()))
                .socialTime(DateUtils.parse("2018-06-18 00:00:00")).build();

        // 女朋友：小芳
        GirlfriendDb girlfriend2 = GirlfriendDb.builder()
                .name("小芳")
                .favoriteFood("1,2,3")
                .type(Integer.parseInt(GirlfriendCode.TYPE_1.getK()))
                .socialTime(DateUtils.parse("2020-11-11 00:00:00")).build();

        // 女朋友差异分析
        Print.print(DataChangeUtils.dataContrast(girlfriend1, girlfriend2));
    }

}
