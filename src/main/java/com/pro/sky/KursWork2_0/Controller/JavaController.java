package com.pro.sky.KursWork2_0.Controller;

import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Question;
import com.pro.sky.KursWork2_0.Service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaController {
    private final JavaQuestionService javaQuestionRepository;

    public JavaController(JavaQuestionService javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }
    @GetMapping
    public Collection<Question> getAll(){
        return javaQuestionRepository.getAll();
    }

    @GetMapping(path = "/add")
    public Question getQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer){
        return javaQuestionRepository.add(new Question(question,answer));
    }
    @GetMapping(path = "/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer){
        return javaQuestionRepository.remove(new Question(question,answer));
    }

}
