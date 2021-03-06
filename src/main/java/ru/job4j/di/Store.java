package ru.job4j.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Store
 *
 * @author Kseniya Dergunova
 * @since 17.05.2020
 */
@Component
@Scope("prototype")
public class Store {

    /**
     * Field list of strings.
     */
    private List<String> data = new ArrayList<>();

    /**
     * Method Add.
     * Adds value to data.
     *
     * @param value value.
     */
    public void add(String value) {
        data.add(value);
    }

    /**
     * Method GetAll.
     * Gets all values from data.
     *
     * @return List<String> of values.
     */
    public List<String> getAll() {
        return data;
    }
}
