package com.pro.sky.KursWork2_0.Service;

import com.pro.sky.KursWork2_0.Question;

import java.util.List;

public class Constants {
    private Constants() {
    }

    public static Question DEFAULT_QUESTION = new Question("Вопрос", "Ответ");

    public static List<Question> JAVA_QUESTIONS = List.of(
            new Question("Джава1", "Отв1"),
            new Question("Джава2", "Отв2"),
            new Question("Джава3", "Отв3"),
            new Question("Джава4", "Отв4"),
            new Question("Джава5", "Отв5"));

    public static List<Question> MATH_QUESTIONS = List.of(
            new Question("Матем1", "Отв1"),
            new Question("Матем2", "Отв2"),
            new Question("Матем3", "Отв3"),
            new Question("Матем4", "Отв4"),
            new Question("Матем5", "Отв5"));
}
