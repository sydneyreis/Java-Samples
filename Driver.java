import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * this method is designed to read a file find the mode from a sorted vector
 * 
 * a. the name of the 25th animal is Capybara
 * b. the three heaviest animals in decending order are Sperm Whale, Humpback Wale, and African Elephant
 * c. the animals with the highest BMI in decreasing order are Giant Pacific Octopus, Atlantic Puffin, and Emperor Tamarin
 * d. the height that occurs the most frequently is 160 cm and the animals with this height are the Hippopotaumus, Polar Bear, Australian Fur Seal, Chimpanzee, Orangutan, Yak, and Grevy's Zebra
 * 
 * @author Sydney Reis
 */

public class Driver {


    /**
     * this method is designed to read content from a file and add it to a vector
     * 
     * @param fileName the file that the content is being taken from
     * @param data the vector the content is being added to
     */
    public void readFromFile(String fileName, SortableVector<Animal> data){
        try (Scanner scanner = new Scanner(new File(fileName))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();

                //array is created from a split string and indexed into to create animal object that is then added to vector
                String [] splitList = line.split(",");
                Animal animal = new Animal(splitList[0], Integer.valueOf(splitList[1]), Integer.valueOf(splitList[2]));
                data.addElement(animal);
            }
        }catch(IOException e){
             e.printStackTrace();
            }
    }

    /**
     * this method is designed to find the mode height from a sorted vector
     * 
     * @param data the sorted vector
     * 
     * @return an int that is the last index of the mode 
     */
    public int findMode(SortableVector<Animal> data){    
        int modeIDX = 0;
        int maxHeightsInARow = 1;
        int currentHeightsInARow = 1;

        for(int idx = 1; idx < data.size(); idx++){
            int currentHeight = data.get(idx).getHeight();
            int prevHeight = data.get(idx - 1).getHeight();

            if (currentHeight == prevHeight){
                currentHeightsInARow += 1;

                //if currentHeightsInARow is greater than maxHeightsInARow than there is a new mode and modeIDX must be redefined
                if(currentHeightsInARow > maxHeightsInARow){
                    maxHeightsInARow = currentHeightsInARow;
                    modeIDX = idx;
                }
            }

            //currentHeightsInARow is reset because a new search has begun
            else{
                currentHeightsInARow = 1;
            }
        }

        return modeIDX;
    }

    public static void main(String[] args) {

        //creates a new SortableVector of type Animal and calls readFromFile on it
        SortableVector<Animal> data = new SortableVector<>();
        Driver test = new Driver();
        test.readFromFile("data.txt", data);

        NameComparator nameCompare = new NameComparator();
        data.insertionSort(nameCompare);
        System.out.println(data.get(24).getName());

        WeightComparator weightCompare = new WeightComparator();
        data.insertionSort(weightCompare);
        System.out.println(data.getLast().getName());
        System.out.println(data.get(data.size() - 2).getName());
        System.out.println(data.get(data.size() - 3).getName());
        
        BMIComparator bmiCompare = new BMIComparator();
        data.selectionSort(bmiCompare);
        System.out.println(data.getLast().getName());
        System.out.println(data.get(data.size() - 2).getName());
        System.out.println(data.get(data.size() - 3).getName());

        HeightComparator heightCompare = new HeightComparator();
        data.selectionSort(heightCompare);
        int modeIDX = test.findMode(data);
        System.out.println(data.get(modeIDX).getHeight());

        int tempIDX = modeIDX;
        //while the height at the components before modeIDX is the same as at modeIDX the animal names are printed
        while(data.get(tempIDX).getHeight() == data.get(modeIDX).getHeight()){
            System.out.println(data.get(tempIDX).getName());
            tempIDX--;
        }
        
    }
}