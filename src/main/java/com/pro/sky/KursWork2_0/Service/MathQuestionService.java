package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import com.pro.sky.KursWork2_0.Repository.MathQuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    Random rndIdx=new Random();
    MathQuestionRepository mathQuestions =new MathQuestionRepository();
    @Override
    public Question add(String question, String answer) {
        return mathQuestions.add(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
        return mathQuestions.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return mathQuestions.getAll().stream().toList().get(rndIdx.nextInt(mathQuestions.getAll().size()));
    }
    @PostConstruct
    public void init() {
        mathQuestions.add(new Question("1Math","Otvet1"));
        mathQuestions.add(new Question("2Math","Otvet2"));
        mathQuestions.add(new Question("3Math","Otvet3"));
        mathQuestions.add(new Question("4Math","Otvet4"));
        mathQuestions.add(new Question("5Math","Otvet5"));
    }
}
