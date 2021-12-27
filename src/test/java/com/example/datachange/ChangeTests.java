package com.example.datachange;

import com.example.datachange.model.Girlfriend;
import com.example.datachange.model.Print;
import com.example.datachange.utils.DateUtils;
import com.stars.datachange.utils.DataChangeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChangeTests {

    @Test
    void contextLoads() throws Exception {

        // 女朋友字典转换
        Print.print(DataChangeUtils.dataChange(Girlfriend.builder()
                .name("刚子")
                .favoriteFood("1,3,5")
                .type(2)
                .socialTime(DateUtils.parse("2018-06-18 00:00:00")).build()));
    }

}
