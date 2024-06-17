package com.pro.sky.KursWork2_0.Repository;

import com.pro.sky.KursWork2_0.Exception.ExceptionApp;
import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }




    @Override
    public Question add(Question question) {
        if(question==null){
            throw new ExceptionApp("Передан пустой объект вопроса");
        }
        Question newQuestion = question;
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        Question delQuestion = question;
        if(!questions.contains(question)||question==null){
            throw new ExceptionApp("Такого вопроса в репозитории нет");

        }
        questions.remove(question);
        if(question==null){
            throw new ExceptionApp("Передан пустой объект вопроса");
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public String toString() {
        return "JavaQuestionRepository{" +
                "questions=" + questions +
                '}';
    }
}
