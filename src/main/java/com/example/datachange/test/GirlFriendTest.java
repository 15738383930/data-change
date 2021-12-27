package com.example.datachange.test;

import com.example.datachange.model.Girlfriend;
import com.example.datachange.model.GirlfriendChange;
import com.example.datachange.model.Print;
import com.example.datachange.utils.DateUtils;
import com.stars.datachange.model.code.GirlfriendCode;
import com.stars.datachange.utils.DataChangeUtils;

/**
 * 测试我的女朋友
 * @author zhouhao
 * @since  2021/9/30 11:23
 */
public class GirlFriendTest {

    public static void main(String[] args) throws Exception {

        // 女朋友字典转换
        Print.print(DataChangeUtils.dataChange(GirlfriendChange.builder()
                .name("刚子")
                .favoriteFood("1,3,5")
                .type(2)
                .touristPlace(12)
                .socialTime(DateUtils.parse("2018-06-18 00:00:00")).build()));


        // 女朋友差异对比:字典枚举模式

        // 女朋友：刚子
        Girlfriend girlfriend1 = Girlfriend.builder()
                .name("刚子")
                .favoriteFood("1,3,5")
                .type(Integer.parseInt(GirlfriendCode.TYPE_2.getK()))
                .socialTime(DateUtils.parse("2018-06-18 00:00:00")).build();

        // 女朋友：小芳
        Girlfriend girlfriend2 = Girlfriend.builder()
                .name("小芳")
                .favoriteFood("1,2,3")
                .type(Integer.parseInt(GirlfriendCode.TYPE_1.getK()))
                .socialTime(DateUtils.parse("2020-11-11 00:00:00")).build();

        // 女朋友差异分析
        Print.print(DataChangeUtils.dataContrast(girlfriend1, girlfriend2));
    }
}
