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
        context.register(Store.class);
        context.register(ConsoleInput.class);
        context.register(StartUI.class);
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.ask("Привет, как дела?");
        ui.ask("Сколько тебе лет?");
        ui.add("Как быстро летит время!");
        ui.print();
    }
}
