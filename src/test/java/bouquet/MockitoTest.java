package bouquet;

import bouquet.exception.NotEnoughFlowersException;
import bouquet.exception.NotEnoughPriceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    @Mock
    private Flower myFlower;
    @Mock
    private Bouquet.Wrapper myWrapper;
    private Florist florist = new Florist("David", "Hlushko", 5, 45);

    @Test
    public void CreateBouquet_ReturnsBouquet_Ok() {
        List<Flower> flowers = List.of(myFlower, myFlower, myFlower);
        when(myFlower.getTypeOfFlower()).thenReturn(TypeOfFlower.ROSE);
        Bouquet bouquet = florist.createBouquet(flowers, myWrapper);
        Assert.assertEquals(flowers, bouquet.getFlowers());
    }

    @Test(expected = NotEnoughFlowersException.class)
    public void CreateBouquet_ReturnsBouquet_ThrowsNotEnoughFlowersException() {
        List<Flower> flowers = List.of(myFlower);
        when(myFlower.getTypeOfFlower()).thenReturn(TypeOfFlower.ROSE);
        Bouquet bouquet = florist.createBouquet(flowers, myWrapper);
        Assert.assertEquals(flowers, bouquet.getFlowers());
    }

    @Test(expected = NotEnoughPriceException.class)
    public void ConstructorTest_CreatesBouquet_ThrowsLowPriceException() {
        List<Flower> flowers = List.of(myFlower);
        new Bouquet(flowers, myWrapper, 10);
    }

    @Test(expected = NotEnoughFlowersException.class)
    public void ConstructorTest_CreatesBouquet_ThrowsFewFlowersException() {
        List<Flower> flowers = new ArrayList<>();
        new Bouquet(flowers, myWrapper, 15);
    }

    @Test
    public void ConstructorTest_CreatesBouquet_Ok() {
        List<Flower> flowers = List.of(myFlower);
        new Bouquet(flowers, myWrapper, 15);
    }
}