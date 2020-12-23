package bouquet;

import bouquet.exception.NotEnoughFlowersException;
import bouquet.exception.NotEnoughPriceException;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Iterator;
import java.util.List;

@Data
@EqualsAndHashCode
public class Bouquet implements Presentable {//имплементация интерфейса
    private static final int MIN_PRICE = 15;
    private static final int MIN_FLOWER_NUMBER = 1;
    private List<Flower> flowers;
    private Wrapper wrapper;
    private double price;

    public Bouquet(List<Flower> flowers, Wrapper wrapper, double price) {
        this.flowers = flowers;
        if (flowers.size() < MIN_FLOWER_NUMBER) {
            throw  new NotEnoughFlowersException("Not enough flowers for bouquet");
        }
        if (price < MIN_PRICE) {
            throw new NotEnoughPriceException("Price is too low");
        }
        this.wrapper = wrapper;
        this.price = price;
    }

    public Bouquet(List<Flower> flowers, Wrapper wrapper) {
        this.flowers = flowers;
        this.wrapper = wrapper;
    }

    public Bouquet() {
    }

    @Override
    public void present() {
        System.out.println("You may present " + this);
    }

    //Внутренний класс
    public static class Wrapper {
        private Colour colour;
        private double length;
        private double width;

        public Wrapper(Colour colour) {
            this.colour = colour;
        }

        @Override
        public String toString() {
            return "Wrapper{" +
                    "colour=" + colour +
                    ", length=" + length +
                    ", width=" + width +
                    '}';
        }
    }

    //Итератор
    public void showFlowers() {
        List<Flower> exhibits = getFlowers();
        Iterator<Flower> iterator = exhibits.iterator();
        while (iterator.hasNext()) {
            Flower flower = iterator.next();
            System.out.println(flower + TypeOfFlower.showTypeOfFlower());
        }
    }
}
