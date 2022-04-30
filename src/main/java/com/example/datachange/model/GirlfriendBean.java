package com.example.datachange.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stars.datachange.annotation.ChangeModel;
import com.stars.datachange.annotation.ChangeModelProperty;
import com.stars.datachange.model.code.GirlfriendCode;
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
public class GirlfriendBean {

    /** 名字 */
    private String name;

    /** 类型： 1-安静 2-火辣 3-清爽 */
    @ChangeModelProperty(mapping = "typeText")
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

    /** 类型文本 */
    private String typeText;
}

