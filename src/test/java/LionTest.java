import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import java.util.List;
import java.util.Objects;

import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        int kittens = lion.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testEatMeat() throws Exception {
        Lion lion = new Lion("Самец", feline);

        List<String> mealList = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(mealList);

        List<String> food = lion.getFood();
        assertEquals(food, mealList);
    }
    @Test
    public void testInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("InvalidSex", feline));
    }

}

