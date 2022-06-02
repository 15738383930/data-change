package com.example.datachange.test;

import com.example.datachange.model.V1_3Girlfriend;
import com.example.datachange.model.code.DefaultBaseCode;
import com.example.datachange.utils.DateUtils;
import com.stars.datachange.utils.DataChangeUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

            Stream.of("100", "200").map(DefaultBaseCode.TEST_100::value).forEach(System.out::println);

            Stream.of("测试二", "测试一").map(DefaultBaseCode.TEST_200::key).forEach(System.out::println);

            System.out.println("--------------n------------正确的测试---------------------n------------------");
        }

        System.out.println("\n");

        {
            System.out.println("--------------s------------错误的测试---------------------s------------------");

            Stream.of("100", "200").map(DefaultBaseCode.STATUS_2::value).forEach(System.out::println);

            Stream.of("刚子", "测试二").map(DefaultBaseCode.STATUS_2::key).forEach(System.out::println);

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
