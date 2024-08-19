import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestingManager {
    private Bag <String> testBag1;
    private Bag <String> testBag2;
    @Before
    public void testSetUp() {
        testBag1 = new Bag();
        testBag2 = new Bag();
        testBag1.add("Bubble Gum");
        testBag1.add("Twix");
        testBag1.add("Godiva Chocolate Bar");
        testBag1.add("Spearmint Leaves");
        testBag2.add("Swedish Fish");
        testBag2.add("Baby Ruth");
        testBag2.add("Godiva Chocolate Bar");
        testBag2.add("Gummy Bears");}



    @org.junit.Test
    public void testAdd() {
        int result = (int) testBag1.treats.getOrDefault("Bubble Gum",0);
        assertEquals(1, result);}
    @org.junit.Test
    public void testRemove(){
        testBag1.remove("Bubble Gum");
        int result = (int) testBag1.treats.getOrDefault("Bubble Gum",999);
        assertEquals(999,result);}
    @org.junit.Test
    public void testSize(){
        int result = testBag1.size();
        assertEquals(4, result);}
    @org.junit.Test
    public void testMerge(){
        testBag1.merge(testBag1,testBag2);
        int result = (int) testBag1.treats.getOrDefault("Godiva Chocolate Bar",999);
        assertEquals(2,result);}
    @org.junit.Test
    public void testDistinct(){
        StringBuilder result = testBag2.distinct(testBag2);
        String convertedResult = result.toString();
        boolean containsBrand1 = convertedResult.contains("Twix");
        boolean containsBrand2 = convertedResult.contains("Baby Ruth");
        boolean finalBool = containsBrand1 && containsBrand2;
        assertEquals(finalBool, true);
    }


public static void main(String[] args) {
    Result result = JUnitCore.runClasses(TestingManager.class);

    // Print test results
    for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
    }

    System.out.println("All tests passed: " + result.wasSuccessful());
}}