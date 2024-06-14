package com.pro.sky.KursWork2_0.Interface;

import com.pro.sky.KursWork2_0.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
