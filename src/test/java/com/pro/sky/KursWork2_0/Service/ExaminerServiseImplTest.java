package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Interface.ExaminerService;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
@ExtendWith(MockitoExtension.class)
class ExaminerServiseImplTest {


@Mock
    ExaminerService examinerService;


    @Test
    void getQuestions() {
        Mockito.when(examinerService.getQuestions(2)).
                thenReturn(Set.of(
                        new Question("Вопрос1j","Ответ1"),
                        new Question("Вопрос1m","Ответ1")));

        Assertions.assertArrayEquals(Set.of(
                new Question("Вопрос1j","Ответ1"),
                new Question("Вопрос1m","Ответ1")).toArray(),examinerService.getQuestions(2).toArray());

    }
}