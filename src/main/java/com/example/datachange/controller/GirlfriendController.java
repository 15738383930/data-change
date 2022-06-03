package com.example.datachange.controller;

import com.example.datachange.model.GirlfriendDb;
import com.example.datachange.model.Print;
import com.example.datachange.model.code.GirlfriendCode;
import com.example.datachange.test.PerformanceToBeanTests;
import com.example.datachange.utils.Audio;
import com.example.datachange.utils.DateUtils;
import com.stars.datachange.utils.DataChangeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 女朋友控制器
 * @author zhouhao
 * @since  2021/9/30 12:49
 */
@RestController
public class GirlfriendController {

    @GetMapping
    public String print() throws Exception {

        // 女朋友字典转换
        GirlfriendDb build = GirlfriendDb.builder()
                .name("刚子")
                .favoriteFood("1,3,5")
                .type(2)
                .socialTime(DateUtils.parse("2018-06-18 00:00:00")).build();
        DataChangeUtils.dataChangeToBean(build);
        System.out.println(build);


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

        Audio.COMPLETE.playMP3();

        return "操作成功！请查看你的控制台。";
    }

    @GetMapping("{count}")
    public String performanceTest(@PathVariable("count") int count) {

        PerformanceToBeanTests.test(count);

        return "操作成功！请查看你的控制台。";
    }

}
