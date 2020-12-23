package bouquet;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FloristTest {
    Florist florist = new Florist("Ihor",
            "Luka", 5, 31);

    @Test
    public void CreateBouquet_EnoughFlowers_Ok() {
        List<Flower> listOfFlowers = List.of(new Flower(Colour.PINK, TypeOfFlower.ROSE),
                new Flower(Colour.RED, TypeOfFlower.VIOLETS ),
                new Flower(Colour.RED, TypeOfFlower.VIOLETS ));
        Bouquet.Wrapper wrapper = new Bouquet.Wrapper(Colour.PINK);
        Bouquet expectedBouquet = new Bouquet(listOfFlowers, wrapper, 133);
        Bouquet actual = florist.createBouquet(listOfFlowers, wrapper);
        Assert.assertEquals(expectedBouquet, actual);
    }

    @Test
    public void FloristWorks_ReturnsMessage_Ok() {
        String expected = "I'm working. My profession is a florist";
        String actual = florist.work();
        Assert.assertEquals(expected, actual);
    }
}