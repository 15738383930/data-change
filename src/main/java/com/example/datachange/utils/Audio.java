package com.example.datachange.utils;

import com.example.datachange.autoconfigure.DefaultProperties;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Hao.
 * @version 1.0
 * @since 2022/1/29 15:34
 */
public enum Audio {
    //炸弹爆炸
    BombBlast("bombBlast.wav"),
    COMPLETE("complete.mp3")
    ;

    Audio(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void play() {
        AudioStream as;
        try {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("audio/" + name);
            as = new AudioStream(resourceAsStream);
            AudioPlayer.player.start(as);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void playMP3() {
        // 默认重试10次
        playMP3(10);
    }

    public void playMP3(int count) {
        AudioStream as;
        try {
            File file = new File(DefaultProperties.file.getPath() + name.substring(0, name.lastIndexOf(".")) + ".wav");
            if (!file.exists()) {
                if(count <= 0){
                    Audio.BombBlast.play();
                    return;
                }
                count--;
                AudioUtils.mp3ToWavOfByte(name);
                playMP3(count);
                return;
            }
            InputStream resourceAsStream = new FileInputStream(file);
            as = new AudioStream(resourceAsStream);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
