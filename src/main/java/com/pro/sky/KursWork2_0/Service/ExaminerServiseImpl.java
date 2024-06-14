package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Exception.ExceptionApp;
import com.pro.sky.KursWork2_0.Interface.ExaminerService;
import com.pro.sky.KursWork2_0.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiseImpl implements ExaminerService {
    private final JavaQuestionService javaExamQuestion;
    private final MathQuestionService mathExamQuestion;
    Set<Question> questionSet=new HashSet<>();
    private Random mathJava=new Random();

    public ExaminerServiseImpl(JavaQuestionService examQuestion, MathQuestionService mathExamQuestion) {
        this.javaExamQuestion = examQuestion;
        this.mathExamQuestion = mathExamQuestion;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount> javaExamQuestion.getAll().size()){
            throw new ExceptionApp("Превышено количество запрашиваемых вопросов");
        }
        while (questionSet.size()<amount){

            if(mathJava.nextInt(2)==0){

                questionSet.add(javaExamQuestion.getRandomQuestion());
            }else{
                questionSet.add(mathExamQuestion.getRandomQuestion());
            }

        }
        return questionSet;
    }
}
