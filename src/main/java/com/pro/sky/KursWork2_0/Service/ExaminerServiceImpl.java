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
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaExamQuestion;
    private final QuestionService mathExamQuestion;
    private final Set<Question> questionSet;

    private Random mathJava = new Random();

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaExamQuestion,
                               @Qualifier("math") QuestionService mathExamQuestion) {
        this.javaExamQuestion = javaExamQuestion;
        this.mathExamQuestion = mathExamQuestion;
        this.questionSet = new HashSet<>();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Random departQuestion = new Random();

       if (amount > javaExamQuestion.getAll().size() + mathExamQuestion.getAll().size()) {
           throw new ExceptionApp("Превышено количество запрашиваемых вопросов");
        }
        while (questionSet.size() < amount) {
            if (departQuestion.nextInt(2) == 0) {
                questionSet.add(javaExamQuestion.getRandomQuestion());
            } else {
                questionSet.add(mathExamQuestion.getRandomQuestion());
            }
        }
        return questionSet;
    }
}
