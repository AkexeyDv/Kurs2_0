package com.pro.sky.KursWork2_0;

import com.pro.sky.KursWork2_0.Repository.JavaQuestionRepository;

public class Sample {
    public static void main(String[] args) {
        JavaQuestionRepository javaRep=new JavaQuestionRepository();
        javaRep.add(new Question("3","Otvet3"));
        javaRep.add(new Question("4","Otvet4"));
        System.out.println(javaRep.toString());
    }
}
