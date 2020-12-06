package bouquet;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Florist florist = new Florist("Ihor",
                "Luka", 5, 31);
        Bouquet bouquet = florist.createBouquet(chooseFlowers(), new Bouquet.Wrapper(Colour.PINK));
        System.out.println(florist.createBouquet(chooseFlowers(), new Bouquet.Wrapper(Colour.PINK)));

        Employee secondFlorist = new Florist("John", "Vasili", 3, 19);
        //polymorphism
        System.out.println(secondFlorist.work());
        bouquet.showFlowers();
        bouquet.present();
        System.out.println(TypeOfFlower.showTypeOfFlower());
        System.out.println(Arrays.toString(TypeOfFlower.values()));
    }

    public static List<Flower> chooseFlowers() {
        Flower firstFlower = new Flower(Colour.PINK, TypeOfFlower.ROSE );
        Flower secondFlower = new Flower(Colour.RED, TypeOfFlower.VIOLETS );
        Flower thirdFlower = new Flower(Colour.WHITE, TypeOfFlower.ROSE );
        return List.of(firstFlower, secondFlower, thirdFlower);
    }
}
