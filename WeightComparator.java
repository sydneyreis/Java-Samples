import java.util.Comparator;

/**
 * this class is designed to compare two Animal objects based off their weights
 * 
 * @author Sydney Reis
 */

public class WeightComparator implements Comparator <Animal>{

    public int compare(Animal a, Animal b){
        return a.getWeight() - b.getWeight();
    }
}