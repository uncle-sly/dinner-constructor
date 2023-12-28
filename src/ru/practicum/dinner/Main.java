package ru.practicum.dinner;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        random = new Random();

        while (true) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Неизвестная команда, повторите ввод!\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nВыберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход \n");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        if (dishType.isEmpty()) {
            System.out.println("тип блюда не может быть пустым, повторите ввод\n");
            return;
        }

        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        if (dishName.isEmpty()) {
            System.out.println("название блюда не может быть пустым, повторите ввод\n");
            return;
        }
        // добавьте новое блюдо
        dc.saveNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        if (dc.getDishMenu().isEmpty()) {
            System.out.println("Меню блюд - пусто. Сначала добавьте блюда в меню.");
            return;
        }
        System.out.println("Начинаем конструировать обед...\n");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        if (numberOfCombos <= 0) {
            System.out.println("Вы ввели: " + numberOfCombos + ". Для начала генерации, " +
                               "количество наборов не может быть равно 0 или меньше 0.");
            return;
        }
        if (dc.getSetOfMealTypes().isEmpty()) {
            System.out.println("Вводите типы блюда из меню, разделяя символом переноса строки (enter). " +
                               "Для завершения ввода введите пустую строку");
        } else {
            System.out.println("Ранее введенные типы блюд: " + dc.getSetOfMealTypes() +
                               "\nДля очистки введите clear и нажмите Enter.");
            System.out.println("Для генерации комбинаций блюд на основе ранее введенных типов, нажмите Enter. \n" +
                               "Для добавления нового типа введите Имя типа и нажмите Enter. " +
                               "\n\nДля завершения ввода нажмите Enter. ");
        }
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (nextItem.equals("clear")) {
                dc.clearSetOfMealTypes();
            } else {
                if (!dc.checkType(nextItem)) {
                    System.out.println("Вы ввели несуществующий тип блюда! Повторите ввод: ");
                } else {
                    dc.saveSetOfMealTypes(nextItem);
                }
            }
            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран
        if (!dc.getSetOfMealTypes().isEmpty()) {
            dc.printSetOfCombos(dc.createDishCombos(numberOfCombos, random));
        }

    }
}
