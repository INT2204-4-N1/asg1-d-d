package uet.oop.bomberman;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.io.FileInputStream;
import java.io.IOException;

public class Sound {
    public void bomNo(){
        AudioPlayer audioPlayer = AudioPlayer.player;
        AudioStream audioStream;
        AudioData audioData;
        ContinuousAudioDataStream loop = null;
        try {
            audioStream = new AudioStream(new FileInputStream("bomno.wav"));
            audioData = audioStream.getData();
            loop = new ContinuousAudioDataStream(audioData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        audioPlayer.start(loop);
    }
}
