package com.example.datachange.config;


import com.stars.datachange.model.response.DataDictionaryResult;
import com.stars.datachange.module.DataDictionary;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 自定义数据字典配置
 * @author Hao.
 * @version 1.0
 * @since 2021/12/27 15:46
 */
@Component
public class DataDictionaryConfig implements DataDictionary {

    // 注入自己的mapper
    // private XXXMapper xxxMapper;


    @Override
    public Set<DataDictionaryResult> dataDictionary(String key) {
        // 使用自己mapper的查询方法
        {
            // 返回值类型必须为：Set<DataDictionaryResult>
            // Set<DataDictionaryResult> result = xxxMapper.findList(key);
            // return result;
        }

        // 模拟查询数据字典
        return findList(key);
    }

    public Set<DataDictionaryResult> findList(String key) {

        // all（Map）的key 对应@ChangeModel中的 modelName
        Map<String, Set<DataDictionaryResult>> all = new HashMap<>();

        //与com.example.datachange.model.GirlfriendChange对应
        all.put("starsGirlfriend", girlfriend());

        //与com.example.datachange.model.Other对应
        // 若modelName为空，默认取类名，首字母小写
        all.put("other", other());

        // 模拟执行SQL查询语句 获得结果
        return all.get(key);
    }

    public Set<DataDictionaryResult> girlfriend() {
        Set<DataDictionaryResult> result = new HashSet<>();

        DataDictionaryResult r = new DataDictionaryResult();
        r.setName("type");
        r.setMaps(new LinkedHashSet<>(Arrays.asList(
                DataDictionaryResult.Map.builder().code("1").value("安静-自定义").build(),
                DataDictionaryResult.Map.builder().code("2").value("火辣-自定义").build(),
                DataDictionaryResult.Map.builder().code("3").value("清爽-自定义").build()
        )));
        result.add(r);

        r = new DataDictionaryResult();
        r.setName("favoriteFood");
        r.setMaps(new LinkedHashSet<>(Arrays.asList(
                DataDictionaryResult.Map.builder().code("1").value("牛奶-自定义").build(),
                DataDictionaryResult.Map.builder().code("2").value("香蕉-自定义").build(),
                DataDictionaryResult.Map.builder().code("3").value("香肠-自定义").build(),
                DataDictionaryResult.Map.builder().code("4").value("黄瓜-自定义").build(),
                DataDictionaryResult.Map.builder().code("5").value("火锅-自定义").build()
        )));
        result.add(r);

        r = new DataDictionaryResult();
        r.setName("touristPlace");
        r.setMaps(new LinkedHashSet<>(Arrays.asList(
                DataDictionaryResult.Map.builder().code("2").value("夏威夷-自定义").build(),
                DataDictionaryResult.Map.builder().code("4").value("摩洛哥-自定义").build(),
                DataDictionaryResult.Map.builder().code("8").value("马尔代夫-自定义").build()
        )));
        result.add(r);
        return result;
    }

    public Set<DataDictionaryResult> other() {
        Set<DataDictionaryResult> result = new HashSet<>();

        DataDictionaryResult r = new DataDictionaryResult();
        r.setName("default_");
        r.setMaps(new LinkedHashSet<>(Arrays.asList(
                DataDictionaryResult.Map.builder().code("1").value("默认一").build(),
                DataDictionaryResult.Map.builder().code("2").value("默认二").build(),
                DataDictionaryResult.Map.builder().code("3").value("默认三").build()
        )));
        result.add(r);

        r = new DataDictionaryResult();
        r.setName("status");
        r.setMaps(new LinkedHashSet<>(Arrays.asList(
                DataDictionaryResult.Map.builder().code("1").value("开始").build(),
                DataDictionaryResult.Map.builder().code("2").value("运行").build(),
                DataDictionaryResult.Map.builder().code("3").value("结束").build()
        )));
        result.add(r);

        return result;
    }
}
