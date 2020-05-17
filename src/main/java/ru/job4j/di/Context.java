package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Context
 *
 * @author Kseniya Dergunova
 * @since 17.05.2020
 */
public class Context {

    /**
     * Карта с объектами. В ней мы будем хранить проинициализированные объекты.
     */
    private Map<String, Object> els = new HashMap<>();

    /**
     * Метод регистрации классов.
     * Сначала нужно получить все конструкторы класса. Если их больше 1, то мы не знаем как загружать этот класс и кидаем исключение.
     * Когда мы нашли конструктор, мы собираем аргументы этого конструктора и ищем уже зарегистрированные объекты, чтобы внедрить их в конструтор.
     * Последний этап - это создание объекта и добавление его в карту.
     * @param cl класс.
     */
    public void reg(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors: " + cl.getCanonicalName());
        }
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<>();
        for (Class arg : con.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context: " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Can't create an instance of: " + cl.getCanonicalName(), e);
        }
    }

    /**
     * Метод get возвращает проинициализированный объект.
     * @param instant класс.
     * @param <T> тип объекта класса.
     * @return проинициализированный объект класса.
     */
    public <T> T get(Class<T> instant) {
        return (T) els.get(instant.getCanonicalName());
    }
}
