package com.pro.sky.KursWork2_0;

import com.pro.sky.KursWork2_0.Repository.JavaQuestionRepository;

import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        Random z=new Random();
        int i=0;
        while (i<=10){
            System.out.println(z.nextInt(2));
            i++;
        }
    }
}
