package ru.ivanov;

import java.util.Scanner;

public class Main{


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            int temp = sc.nextInt();

            if(temp<min) min = temp;
            System.out.println(min);
        }
    }
}