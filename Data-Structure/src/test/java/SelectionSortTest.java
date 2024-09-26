import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {
    @Test
    public void testSelectionSort_success() {
        int [] array = {3,7,4,2,1};
        Main.selectionSort(array);
        Assertions.assertArrayEquals(new int[]{1,2,3,4,7}, array);
    }

    @Test
    public void testSelectionSort_duplicate_success() {
        int [] array = {3,1,1,2,1};
        Main.selectionSort(array);
        Assertions.assertArrayEquals(new int[]{1,1,1,2,3}, array);
    }

    @Test
    public void testSelectionSort_single_success() {
        int [] array = {3};
        Main.selectionSort(array);
        Assertions.assertArrayEquals(new int[]{3}, array);
    }

    @Test
    public void testSelectionSort_negative_success() {
        int [] array = {3,-7,4,-2,1};
        Main.selectionSort(array);
        Assertions.assertArrayEquals(new int[]{-7,-2,1,3,4}, array);
    }
}
