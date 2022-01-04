package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.checkers.Board;
import com.kodilla.patterns.builder.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class BigMac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients;

    public static class BigMacBuilder  {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigMac.BigMacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigMac.BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMac.BigMacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigMac.BigMacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public BigMac build() {
            return new BigMac(bun, burgers, sauce, ingredients);
        }
    }

    private BigMac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac: " + "\n" +
                "bun = '" + bun + '\'' + "," + "\n" +
                "burgers = '" + burgers + '\'' + "," + "\n" +
                "sauce = '" + sauce + '\'' + "," + "\n" +
                "ingredients = " + ingredients + '\'';
    }
}
