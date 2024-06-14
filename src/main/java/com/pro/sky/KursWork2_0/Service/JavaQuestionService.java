package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import com.pro.sky.KursWork2_0.Repository.JavaQuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    Random rndIdx=new Random();
    JavaQuestionRepository javaQuestions=new JavaQuestionRepository();
    @Override
    public Question add(String question, String answer) {
        return javaQuestions.add(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
        return javaQuestions.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return javaQuestions.getAll().stream().toList().get(rndIdx.nextInt(javaQuestions.getAll().size()));
    }
    @PostConstruct
    public void init() {
        javaQuestions.add(new Question("1Java","Otvet1"));
        javaQuestions.add(new Question("2Java","Otvet2"));
        javaQuestions.add(new Question("3Java","Otvet3"));
        javaQuestions.add(new Question("4Java","Otvet4"));
        javaQuestions.add(new Question("5Java","Otvet5"));
    }
}
