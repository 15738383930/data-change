package com.example.datachange.config;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.stars.datachange.module.Compatible;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 自定义兼容配置
 * @author Hao.
 * @version 1.0
 * @since 2021/12/27 15:46
 */
@Component
public class DataChangeCompatibleConfig implements Compatible {

    @Override
    public void run(Class<?> dataClass, Map<String, Object> result, Collection<Class<? extends Annotation>> annotations) {
        Field[] fields = dataClass.getDeclaredFields();
        for(Field field : fields){
            if(!field.isAccessible()){
                field.setAccessible(true);
            }

            if(annotations.contains(JsonFormat.class)){
                jsonFormat(field, result);
            }

            // 这里加入其它注解的兼容（如：自定义的注解）
            /*if(CollectionUtils.isEmpty(list) || list.contains(...)){
                // ...
            }*/

        }
        if(!dataClass.getSuperclass().equals(Object.class)){
            run(dataClass.getSuperclass(), result, annotations);
        }
    }

    /**
     * 兼容{@link JsonFormat}
     * @param field 字段
     * @param result 数据转换结果集
     * @author zhouhao
     * @since  2021/9/7 10:15
     */
    protected static void jsonFormat(Field field, Map<String, Object> result){
        if (!field.isAnnotationPresent(JsonFormat.class)) {
            return;
        }

        JsonFormat anon = field.getAnnotation(JsonFormat.class);

        String name = field.getName();
        if(Objects.isNull(result.get(name))){
            return;
        }
        result.put(name, DateFormatUtils.format((Date) result.get(name), anon.pattern(), TimeZone.getTimeZone(anon.timezone())));
    }
}
