import java.util.Comparator;

/**
 * this class is designed to compare two Animal objects based off of their BMI's
 * 
 * @author Sydney Reis
 */

public class BMIComparator implements Comparator <Animal>{

    public int compare(Animal a, Animal b){
        double bmiA = a.getWeight()/Math.pow(a.getHeight() / 100.0, 2.0);
        double bmiB = b.getWeight()/Math.pow(b.getHeight() / 100.0, 2.0);

        //takes the difference between the BMI's and multiplies by a hundred before casting to int to not let loss of decimals cause an inaccurate comparision
        return (int)((bmiA *100) - (bmiB * 100));
    }
}