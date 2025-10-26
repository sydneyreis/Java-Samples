import java.util.Comparator;

/**
 * this class is designed to compare to Animal objects based off the alphabetical order of their names
 * 
 * @author Sydney Reis
 */

public class NameComparator implements Comparator<Animal>{

    public int compare(Animal a, Animal b){
        return a.getName().compareTo(b.getName());
    }

}