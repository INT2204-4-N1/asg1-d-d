package uet.oop.bomberman;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class GameSound {
    public static GameSound instance;


    public static final String PLAYGAME = "/music/nhac_nen.wav";
    public static final String BOMBER_DIE = "/music/bomberDie.wav";
    public static final String MONSTER_DIE = "/music/enemyDie.wav";
    public static final String BONG_BANG = "/music/bomno.wav";
    public static final String ITEM = "/music/eatItems.wav";
    public static final String WIN = "/music/win.wav";
    public static final String END = "/music/endGame.wav";
    private HashMap<String, AudioClip> audioMap;

    public GameSound() {
        audioMap = new HashMap<>();
        loadAllAudio();
    }

    public static GameSound getIstance() {
        if (instance == null) {
            instance = new GameSound();
        }

        return instance;
    }

    public void loadAllAudio() {
        putAudio(PLAYGAME);

        putAudio(MONSTER_DIE);
        putAudio(BOMBER_DIE);
        putAudio(BONG_BANG);
        putAudio(ITEM);
        putAudio(WIN);
        putAudio(END);

    }
    public void stop() {
        getAudio(PLAYGAME).stop();
//        getAudio(PLAY).stop();
//        getAudio(MENU).stop();
//
//        getAudio(BOMB).stop();
        getAudio(BONG_BANG).stop();
//        getAudio(WIN).stop();
        getAudio(END).stop();
    }

    public void putAudio(String name) {
        AudioClip auClip = Applet.newAudioClip(GameSound.class.getResource(name));
        audioMap.put(name, auClip);
    }

    public AudioClip getAudio(String name) {
        return audioMap.get(name);
    }

}
