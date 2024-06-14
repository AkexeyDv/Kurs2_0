package com.pro.sky.KursWork2_0.Interface;

import com.pro.sky.KursWork2_0.Question;
import jakarta.annotation.PostConstruct;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
