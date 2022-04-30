package com.example.datachange.test;

import com.alibaba.fastjson.JSON;
import com.example.datachange.model.GirlfriendBean;
import com.example.datachange.model.GirlfriendExt;
import com.example.datachange.utils.DateUtils;
import com.stars.datachange.utils.DataChangeUtils;

/**
 * 测试我的女朋友
 * @author zhouhao
 * @since  2021/9/30 11:23
 */
public class GirlfriendExtTest {

    public static void main(String[] args) throws Exception {
        GirlfriendExt build = new GirlfriendExt();
        build.setName("刚子");
        build.setFavoriteFood("1,3,5");
        build.setType(2);
        build.setSocialTime(DateUtils.parse("2018-06-18 00:00:00"));
        DataChangeUtils.dataChangeToBean(build);
        System.out.println(JSON.toJSONString(build));
    }
}
