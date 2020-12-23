package com.adventofcode.day21;

import java.util.*;

public class AllergenAssessment {

    static int countIngredientsWithoutAllergens(List<IngredientList> ingredientLists) {
        Map<String, List<Integer>> allergenMap = new HashMap<>();

        for (int i = 0; i < ingredientLists.size(); i++) {
            for (String allergen : ingredientLists.get(i).allergens) {
                List<Integer> indexes;
                if (allergenMap.containsKey(allergen)) {
                    indexes = allergenMap.get(allergen);
                } else {
                    indexes = new ArrayList<>();
                }
                indexes.add(i);
                allergenMap.put(allergen, indexes);
            }
        }

        Set<String> ingredientsWithoutAllergens = new HashSet<>();
        Set<String> ingredientsWithAllergens = new HashSet<>();

        for (IngredientList ingredientList : ingredientLists) {

            ingredientsWithoutAllergens.addAll(ingredientList.ingredients);
            for (String ingredientWithAllergen : ingredientsWithAllergens) {
                ingredientsWithoutAllergens.remove(ingredientWithAllergen);
            }

            for (String allergen : ingredientList.allergens) {
                if (allergenMap.containsKey(allergen)) {
                    Set<String> allergenicIngredient = findAllergenicIngredient(allergenMap.get(allergen), ingredientLists);
                    ingredientsWithAllergens.addAll(allergenicIngredient);
                    ingredientsWithoutAllergens.removeAll(allergenicIngredient);
                    allergenMap.remove(allergen);
                }
            }
        }

        return ingredientsWithoutAllergens.size();
    }

    private static Set<String> findAllergenicIngredient(List<Integer> indexes, List<IngredientList> ingredientLists) {
        Set<String> ingredients = new HashSet<>();

        for (Integer index : indexes) {
            if (ingredients.isEmpty()) {
                ingredients.addAll(ingredientLists.get(index).ingredients);
            } else {
                Set<String> ingredientsCopy = new HashSet<>(ingredients);
                for (String ingredient : ingredients) {
                    if (!ingredientLists.get(index).ingredients.contains(ingredient)) {
                        ingredientsCopy.remove(ingredient);
                    }
                }
                ingredients = ingredientsCopy;
            }
        }

        return ingredients;
    }

}