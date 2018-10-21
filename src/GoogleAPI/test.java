package GoogleAPI;

import javazoom.jl.decoder.JavaLayerException;

import java.io.IOException;
import java.io.InputStream;

public class test {
    public static void main(String[] args) throws IOException, JavaLayerException {
        Audio audio = Audio.getInstance();
<<<<<<< HEAD:src/GoogleAPI/test.java
        InputStream sound = audio.getAudio("anh", Language.VIETNAMESE);
=======
        InputStream sound = audio.getAudio("Hello Dũng!", Language.ENGLISH);
>>>>>>> origin/master:src/GoogleAPI/GoogleAPI/MainTest.java
        audio.play(sound);
        String str =GoogleTranslate.translate("vi","en","xin chào");
        System.out.println(str);
    }
}
