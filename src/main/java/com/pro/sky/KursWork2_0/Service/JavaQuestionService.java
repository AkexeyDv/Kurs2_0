package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Interface.QuestionService;
import com.pro.sky.KursWork2_0.Question;
import com.pro.sky.KursWork2_0.Repository.JavaQuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
@Qualifier("java")
public class JavaQuestionService implements QuestionService {
    private final Random rndIdxJ =new Random();
    private final QuestionRepository javaQuestions;

    public JavaQuestionService(@Qualifier("javaRep") QuestionRepository javaQuestions) {
        this.javaQuestions = javaQuestions;
    }

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
        return javaQuestions.getAll().stream().toList().get(this.rndIdxJ.nextInt(javaQuestions.getAll().size()));
    }

}
