package com.example.datachange.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stars.datachange.annotation.ChangeModel;
import com.stars.datachange.annotation.ChangeModelProperty;
import com.example.datachange.model.code.GirlfriendCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 女朋友
 * @author zhou
 * @since 2021/9/9 11:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ChangeModel(GirlfriendCode.class)
public class GirlfriendChange {

    /** 名字 */
    private String name;

    /** 类型： 1-安静 2-火辣 3-清爽 */
    @ChangeModelProperty
    private Integer type;

    /** 交往时间 */
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    private Date socialTime;

    /**
     * 喜欢的食物： 1-牛奶 2-香蕉 -香肠 4-黄瓜 5-火锅
     */
    @ChangeModelProperty(split = true)
    private String favoriteFood;

    /** 照片 */
    private List<String> photo;

    @ChangeModelProperty(value = "旅游地： 2-夏威夷 4-摩洛哥 8-马尔代夫", bitOperation = true)
    private Integer touristPlace;
}

