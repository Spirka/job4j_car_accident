package ru.job4j.di;

import org.springframework.stereotype.Component;

/**
 * Class StartUI
 *
 * @author Kseniya Dergunova
 * @since 17.05.2020
 */
@Component
public class StartUI {

    /**
     * Field store.
     */
    private Store store;

    /**
     * Field console input.
     */
    private ConsoleInput consoleInput;

    /**
     * Constructor.
     *
     * @param store        store.
     * @param consoleInput input.
     */
    public StartUI(Store store, ConsoleInput consoleInput) {
        this.store = store;
        this.consoleInput = consoleInput;
    }

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
