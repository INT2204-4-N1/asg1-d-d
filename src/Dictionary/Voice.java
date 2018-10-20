package Dictionary;

public class Voice {
    public Voice(String text){
        TextToSpeak ds= new TextToSpeak();
        ds.speak(text,2.0f,false,false);
    }

    public static void main( String[] dss)
    {
        Voice ds= new Voice("Hello");
    }
}
