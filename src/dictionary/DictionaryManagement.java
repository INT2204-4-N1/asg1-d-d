package dictionary;

import java.util.Scanner;

public class DictionaryManagement {


    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        Dictionary dic = new Dictionary();

        dic.n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < dic.n; i++) {
            dic.words[i] = new Word();
            dic.words[i].word_target = sc.nextLine();
            dic.words[i].word_explain = sc.nextLine();
        }
        sc.close();
    }

}