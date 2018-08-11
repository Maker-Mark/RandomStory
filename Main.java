package com.company;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
// will need 4 arrys
//         1. article, 2. noun, 3. verb, 4. preposition
//         creatings sentances by selecting one from each
//         in the order ARTICLE, NOUN, VERB, PREPOSITION, ARTICLE, NOUN.
//         Print the sentance, upper casing index of first and appending period to end
//         For loop it to generate a paragraph of 20 sentances

public class Main {

    public static Random randMach = new Random();
    public static void main(String[] args) throws Exception {
        final int MAX_VAL = 100;

        int countArt = 0, countVerb = 0, countNoun = 0, countPrep = 0;
        Scanner artFile = new Scanner(new File("Article.txt"));
        Scanner nounFile = new Scanner(new File("Noun.txt"));
        Scanner verbFile = new Scanner(new File("Verb.txt"));
        Scanner prepFile = new Scanner(new File("Preposition.txt"));

        String[] article = new String[MAX_VAL];
        String[] noun = new String[MAX_VAL];
        String[] verb = new String[MAX_VAL];
        String[] preposition = new String[MAX_VAL];
        countArt = populateArr(article, artFile);
        countNoun = populateArr(noun, nounFile);
        countVerb = populateArr(verb, verbFile);
        countPrep = populateArr(preposition, prepFile);

//         random(noun, countNoun),
//                random(verb, countVerb), random(preposition, countPrep),
//                random(article, countArt), random(noun, countNoun))
    for (int a = 0; a <= 4; a++) {
        for(int i = 0; i < 5; i++) {
            String randArt = random(article,countArt), randNoun = random(noun, countNoun),
            randVer = random(verb, countVerb), randPrep = random(preposition, countPrep),
                    randArt2 = random(article, countArt),
                    randNoun2 = random(noun, countNoun);

            System.out.print(randArt.substring(0,1).toUpperCase() + randArt.substring(1)+ " " + randNoun
                    + " " + randVer + " " + randPrep + " " + randArt2 + " " + randNoun2 + ". ");
        }
        System.out.println();
}



    }


    public static int populateArr(String[] x, Scanner file) {

        int count = 0;
        while (file.hasNext()) {
            x[count] = file.nextLine();
            count++;
        }
        return count;
    }

    public static String random(String[] x, int y) {

        int rand = 0;
        rand = randMach.nextInt(y);

        return x[rand];
    }

    public static String printSent(String art, String nou, String ver,
                                   String prep, String art2, String prep2) {
        int count = 0;
        int lastLett = art.length();
        String sent = art.substring(0, 1).toUpperCase() + art.substring(1).toLowerCase() +  " " + nou + " "  +
             " "  + ver + " "  + prep + " "  + art2 +  " " + prep + ".";
        return sent;
    }

}
