public class Dog extends Animal{

    public Dog(int weight_in_pounds) {
        super(weight_in_pounds);
        weight = weight_in_pounds;
    }

    public class Poodle extends Dog{
        public Poodle(int x) {
            super(x);
        }
    }

    public static void main(String[] args) {
        Monkey jimmy = new Monkey(22);
        Monkey orangutan = new Monkey(33);
        Animal mangotan = (Animal) orangutan;
    }


}