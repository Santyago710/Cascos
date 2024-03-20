package SalesPoints;

// Importing necessary packages
import java.util.Objects;

// Implementing the Pizza class
public class Pizza implements Cloneable {
    // Fields of the Pizza class
    private int size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean bacon;

    // Constructor for the Pizza class
    private Pizza(int size, boolean cheese, boolean pepperoni, boolean bacon) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.bacon = bacon;
    }

    // Creating a public static inner class for the PizzaBuilder
    public static class PizzaBuilder {
        // Fields of the PizzaBuilder class
        private int size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean bacon;

        // Constructor for the PizzaBuilder class
        public PizzaBuilder(int size) {
            this.size = size;
        }

        // Method to add cheese to the pizza
        public PizzaBuilder cheese(boolean value) {
            this.cheese = value;
            return this;
        }

        // Method to add pepperoni to the pizza
        public PizzaBuilder pepperoni(boolean value) {
            this.pepperoni = value;
            return this;
        }

        // Method to add bacon to the pizza
        public PizzaBuilder bacon(boolean value) {
            this.bacon = value;
            return this;
        }

        // Method to build the pizza object
        public Pizza build() {
            return new Pizza(size, cheese, pepperoni, bacon);
        }
    }

    // Overriding the clone method
    @Override
    protected Object clone() {
        try {
            return (Pizza) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    // Overriding the equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return size == pizza.size && cheese == pizza.cheese && pepperoni == pizza.pepperoni && bacon == pizza.bacon;
    }

    // Overriding the hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(size, cheese, pepperoni, bacon);
    }

    // Main method to test the Pizza class
    public static void main(String[] args) {
        // Creating a Pizza object using the PizzaBuilder
        Pizza originalPizza = new Pizza.PizzaBuilder(12)
                .cheese(true)
                .pepperoni(true)
                .bacon(true)
                .build();

        // Cloning the originalPizza to create a new Pizza object
        Pizza clonedPizza = (Pizza) originalPizza.clone();

        // Printing the details of the original and cloned pizzas
        System.out.println("Original Pizza: Size - " + originalPizza.size + ", Cheese - " + originalPizza.cheese +
                ", Pepperoni - " + originalPizza.pepperoni + ", Bacon - " + originalPizza.bacon);
        System.out.println("Cloned Pizza: Size - " + clonedPizza.size + ", Cheese - " + clonedPizza.cheese +
                ", Pepperoni - " + clonedPizza.pepperoni + ", Bacon - " + clonedPizza.bacon);

        // Checking if the original and cloned pizzas are equal
        System.out.println("Are original and cloned pizzas equal? " + originalPizza.equals(clonedPizza));
    }
}
