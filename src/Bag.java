import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * this class constructs multisets that represent Halloween candy bags, and includes methods
 * to interact with multiset instances
 */
public class Bag<T>{

    /**
     * hashmap declaration that assists constructor in creating
     * multiset instances
     */
    public Map<T,Integer> treats;

    /**
     * constructor for Bag class creates hashmap instances
     */
    public Bag(){
        treats = new HashMap<>();
    }

    /**
     * adds new element to Bag object
     */
    public void add (T brand){
        if (treats == null) {
            treats = new HashMap<>();}
        treats.put(brand,treats.getOrDefault(brand,0)+1);}

    /**
     * prints String representation of Bag instance
     */
    public void print(Bag<T> bag){
        if(bag.treats != null){
            System.out.println("\nCurrent contents of bag:\n[");
            for (Map.Entry<T, Integer> entry : bag.treats.entrySet()) {
                T key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("Key: " + key + ", Value: " + value);
            }System.out.println("]\n");}
        else{System.out.println("Alert: This bag does not exist");}}

    /**
     * Returns quantity of elements in "treats" hashmap.
     * If "treats" is null, print alert for user
     */
    public int size() {
        if (treats != null){
            int totalTreats = 0;
            for(int count : treats.values()){
                totalTreats+=count;}
            return totalTreats;}
        else{return 0;}}

    /**
     * This method removes a specified element from
     * "treats" if one or more of the type T argument exists
     * within Bag instance.
     */
    public void remove (T brand){
        int brandCount = treats.get(brand);
        if (brand != null && treats.containsKey(brand)){
            if(brandCount==1){
                treats.remove(brand);}
            else{treats.put(brand,brandCount-1);}}
        else if (brand != null){
            System.out.println("Alert: this candy does not exist in this bag");}
        else{System.out.println("Alert: this bag does not exist");}}

    /**
     * Determines if certain Type &lt;T&gt; key exists within hashmap
     */
    public void contains(T brand) {
        if (treats != null){
            boolean result = treats.containsKey(brand);
            if (result) {
                System.out.println("This bag contains the key \"" + brand + "\"");
            } else {
                System.out.println("This bag does not contain the key \"" + brand + "\"");}}
        else{System.out.println("Alert: This bag does not exist");}}

    /**
     * Merges the elements of one Bag instance with another, thus
     * uniting the key/value (Type&lt;T&gt;/Integer) pairs of both objects
     **/
    public void merge(Bag<T> firstBag, Bag<T> secondBag){
        if ((firstBag != null)&&(secondBag != null)){
            System.out.println("first bag:");
            print(firstBag);
            System.out.println("second bag:");
            print(secondBag);
            treats.putAll(secondBag.treats);
            System.out.println("Merged bag:");
            print(firstBag);}
        else{System.out.println("Alert: One or more of these objects of class Bag do not exist.");}}

    /**
     * This method prints a set that consists of a collection
     * of String values that represent all the unique Type&lt;T&gt;
     * keys in the hashmap
     */
    public StringBuilder distinct(Bag<String> bag) {
        StringBuilder distinctString = null;
        if (bag != null) {
            Set<String> set = bag.treats.keySet();
            String[] stringArray = set.toArray(new String[set.size()]);
            distinctString = new StringBuilder();
            for (String brand : stringArray)
                distinctString.append(brand + " ; ");
            return distinctString;}
        else{System.out.println("Alert: This object of class Bag does not exist.");
            return null;}}}

