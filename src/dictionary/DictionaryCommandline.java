package dictionary;
public class
DictionaryCommandline {
    public void showAllWords()
    {
        Dictionary dict = new Dictionary();
        System.out.println("No  |English        |VietNam    ");

        for(int i=0;  i< dict.DS.size();i++)
        {
            System.out.println((i+1)+"  |"+dict.DS.get(i).word_target+"        |"+dict.DS.get(i).word_explain);
        }

    }
    public void dictionaryBasic()
    {
        DictionaryManagement DM = new DictionaryManagement();
        DM.insertFromCommandline();
        DictionaryCommandline DC = new DictionaryCommandline();
        DC.showAllWords();
    }
    public static void main(String[] abc)
    {
        DictionaryCommandline d  = new DictionaryCommandline();
        d.dictionaryBasic();
    }
}
