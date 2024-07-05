package com.pro.sky.KursWork2_0.Repository;

import com.pro.sky.KursWork2_0.Exception.ExceptionApp;
import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import com.pro.sky.KursWork2_0.Service.JavaQuestionService;
import com.pro.sky.KursWork2_0.Service.MathQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    QuestionRepository mathRep=new MathQuestionRepository();
    QuestionService out=new MathQuestionService(mathRep);

    @BeforeEach
    void setUp() {
        out.add(new Question("Вопрос для удаления","Ответ на вопрос для удаления"));
    }

    @Test
    void add() {
        Assertions.assertEquals(new Question("1","2"),out.add(new Question("1","2")));
    }

    @Test
    void addThrow() {
        Assertions.assertThrows(ExceptionApp.class,()->out.add(null));
    }

    @Test
    void remove() {
        Assertions.assertEquals(new Question("Вопрос для удаления","Ответ на вопрос для удаления"),
                out.remove(new Question("Вопрос для удаления","Ответ на вопрос для удаления")));
        Assertions.assertThrows(ExceptionApp.class,()->
                out.remove(new Question("Вопрос для удаления","Ответ на вопрос для удаления")));
    }



}