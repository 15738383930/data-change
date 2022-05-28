package com.example.datachange.model.code;


import com.stars.datachange.model.code.BaseCode;
import com.stars.datachange.utils.StringUtils;

public enum DefaultBaseCode implements BaseCode {

    /**
     *
     */
    STATUS_1("status", "1", "准备"),
    STATUS_2("status", "2", "开始"),
    STATUS_3("status", "3", "结束"),

    TEST_100("test", "100", "测试一"),
    TEST_200("test", "200", "测试二"),

    ;

    private final String t;
    private final String k;
    private final String v;

    DefaultBaseCode(String t, String k, String v) {
        this.t = t;
        this.k = k;
        this.v = v;
    }

    @Override
    public String t() {
        return t;
    }

    @Override
    public String k() {
        return k;
    }

    @Override
    public String v() {
        return v;
    }

    @Override
    public String value(String k) {
        if (StringUtils.isNotEmpty(k)) {
            DefaultBaseCode[] values = DefaultBaseCode.values();
            for (DefaultBaseCode o : values) {
                if (o.t().equals(t()) && o.k().equals(k)) {
                    return o.v();
                }
            }
        }
        return k;
    }

    @Override
    public String key(String v) {
        if (StringUtils.isNotEmpty(v)) {
            DefaultBaseCode[] values = DefaultBaseCode.values();
            for (DefaultBaseCode o : values) {
                if (o.t().equals(t()) && o.v().equals(v)) {
                    return o.k();
                }
            }
        }
        return v;
    }

}
