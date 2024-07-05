package com.pro.sky.KursWork2_0.Repository;

import com.pro.sky.KursWork2_0.Exception.ExceptionApp;
import com.pro.sky.KursWork2_0.Interface.QuestionRepository;
import com.pro.sky.KursWork2_0.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
@Qualifier("javaRep")
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

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


    @PostConstruct
    public void init() {
        System.out.println("Сработал инит");
        questions.add(new Question("1Java","Otvet1"));
        questions.add(new Question("2Java","Otvet2"));
        questions.add(new Question("3Java","Otvet3"));
        questions.add(new Question("4Java","Otvet4"));
        questions.add(new Question("5Java","Otvet5"));
    }

    @Override
    public String toString() {
        return "JavaQuestionRepository{" +
                "questions=" + questions +
                '}';
    }
}
