package com.adventofcode.day21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        List<IngredientList> allIngredientLists = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<ingredients>.*)\\(contains (?<allergens>.*)\\)");
        try (Scanner scanner = new Scanner(new File("src/resource", "day21.txt"))) {
            while (scanner.hasNextLine()) {
                List<String> ingredients = new ArrayList<>();
                List<String> allergens = new ArrayList<>();
                IngredientList ingredientList = new IngredientList(ingredients, allergens);
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String ingredientsAsString = matcher.group("ingredients");
                    String allergensAsString = matcher.group("allergens");
                    ingredients.addAll(Arrays.asList(ingredientsAsString.split(" ")));
                    allergens.addAll(Arrays.asList(allergensAsString.split(", ")));
                    allIngredientLists.add(ingredientList);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(AllergenAssessment.countIngredientsWithoutAllergens(allIngredientLists));
    }

}
