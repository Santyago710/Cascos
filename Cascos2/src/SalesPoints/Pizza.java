public class Pizza {
    private int size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean bacon;
  
    public static class Builder {
        //required
        private final int size;
  
        //optional
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean bacon = false;
  
        public Builder(int size) {
            this.size = size;
        }
  
        public Builder cheese(boolean value) {
            cheese = value;
            return this;
        }
  
        public Builder pepperoni(boolean value) {
            pepperoni = value;
            return this;
        }
  
        public Builder bacon(boolean value) {
            bacon = value;
            return this;
        }
  
        public Pizza build() {
            return new Pizza(this);
        }
    }
  
    private Pizza(Builder builder) {
        size = builder.size;
        cheese = builder.cheese;
        pepperoni = builder.pepperoni;
        bacon = builder.bacon;
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder(12)
                               .cheese(true)
                               .pepperoni(true)
                               .bacon(true)
                               .build();

        // Print the created Pizza object
        System.out.println("Pizza: Size - " + pizza.size + ", Cheese - " + pizza.cheese +
        ", Pepperoni - " + pizza.pepperoni + ", Bacon - " + pizza.bacon);
}
}
