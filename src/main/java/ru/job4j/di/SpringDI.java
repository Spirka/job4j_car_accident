package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Class SpringDI
 *
 * @author Kseniya Dergunova
 * @since 17.05.2020
 */
public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");
        context.refresh();
        Store store = context.getBean(Store.class);
        store.add("Kseniya Dergunova");
        Store another = context.getBean(Store.class);
        another.getAll().forEach(System.out::println);
        StartUI ui = context.getBean(StartUI.class);
        ui.ask("Привет, как дела?");
        ui.ask("Сколько тебе лет?");
        ui.add("Как быстро летит время!");
        StartUI anotherUI = context.getBean(StartUI.class);
        anotherUI.print();
    }
}
