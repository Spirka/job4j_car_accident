package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Class StartUI
 *
 * @author Kseniya Dergunova
 * @since 17.05.2020
 */
@Component
@Scope("prototype")
public class StartUI {

    /**
     * Field store.
     */
    @Autowired
    private Store store;

    /**
     * Field console input.
     */
    @Autowired
    private ConsoleInput consoleInput;

    /**
     * Method Add.
     * Adds value to store.
     *
     * @param value value.
     */
    public void add(String value) {
        store.add(value);
    }

    /**
     * Method Print.
     * Prints all exist values.
     */
    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    /**
     * Method Ask.
     *
     * @param question to ask the user.
     * @return scanner.
     */
    public String ask(String question) {
        return consoleInput.ask(question);
    }
}
