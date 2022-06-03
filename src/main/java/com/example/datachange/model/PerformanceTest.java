package com.example.datachange.model;

import com.example.datachange.model.code.V1_3GirlfriendCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.stars.datachange.annotation.ChangeModel;
import com.stars.datachange.annotation.ChangeModelProperty;
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
@ChangeModel(V1_3GirlfriendCode.class)
public class PerformanceTest {

    private String name;

    @ChangeModelProperty
    private Integer type;

    @JsonFormat(pattern = "yyyy-MM")
    private Date socialTime;

    @ChangeModelProperty(split = true)
    private String favoriteFood;

    @ChangeModelProperty(bitOperation = true)
    private Integer touristPlace;

    private String typeText;

    private String touristPlaceStr;
}

