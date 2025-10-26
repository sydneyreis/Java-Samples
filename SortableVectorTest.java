import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.*;

public class SortableVectorTest {

    @Test
    public void testNameComparator(){
        SortableVector<Animal> testVector = new SortableVector<>();
        Animal a = new Animal("Chimp", 100, 50);
        testVector.addElement(a);
        Animal b = new Animal("Bat", 10, 5);
        testVector.addElement(b);
        Animal c = new Animal("Skylar", 50, 5000);
        testVector.addElement(c);
        Animal d = new Animal("Eagle", 70, 100);
        testVector.addElement(d);
        Animal e = new Animal("Turtle", 20, 75);
        testVector.addElement(e);

        NameComparator nameCompare = new NameComparator();
        testVector.insertionSort(nameCompare);
        assertEquals("Bat",testVector.getFirst().getName());
        assertEquals("Eagle",testVector.get(2).getName());

        SortableVector<Animal> testVectorB = new SortableVector<>();
        testVectorB.addElement(a);
        testVectorB.addElement(b);

        NameComparator nameCompareB = new NameComparator();
        testVectorB.selectionSort(nameCompareB);
        assertEquals("Bat",testVectorB.getFirst().getName());
        assertEquals("Chimp",testVectorB.getLast().getName());

    }

    @Test
    public void testHeightComparator(){
        SortableVector<Animal> testVector = new SortableVector<>();
        Animal a = new Animal("Chimp", 100, 50);
        testVector.addElement(a);
        Animal b = new Animal("Bat", 15, 5);
        testVector.addElement(b);
        Animal c = new Animal("Skylar", 50, 5000);
        testVector.addElement(c);
        Animal d = new Animal("Eagle", 70, 100);
        testVector.addElement(d);
        Animal e = new Animal("Turtle", 20, 75);
        testVector.addElement(e);
        Animal f = new Animal("ChimpTwo", 150, 50);
        testVector.addElement(f);
        Animal g = new Animal("BatTwo", 10, 5);
        testVector.addElement(g);

        HeightComparator heightCompare = new HeightComparator();
        testVector.selectionSort(heightCompare);
        assertEquals("ChimpTwo", testVector.getLast().getName());
        assertEquals("BatTwo", testVector.getFirst().getName());

        SortableVector<Animal> testVectorB = new SortableVector<>();
        testVectorB.addElement(c);
        testVectorB.addElement(d);
        testVectorB.addElement(e);

        HeightComparator heightCompareB = new HeightComparator();
        testVectorB.insertionSort(heightCompareB);
        assertEquals("Turtle", testVectorB.getFirst().getName());
        assertEquals("Eagle", testVectorB.get(2).getName());

    }

    @Test
    public void testWeightComparator(){
        SortableVector<Animal> testVector = new SortableVector<>();
        Animal a = new Animal("Chimp", 100, 50);
        testVector.addElement(a);
        Animal b = new Animal("Bat", 15, 5);
        testVector.addElement(b);
        Animal c = new Animal("Skylar", 50, 5000);
        testVector.addElement(c);
        Animal d = new Animal("Eagle", 70, 100);
        testVector.addElement(d);
        Animal e = new Animal("Turtle", 20, 75);
        testVector.addElement(e);
        Animal f = new Animal("ChimpTwo", 150, 50);
        testVector.addElement(f);
        Animal g = new Animal("BatTwo", 10, 5);
        testVector.addElement(g);

        WeightComparator weightCompare = new WeightComparator();
        testVector.insertionSort(weightCompare);
        assertEquals("Skylar", testVector.getLast().getName());
        assertEquals("Turtle", testVector.get(4).getName());

        SortableVector<Animal> testVectorB = new SortableVector<>();
        testVectorB.addElement(a);
        testVectorB.addElement(b);
        testVectorB.addElement(c);
        
        WeightComparator weightCompareB = new WeightComparator();
        testVectorB.insertionSort(weightCompareB);
        assertEquals("Chimp", testVectorB.get(1).getName());
    }

    @Test
    public void testBMIComparator(){
        SortableVector<Animal> testVector = new SortableVector<>();
        Animal a = new Animal("Chimp", 10, 10);
        testVector.addElement(a);
        Animal b = new Animal("Bat", 10, 100);
        testVector.addElement(b);
        Animal c = new Animal("Skylar", 6, 18);
        testVector.addElement(c);

        BMIComparator bmiCompare = new BMIComparator();
        testVector.selectionSort(bmiCompare);
        assertEquals("Chimp", testVector.getFirst().getName());
        assertEquals("Skylar", testVector.get(1).getName());
    }
}