package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Exception.ExceptionApp;
import com.pro.sky.KursWork2_0.Interface.ExaminerService;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiseImpl implements ExaminerService {
    private final QuestionService javaExamQuestion;
    private final QuestionService mathExamQuestion;

    private Random mathJava=new Random();

    public ExaminerServiseImpl(@Qualifier("java") QuestionService javaExamQuestion, @Qualifier("math") QuestionService mathExamQuestion) {
        this.javaExamQuestion = javaExamQuestion;
        this.mathExamQuestion = mathExamQuestion;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet=new HashSet<>();
        if (amount> javaExamQuestion.getAll().size()+mathExamQuestion.getAll().size()){
            throw new ExceptionApp("Превышено количество запрашиваемых вопросов");
        }
        while (questionSet.size()<amount){


                questionSet.add(javaExamQuestion.getRandomQuestion());
                questionSet.add(mathExamQuestion.getRandomQuestion());

        }
        return questionSet;
    }
}
