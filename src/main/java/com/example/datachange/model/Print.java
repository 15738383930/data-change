package com.example.datachange.model;

import com.stars.datachange.model.response.DataChangeContrastResult;

import java.util.List;
import java.util.Map;

/**
 *
 * @author zhouhao
 * @since  2021/9/30 11:20
 */
public interface Print {

    static void print(Map<String, Object> param) {
        System.out.println("输出我的女朋友--------------");
        System.out.println(
                String.format("我的女朋友叫%s\n她平时很%s\n我们交往于%s\n她喜欢吃%s。",
                        param.get("name"), param.get("type"), param.get("socialTime"), param.get("favoriteFood").toString().replace(",", "、")));
        System.out.println("\n");
    }

    static void print(List<DataChangeContrastResult> param) {
        System.out.println("分析两任女朋友的差异--------------");
        param.forEach(o -> System.out.println(String.format("%s的差异：刚子是%s，小芳是%s", o.getName(), o.getOldData(), o.getNewData())));
        System.out.println("\n");
    }
}
