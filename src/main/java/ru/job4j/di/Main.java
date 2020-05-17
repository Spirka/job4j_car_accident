package ru.job4j.di;

/**
 * Class Main
 *
 * @author Kseniya Dergunova
 * @since 17.05.2020
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.ask("Привет, как дела?");
        ui.ask("Сколько тебе лет?");
        ui.add("Как быстро летит время!");
        ui.print();
    }
}
