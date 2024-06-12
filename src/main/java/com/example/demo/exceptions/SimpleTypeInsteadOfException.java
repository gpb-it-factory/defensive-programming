package com.example.demo.exceptions;

/**
 * Используем простой тип вместо исключения
 *
 * Преимущества - расширяемый тип, прозрачный контракт
 */
public class SimpleTypeInsteadOfException {
    public static void main(String[] args) {
        SimpleTypeInsteadOfException instance = new SimpleTypeInsteadOfException();
        WorkResult easyWorkResult = instance.doWork(new EasyWork());
        WorkResult hardWorkResult = instance.doWork(new HardWork());
    }

    public WorkResult doWork(Work work) {
        if (work instanceof HardWork) {
            return new WorkResult(false, "Работа слишком тяжёлая, в этот раз не получилось её выполнить");
        }

        return new WorkResult(true, "Работа успешно выполнена");
    }

    public record WorkResult(boolean success, String message) {}

    /**
     * Представляет из себя некоторую работу, которую нужно выполнить
     */
    public interface Work {
    }

    private static class EasyWork implements Work {
    }

    private static class HardWork implements Work {
    }
}
