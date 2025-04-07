package ru.netology.javaqa.javaqamvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldCheckForMatchesInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean expected = true;
        boolean actual = simpleTask.matches("родителям");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldCheckForNoMatchesInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean expected = false;
        boolean actual = simpleTask.matches("Купить хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckForMatchesInEpicSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckForNoMatchesInEpicSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        boolean expected = false;
        boolean actual = epic.matches("Батарейки");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckForMatchesInMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckForNoMatchesInMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = false;
        boolean actual = meeting.matches("во вторник");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckForMatchesInMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("3й версии приложения");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckForNoMatchesInMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = false;
        boolean actual = meeting.matches("2й версии приложения");
        Assertions.assertEquals(expected, actual);
    }
}
