package com.example.datachange.utils;

import com.example.datachange.autoconfigure.DefaultProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hao.
 * @version 1.0
 * @since 2022/1/29 15:34
 */
@Component
public final class AudioUtils {

    static String path = DefaultProperties.file.getPath();

    public static byte[] mp3ToWavOfByte(String mp3Name) {
        byte[] body = null;
        //录音文件下拉地址
        String wavName = mp3Name.substring(0, mp3Name.lastIndexOf(".")) + ".wav";
        try {
            List<String> command = new ArrayList<>();
            command.add(DefaultProperties.file.getFfmpegPath());
            command.add("-i");
            command.add(path + mp3Name);
            command.add("-ar");
            command.add("16000");
            command.add("-acodec");
            command.add("pcm_s16le");
            command.add(path + wavName);
            String s = execCommandToString(command);
            // 获取文件流
            if (StringUtils.isNotEmpty(s)) {
                body = s.getBytes();
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // 执行完毕，删除下拉音频文件
//            FileUtils.deleteFile(DefaultProperties.file.getFfmpegPath() + wavName);
        }

        return body;
    }

    public static Process mp3ToWavOfProcess(String mp3Name) {
        //录音文件下拉地址
        init(path);
        String wavName = mp3Name.substring(0, mp3Name.lastIndexOf(".")) + ".wav";
        try {
            List<String> command = new ArrayList<>();
            command.add(DefaultProperties.file.getFfmpegPath());
            command.add("-i");
            command.add(path + mp3Name);
            command.add("-ar");
            command.add("16000");
            command.add("-acodec");
            command.add("pcm_s16le");
            command.add(path + wavName);
            return execCommandToProcess(command);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // 执行完毕，删除下拉音频文件
//            FileUtils.deleteFile(DefaultProperties.file.getFfmpegPath() + wavName);
        }

        return null;
    }

    private static Process execCommandToProcess(List<String> command) {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(command);
            //将标准输入流和错误输入流合并，通过标准输入流程读取信息
            builder.redirectErrorStream(true);
            return builder.start();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static String execCommandToString(List<String> command) {
        String outstring = null;
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(command);
            //将标准输入流和错误输入流合并，通过标准输入流程读取信息
            builder.redirectErrorStream(true);
            Process p = builder.start();
            outstring = waitFor(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return outstring;
    }

    private static void init(String path){
        //删除原来已经生成的m3u8及ts文件
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
    }

    private static String waitFor(Process p) {
        InputStream in = null;
        InputStream error;
        StringBuilder outputString = new StringBuilder();
        try {
            in = p.getInputStream();
            error = p.getErrorStream();
            boolean finished = false;
            int maxRetry = 600;//每次休眠1秒，最长执行时间10分种
            int retry = 0;
            while (!finished) {
                if (retry > maxRetry) {
                    return "error";
                }
                try {
                    while (in.available() > 0) {
                        Character c = (char) in.read();
                        outputString.append(c);
                        System.out.print(c);
                    }
                    while (error.available() > 0) {
                        Character c = (char) in.read();
                        outputString.append(c);
                        System.out.print(c);
                    }
                    finished = true;

                } catch (IllegalThreadStateException e) {
                    // 休眠1秒
                    Thread.sleep(1000);
                    retry++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return outputString.toString();

    }
}
