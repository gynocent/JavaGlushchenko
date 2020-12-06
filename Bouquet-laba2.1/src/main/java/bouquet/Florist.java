package bouquet;

import bouquet.exception.NotEnoughFlowersException;

import java.util.List;

//наследование
public class Florist extends Employee {
    private static final int MIN_NUMBER = 3;
    public Florist(String name, String surname, int experience, int age) {
        super(name, surname, experience, age);
    }

    public Bouquet createBouquet(List<Flower> flowers, Bouquet.Wrapper wrapper) {
        if (flowers.size() < MIN_NUMBER) {
            throw new NotEnoughFlowersException("Not enough flowers for the bouquet!!!");
        }
        Bouquet bouquet = new Bouquet(flowers, wrapper);
        setPrice(bouquet);
        return bouquet;
    }

    private static double setPrice(Bouquet bouquet) {
        List<Flower> flowers = bouquet.getFlowers();
        double price = 0;
        for (Flower flower : flowers) {
            price += flower.getTypeOfFlower().getPrice();
        }
        bouquet.setPrice(price);
        return price;
    }

    //Полиморфизм
    @Override
    public String work() {
        return super.work() + ". My profession is a florist";
    }
}
