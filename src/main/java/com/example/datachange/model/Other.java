package com.example.datachange.model;

import com.stars.datachange.annotation.ChangeModel;
import com.stars.datachange.annotation.ChangeModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 模拟DB查询的数据模型
 * @author zhou
 * @since 2021/9/9 11:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ChangeModel(source = ChangeModel.Source.DB)
public class Other {

    /** 默认： 1-默认一 2-默认二 3-默认三 */
    @ChangeModelProperty
    private Integer default_;

    /** 状态： 1-开始 2-运行 3-结束 */
    @ChangeModelProperty("状态")
    private Integer status;

    private String default_Custom;

    private String statusText;
}

