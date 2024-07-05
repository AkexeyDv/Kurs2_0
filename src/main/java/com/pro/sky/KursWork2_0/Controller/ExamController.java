package com.pro.sky.KursWork2_0.Controller;

import com.pro.sky.KursWork2_0.Interface.ExaminerService;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {
    private final ExaminerService setQuestion;
    private final QuestionService javaQuestion;
    private final QuestionService mathQuestion;


    public ExamController(ExaminerService setQuestion,
                          @Qualifier("java") QuestionService javaQuestion,
                          @Qualifier("math") QuestionService mathQuestion) {
        this.setQuestion = setQuestion;
        this.javaQuestion=javaQuestion;
        this.mathQuestion = mathQuestion;
    }
    @GetMapping(path = "/get")
    public Collection<Question> getQuestion(@RequestParam("amount") int amount){
        return setQuestion.getQuestions(amount);
    }

}
