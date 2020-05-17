package ru.job4j.di;

import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Class ConsoleInput
 *
 * @author Kseniya Dergunova
 * @since 17.05.2020
 */
@Component
public class ConsoleInput {

    /**
     * Field scanner
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method prints the question and scans the user's answer.
     *
     * @param question question.
     * @return scanner.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
