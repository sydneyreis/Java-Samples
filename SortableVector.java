import java.util.Vector;
import java.util.Comparator;

/**
 * this class is designed to create methods to sort vectors
 * 
 * @author Sydney Reis!
 */

public class SortableVector<E> extends Vector<E>{

    /**
     * this method sorts a vector from least to greatest using the selection sort algorithm and a Comparator object
     * 
     * @param c the Comparator object
     */
    public void selectionSort(Comparator<E> c){
        for (int current = this.size() -1; current > 0; current -- ){
            //find the max value between 0 and current
            int maxIdx = 0;
            for (int i =1; i<= current; i++){
                if(c.compare(this.get(i), this.get(maxIdx)) > 0){
                    maxIdx = i;
                }
            }

            //swap max element with element at current
            swap(maxIdx, current);
        }

    }

    /**
     * this method switches the value held at one index with the value held at another
     * 
     * @param maxIdx an int representing one index that is to be switched
     * @param current an int representing the other index that is to be switched
     */
    public void swap(int maxIdx, int current){
        E temp = this.get(maxIdx);
        this.set(maxIdx, this.get(current));
        this.set(current, temp);
    }

    /**
     * this method sorts a vector from least to greatest using the insertion sort algorithm and a Comparator object
     * 
     * @param c the comparator object
     */
    public void insertionSort(Comparator<E> c){
        for(int i =1; i < this.size(); i++){
            E temp = this.get(i);
            int newIdx = i;

            //find new index for element at i
            while(newIdx >0 && c.compare(this.get(newIdx-1), temp) > 0){
                this.set(newIdx, this.get(newIdx -1));
                newIdx --;
            }

            this.set(newIdx, temp);
        }
    }

}