package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DictionaryManagement {
        Dictionary dt = new Dictionary();

    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        //Dictionary dic = new Dictionary();
        dt.n = Integer.parseInt(sc.nextLine());
        dt.words = new Word[dt.n];

        for (int i = 0; i < dt.n; i++) {
            dt.words[i] = new Word();
            dt.words[i].word_target = sc.nextLine();
            dt.words[i].word_explain = sc.nextLine();
        }
        sc.close();

    }
    public void insertFromFile()
    {
        String file = ("C:\\Users\\DELL\\IdeaProjects\\dictionaries.txt");

        try{
            FileInputStream fis = new FileInputStream(new File(file));
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str;
            int i=1;
            while ((str = br.readLine()) != null)
            {
                System.out.println(i + "     "+str);
                i++;
            }


        } catch (Exception e) {
        }

    }


}