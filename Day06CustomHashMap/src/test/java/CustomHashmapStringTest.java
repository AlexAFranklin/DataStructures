/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.day06customhashmap.CustomHashMapStringString;
import com.mycompany.day06customhashmap.CustomHashMapStringString.Pair;
import com.mycompany.day06customhashmap.KeyNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alexandrafranklin
 */
public class CustomHashmapStringTest {
    CustomHashMapStringString hashmap = new CustomHashMapStringString();
    
    public boolean doesContain(String[] theArray, String theString){
        boolean contains = false;
        for (String str : theArray){
            if (str.equals(theString)){
                contains = true;
            }
        }
        return contains;
    }
    
    public CustomHashmapStringTest() {
    }
    


   @Test
   public void testAdd() {
       hashmap.putValue("Alex", "Franklin");
       hashmap.putValue("Alex", "McBryan");
       assertEquals(true, hashmap.hasKey("Alex"));
       assertFalse(hashmap.hasKey("The Key"));
       assertEquals(1, hashmap.getSize());
       hashmap.putValue("Sharon", "McBryan");
       assertEquals(2, hashmap.getSize());
       
   }
   
   @Test
   public void hasKey(){
       hashmap.putValue("Alex", "Franklin");
       hashmap.putValue("Sharon", "McBryan");
       hashmap.putValue("Tim", "Franklin");
       hashmap.putValue("Stephanie", "Wrobbel");
//        assertThrows(KeyNotFoundException.class, () -> {
//            hashmap.getValue
//        });
        assertFalse(hashmap.hasKey("Bob"));
        assertTrue(hashmap.hasKey("Stephanie"));
   }
   
   @Test
   public void gettingValues(){
       hashmap.putValue("Alex", "Franklin");
       hashmap.putValue("Sharon", "McBryan");
       hashmap.putValue("Tim", "Franklin");
       hashmap.putValue("Stephanie", "Wrobbel");
       assertThrows(KeyNotFoundException.class, () -> {
        hashmap.getValue("Bob");
        });
       try {
           assertEquals("Wrobbel", hashmap.getValue("Stephanie"));
       } catch (KeyNotFoundException knf){
           fail();
       }
   
   }
   
   
   @Test 
   public void gettingSize(){
       assertEquals(0, hashmap.getSize());
       hashmap.putValue("Alex", "Franklin");
       hashmap.putValue("Sharon", "McBryan");
       hashmap.putValue("Tim", "Franklin");
       hashmap.putValue("Stephanie", "Wrobbel");
       assertFalse(hashmap.getSize() == 5);
       assertFalse(hashmap.getSize() == 3);
       assertEquals(4, hashmap.getSize());
       hashmap.putValue("Stephanie", "Rose");
       assertEquals(4, hashmap.getSize());
       hashmap.putValue("Terita", "Rose");
       assertEquals(5, hashmap.getSize());
        try {
           hashmap.deleteByKey("Alex");
       } catch (KeyNotFoundException knf){
           
       }
       
       assertEquals(4, hashmap.getSize());
   }
   
   
   @Test
   public void gettingAllKeys(){
       hashmap.putValue("Alex", "Franklin");
       hashmap.putValue("Sharon", "McBryan");
       hashmap.putValue("Tim", "Franklin");
       hashmap.putValue("Stephanie", "Wrobbel");
       
       String [] theKeys = hashmap.getAllKeys();
       int start = 0;
       for (String key : hashmap) {
           assertEquals(theKeys[start++], key);
       }
       assertEquals(theKeys.length, hashmap.getSize());
       assertTrue(doesContain(theKeys, "Alex"));
       assertTrue(doesContain(theKeys, "Sharon"));
       assertTrue(doesContain(theKeys, "Tim"));
       assertTrue(doesContain(theKeys, "Stephanie"));
       assertFalse(doesContain(theKeys, "Bob"));
   }
   
   @Test
   public void doesDelete(){
       hashmap.putValue("Alex", "Franklin");
       hashmap.putValue("Sharon", "McBryan");
       hashmap.putValue("Tim", "Franklin");
       hashmap.putValue("Stephanie", "Wrobbel");
       try {
           hashmap.deleteByKey("Alex");
       } catch (KeyNotFoundException knf){
           fail();
       }
      
       assertEquals(3, hashmap.getSize());
       assertFalse(hashmap.hasKey("Alex"));
       assertThrows(KeyNotFoundException.class, () ->{
           hashmap.deleteByKey("Bob");
       });
   }
   
   @Test 
   public void testPairs(){
       hashmap.putValue("Alex", "Franklin");
       hashmap.putValue("Sharon", "McBryan");
       hashmap.putValue("Tim", "Franklin");
       hashmap.putValue("Stephanie", "Wrobbel");
       CustomHashMapStringString.Pair[] thePair = hashmap.getAllKeyValPairs();
       assertEquals("Alex", thePair[0].getKey());
       assertEquals("Franklin", thePair[3].getVal());
       assertEquals(4, thePair.length);
       
   }
   
  // [Alex => Franklin, Bob => Clarke, John => Franklin, Sharon => McBryan, Tim => Franklin, Zac => Franklin]
   
   @Test
   public void testToString(){
       hashmap.putValue("Alex", "Franklin");
       hashmap.putValue("Sharon", "McBryan");
       hashmap.putValue("Tim", "Franklin");
       hashmap.putValue("Stephanie", "Wrobbel");
       String test1 = "[Alex => Franklin, Sharon => McBryan, Stephanie => Wrobbel, Tim => Franklin]";
       assertEquals(test1, hashmap.toString());
       
       hashmap.putValue("Sharon", "Franklin");
       hashmap.deleteByKey("Stephanie");
       hashmap.putValue("Bob", "The Cat");
       String test2 = "[Alex => Franklin, Bob => The Cat, Sharon => Franklin, Tim => Franklin]";
       assertEquals(test2, hashmap.toString());
   }
}
