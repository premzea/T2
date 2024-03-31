package model;

//UserInteractions.java

import java.util.Scanner;

public class UserInteractions{

    public static int askUserInput(String question, int maxOption){
        Scanner sc = new Scanner(System.in);
        int entry = -1;
        while( entry < 1 || entry > maxOption){
            System.out.println(question);
            entry = sc.nextInt();
            if (entry < 1 || entry > maxOption){
                System.out.println("Response is not a valid option, please choose again");
            }
        }
        sc.close();
        return entry;
    }
}