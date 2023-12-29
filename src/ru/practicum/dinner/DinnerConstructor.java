package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private  HashMap<String, ArrayList<String>> dishMenu;

    public DinnerConstructor() {
        dishMenu = new HashMap<>();
    }

    public HashMap<String, ArrayList<String>> getDishMenu() {
        return dishMenu;
    }

    boolean checkType(String type) {
        return dishMenu.containsKey(type);
    }

    public void saveNewDish(String dishType, String dishName) {

        ArrayList<String> dishNames = dishMenu.get(dishType);

        if (dishNames == null) {
            dishNames = new ArrayList<>();
            dishMenu.put(dishType, dishNames);
            System.out.println(dishMenu);
        }
        dishNames.add(dishName);
        System.out.println(dishNames);
        System.out.println(dishMenu);
//        ArrayList<String> dishNames = dishMenu.computeIfAbsent(dishType, k -> new ArrayList<>());
//        dishNames.add(dishName);
    }

    public ArrayList<ArrayList<String>> createDishCombos(int numberOfCombos, ArrayList<String> dishTypes, Random random) {

        ArrayList<ArrayList<String>> dishCombos = new ArrayList<>();
        ArrayList<String> comboMeals;
        for (int i = 0; i < numberOfCombos; i++) {
            comboMeals = new ArrayList<>();
            for (String type : dishTypes) {
                int index = random.nextInt(dishMenu.get(type).size());
                comboMeals.add(dishMenu.get(type).get(index));
            }
            dishCombos.add(comboMeals);
        }
        return dishCombos;
    }

    public void printSetOfCombos(ArrayList<ArrayList<String>> dishCombos) {

        for (int i = 0; i < dishCombos.size(); i++) {
            System.out.println("\nКомбо " + (i + 1));
            System.out.println(dishCombos.get(i));
        }
    }

}
