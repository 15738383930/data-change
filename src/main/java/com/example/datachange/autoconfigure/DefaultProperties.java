package com.example.datachange.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 外部配置属性
 * @author zhou
 * @since  2021/6/16 11:14
 */
@Component
public class  DefaultProperties {

    /** 文件配置信息 */
    public static File file;

    public DefaultProperties(File file){
        DefaultProperties.file = file;
    }

    @Data
    @Component
    @ConfigurationProperties("default.file")
    public static class File {

        /** 文件路径 */
        private String path = "";

        /** ffmpeg路径 */
        private String ffmpegPath = "";
    }
}
