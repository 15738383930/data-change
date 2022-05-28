package com.example.datachange.test;

import com.example.datachange.model.V1_3Girlfriend;
import com.example.datachange.model.code.DefaultBaseCode;
import com.example.datachange.utils.DateUtils;
import com.stars.datachange.utils.DataChangeUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 新功能测试
 * @author Hao.
 * @version 1.3
 * @since 2022/5/28 16:36
 */
@Slf4j
public class V1_3Test {

    public static void main(String[] args) {
        {
            System.out.println("--------------s------------正确的测试---------------------s------------------");

            String tvalue = DefaultBaseCode.TEST_100.value("100");
            System.out.println(String.format("正确的测试：%s", tvalue));

            String tvalue2 = DefaultBaseCode.TEST_100.value("200");
            System.out.println(String.format("正确的测试：%s", tvalue2));

            String tvalue3 = DefaultBaseCode.TEST_200.value("200");
            System.out.println(String.format("正确的测试：%s", tvalue3));

            String tkey = DefaultBaseCode.TEST_200.key("测试二");
            System.out.println(String.format("正确的测试：%s", tkey));

            System.out.println("--------------n------------正确的测试---------------------n------------------");
        }

        System.out.println("\n");

        {
            System.out.println("--------------s------------错误的测试---------------------s------------------");

            String svalue = DefaultBaseCode.STATUS_2.value("100");
            System.out.println(String.format("错误的测试：%s", svalue));

            String svalue2 = DefaultBaseCode.STATUS_2.value("0");
            System.out.println(String.format("错误的测试：%s", svalue2));

            String skey = DefaultBaseCode.STATUS_2.key("刚子");
            System.out.println(String.format("错误的测试：%s", skey));

            System.out.println("--------------n------------错误的测试---------------------n------------------");
        }

        System.out.println("\n");

        {
            System.out.println("--------------s------------v1.3女朋友测试---------------------s------------------");

            List<V1_3Girlfriend> listn = new ArrayList<>();
            listn.add(V1_3Girlfriend.builder().name("刚子").favoriteFood("1,3,5").type(2).socialTime(DateUtils.parse("2018-06-18 00:00:00")).build());
            listn.add(V1_3Girlfriend.builder().name("天天").favoriteFood("1,5").type(1).socialTime(DateUtils.parse("2020-06-18 00:00:00")).build());
            listn.forEach(DataChangeUtils::dataChangeToBean);
            listn.forEach(System.out::println);

            System.out.println("--------------n------------v1.3女朋友测试---------------------n------------------");
        }
    }
}
