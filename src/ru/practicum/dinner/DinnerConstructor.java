package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private  HashMap<String, ArrayList<String>> dishMenu;
    private ArrayList<String> setOfMealTypes;

    public DinnerConstructor() {
        dishMenu = new HashMap<>();
        setOfMealTypes = new ArrayList<>();
    }

    public ArrayList<String> getSetOfMealTypes() {
        return setOfMealTypes;
    }

    public HashMap<String, ArrayList<String>> getDishMenu() {
        return dishMenu;
    }

    boolean checkType(String type) {
        for (String name : dishMenu.keySet()) {
            if (name.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public void saveNewDish(String dishType, String dishName) {
        ArrayList<String> dishNames = new ArrayList<>();

        if (!dishMenu.isEmpty()) {
            if (checkType(dishType)) {
                dishNames = dishMenu.get(dishType);
            }
        }
        dishNames.add(dishName);
        dishMenu.put(dishType, dishNames);
    }

    public void saveSetOfMealTypes(String nextItem) {
        setOfMealTypes.add(nextItem);
    }

    public void clearSetOfMealTypes() {
        setOfMealTypes.clear();
    }

    public ArrayList<ArrayList<String>> createDishCombos(int numberOfCombos, Random random) {
    /* public HashMap<String, ArrayList<String>> createDishCombos(int numberOfCombos, ArrayList<String> setOfMealTypes, Random random) {
        HashMap<String, ArrayList<String>> dishCombos = new HashMap<>();
        ArrayList<String> comboMeals;
            for (int i = 0; i < numberOfCombos; i++) {
                comboMeals = new ArrayList<>();
                for (String type : getSetOfMealTypes()) {
                    int index = random.nextInt(dishMenu.get(type).size());
                    comboMeals.add(dishMenu.get(type).get(index));
                    dishCombos.put("Комбо " + (i + 1), comboMeals);
                }
            }  */
        ArrayList<ArrayList<String>> dishCombos = new ArrayList<>();
        ArrayList<String> comboMeals;
        for (int i = 0; i < numberOfCombos; i++) {
            comboMeals = new ArrayList<>();
            for (String type : getSetOfMealTypes()) {
                int index = random.nextInt(dishMenu.get(type).size());
                comboMeals.add(dishMenu.get(type).get(index));
            }
            dishCombos.add(comboMeals);
        }
        return dishCombos;
    }

    public void printSetOfCombos(ArrayList<ArrayList<String>> dishCombos) {
/* public void printSetOfCombos(HashMap<String,ArrayList<String>> dishCombos)
   for (String comboName : dishCombos.keySet() ) {
            System.out.println(comboName);
            System.out.println(dishCombos.get(comboName));
        }*/
        for (int i = 0; i < dishCombos.size(); i++) {
            System.out.println("\nКомбо " + (i + 1));
            System.out.println(dishCombos.get(i));
        }
    }

}
