/**
 * This class stores information about a given animal.
 */
public class Animal {
  /**
   * name of the animal
   */
  private String name;

  /**
   * height of the animal
   */
  private int height;

  /**
   * weight of the animal
   */
  private int weight;
  
  /**
   * Initializes the member variables to the respective arguments.
   * 
   * @param name the given animal's name
   * @param height (max) height in cm
   * @param weight (max) weight in kg
   */
  public Animal(String name, int height, int weight) {
    this.name = name;
    this.height = height;
    this.weight = weight;
  }

  /**
   * Returns the name of the animal.
   * 
   * @return an animal's name
   */
  public String getName() {
    return name;
  }
  
  /**
   * Returns the height of the animal. 
   * 
   * @return height of the animal, in cm
   */
  public int getHeight() {
    return height;
  }
  
  /**
   * Returns the weight of the animal.
   * 
   * @return wegiht of the animal, in kg
   */
  public int getWeight(){
    return weight;
  }

  /**
   * Constructs a string representation of the object
   *
   * @return A string representing the name, height, and weight
   */
  public String toString(){
    return "(" + name + ", " + height + ", " + weight + ")";
  }
}
