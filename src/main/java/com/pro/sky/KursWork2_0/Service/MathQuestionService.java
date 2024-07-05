package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import com.pro.sky.KursWork2_0.Repository.MathQuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
@Qualifier("math")
public class MathQuestionService implements QuestionService {
    public MathQuestionService(@Qualifier("mathRep") QuestionRepository mathQuestions) {

        this.mathQuestions = mathQuestions;
    }

    private final Random rndIdxM =new Random();
    private final QuestionRepository mathQuestions;
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
        return mathQuestions.getAll().stream().toList().get(rndIdxM.nextInt(mathQuestions.getAll().size()));
    }

}
