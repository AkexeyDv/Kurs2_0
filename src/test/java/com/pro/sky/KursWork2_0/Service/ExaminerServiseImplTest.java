package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Interface.ExaminerService;
import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.KursWork20Application;
import com.pro.sky.KursWork2_0.Repository.JavaQuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;

@ExtendWith(MockitoExtension.class)
class ExaminerServiseImplTest {

    @Mock
    private QuestionService javaQuestion ;
    @Mock
    private QuestionService mathQuestion;
    @Mock
    private ExaminerService examinerService;


   // ExaminerService examinerService = new ExaminerServiceImpl(javaQuestion, mathQuestion);

    @BeforeEach
    void setUp(){

        examinerService = new ExaminerServiceImpl(javaQuestion, mathQuestion);
        System.out.println(javaQuestion.getAll());

    }




    @Test
    void getQuestions() {
        Mockito.when(javaQuestion.getRandomQuestion())
                .thenReturn(Constants.JAVA_QUESTIONS.get(0))
                .thenReturn(Constants.JAVA_QUESTIONS.get(1));


        Mockito.when(mathQuestion.getRandomQuestion())
                .thenReturn(Constants.MATH_QUESTIONS.get(0))
                .thenReturn(Constants.MATH_QUESTIONS.get(1));


        Assertions.assertEquals(2, examinerService.getQuestions(2).size());

    }
}
