package com.example.datachange.test;

import com.example.datachange.model.PerformanceTest;
import com.stars.datachange.utils.DataChangeUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试我的女朋友
 * @author zhouhao
 * @since  2021/9/30 11:23
 */
public class PerformanceTests {

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();

        List<PerformanceTest> param = initData(10000);

        final List<Map<String, Object>> result = param.stream().map(DataChangeUtils::dataChange).collect(Collectors.toList());

        final long end = System.currentTimeMillis();

        System.out.println(String.format("长度：%s", result.size()));
        System.out.println(result.get(0));

        final double time = (end - start) / 1000.00;
        System.out.println(String.format("耗时：%s秒", time));
    }

    public static List<PerformanceTest> initData(int count){
        List<PerformanceTest> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PerformanceTest build = new PerformanceTest();
            build.setName("刚子" + i);
            build.setFavoriteFood(getFavoriteFood());
            build.setType(RandomUtils.nextInt(1, 4));
            build.setTouristPlace(getTouristPlace());
            result.add(build);
        }
        return result;
    }

    public static String getFavoriteFood(){
        Set<String> sb = new HashSet<>();
        int size = RandomUtils.nextInt(1, 6);
        for (int i = 1; i <= size; i++) {
            sb.add(String.valueOf(RandomUtils.nextInt(1, 6)));
        }
        return String.join(",", sb);
    }

    public static int getTouristPlace(){
        Set<Integer> sb = new HashSet<>();
        int size = RandomUtils.nextInt(1, 4);
        for (int i = 1; i <= size; i++) {
            sb.add(touristPlace.get(RandomUtils.nextInt(1, 4)));
        }
        return sb.stream().mapToInt(o -> o).sum();
    }

    static Map<Integer, Integer> touristPlace = new HashMap<>();
    static {
        touristPlace.put(1, 2);
        touristPlace.put(2, 4);
        touristPlace.put(3, 8);
    }
}
