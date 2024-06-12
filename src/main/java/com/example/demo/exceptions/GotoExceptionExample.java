package com.example.demo.exceptions;

/**
 * Не нужно использовать Exception как замену control flow.
 * Приведённый код намеренно дурацкий для более сильного эффекта, что делать так не нужно.
 *
 * Для управления потоком исполнения мы можем использовать условные конструкции, типы и другие инструменты языка.
 */
public class GotoExceptionExample {

    public static void main(String[] args) {
        GotoExceptionExample instance = new GotoExceptionExample();
        instance.doSomethingUgly("Никогда так не делайте, пожалуйста");
    }

    public void doSomethingUgly(String input) {
        try {
            step1(input);
        } catch (GotoException e) {
            try {
                step2(input);
            } catch (GotoException ex) {
                try {
                    step3(input);
                } catch (GotoException exc) {
                    System.err.println("Всё успешно сломалось: " + exc.getMessage());
                }
            }
        }
    }

    private void step1(String input) {
        if (input.contains("Никогда")) {
            throw new GotoException("Шаг 1 неуспешен, переходим к шагу 2");
        }
        System.out.println("Шаг 1 успешен");
    }

    private void step2(String input) {
        if (!input.isEmpty()) {
            throw new GotoException("Шаг 2 неуспешен, переходим к шагу 3");
        }
        System.out.println("Шаг 2 успешен");
    }

    private void step3(String input) {
        if (!input.isEmpty()) {
            throw new GotoException("Шаг 3 неуспешен, мы всё");
        }
        System.out.println("Шаг 3 успешен");
    }

    private static class GotoException extends RuntimeException {
        public GotoException(String message) {
            super(message);
        }
    }
}