package com.example.datachange.controller;

import com.example.datachange.model.Other;
import com.example.datachange.utils.Audio;
import com.stars.datachange.utils.DataChangeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 其他控制器
 * @author zhouhao
 * @since  2021/9/30 12:49
 */
@RequestMapping("other")
@RestController
public class OtherController {

    @GetMapping
    public String print() {

        // 女朋友字典转换
        Other build = Other.builder()
                .default_(1)
                .status(2)
                .build();
        DataChangeUtils.dataChangeToBean(build);
        System.out.println(build);

        Audio.COMPLETE.playMP3();

        return "操作成功！请查看你的控制台。";
    }

}
