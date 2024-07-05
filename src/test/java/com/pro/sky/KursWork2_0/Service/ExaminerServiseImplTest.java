package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Exception.ExceptionApp;
import com.pro.sky.KursWork2_0.Interface.ExaminerService;
import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import com.pro.sky.KursWork2_0.Repository.JavaQuestionRepository;
import com.pro.sky.KursWork2_0.Repository.MathQuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ExtendWith(MockitoExtension.class)
class ExaminerServiseImplTest {

    QuestionRepository javaRep = new JavaQuestionRepository();

    QuestionRepository mathRep = new MathQuestionRepository();
    @Mock
    private QuestionService javaQuestion;

    @Mock
    private QuestionService mathQuestion;

    private ExaminerServiceImpl examinerService ;

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(javaQuestion, mathQuestion);

    }


    @Test
    void getQuestions() {
        Mockito.when(javaQuestion.getAll()).thenReturn(List.of(new Question("Java3", "JavaOtv3"),
                new Question("Java4", "JavaOtv4")));
        Mockito.when(mathQuestion.getAll()).thenReturn(List.of(new Question("Math1", "MathOtv1"),
               new Question("Math3", "MathOtv3")));

        Mockito.when(javaQuestion.getRandomQuestion()).thenReturn(getJavaQuestion());
        Mockito.when(mathQuestion.getRandomQuestion()).thenReturn(getMathQuestion());



        Assertions.assertEquals(2, examinerService.getQuestions(2).size());

    }

    @Test
    void throwGetQuestion(){
        Mockito.when(javaQuestion.getAll()).thenReturn(new ArrayList<>());
        Mockito.when(mathQuestion.getAll()).thenReturn(new ArrayList<>());

        Assertions.assertThrows(ExceptionApp.class,()->examinerService.getQuestions(2));




    }

    public Question getJavaQuestion() {

        return new Question("Java4", "JavaOtv4");
    }

    public Question getMathQuestion() {

        return new Question("Math4", "MathOtv4");
    }
}
