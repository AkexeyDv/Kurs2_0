package com.pro.sky.KursWork2_0.Controller;

import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/math")
public class MathController {
    private final QuestionService mathQuestionRepository;

    public MathController(@Qualifier("math") QuestionService mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }
    @GetMapping
    public Collection<Question> getAll(){
        return mathQuestionRepository.getAll();
    }

    @GetMapping(path = "/add")
    public Question getQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer){
        return mathQuestionRepository.add(new Question(question,answer));
    }
    @GetMapping(path = "/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer){
        return mathQuestionRepository.remove(new Question(question,answer));
    }

}
