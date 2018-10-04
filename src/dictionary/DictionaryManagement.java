package dictionary;

import java.util.Scanner;

public class DictionaryManagement {


    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        Dictionary dic = new Dictionary();

        for (int i = 0; i < dic.DS.size(); i++) {
            //dic.DS.get(i) = new Word();
            dic.DS.get(i).word_target = sc.nextLine();
            dic.DS.get(i).word_explain = sc.nextLine();
        }
        sc.close();
    }

}