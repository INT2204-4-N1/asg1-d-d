package dictionary;



public class DictionaryCommandline {
    public void showAllWords()
    {

        DictionaryManagement dtm = new DictionaryManagement();
        System.out.println("No  |English    |VietNam");
        dtm.insertFromFile();

    }
    public void dictionaryBasic()
    {
//        DictionaryManagement DM = new DictionaryManagement();
//        DM.insertFromCommandline();
        DictionaryCommandline DC = new DictionaryCommandline();
        DC.showAllWords();

    }
    public static void main(String[] abc)
    {
        DictionaryCommandline d  = new DictionaryCommandline();
        d.dictionaryBasic();
    }
}
