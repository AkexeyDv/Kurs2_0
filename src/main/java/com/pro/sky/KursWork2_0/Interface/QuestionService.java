package com.pro.sky.KursWork2_0.Interface;

import com.pro.sky.KursWork2_0.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
