/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.binarysearchtree.Tree;
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
public class TreeTest {
    
    public TreeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
         
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void getSizeTestAndPut(){
        Tree bst = new Tree();
        boolean caught = false;
        assertEquals(0, bst.getSize());
        bst.put(1000);
        bst.put(19920);
        bst.put(2);
        bst.put(59);
        bst.put(84);
        assertEquals(5, bst.getSize());
        try {
        bst.put(19920);
        bst.put(2);
        fail();
        }  catch(IllegalArgumentException iae){
          caught = true;  
        }
        assertEquals(5, bst.getSize());
        assertTrue(caught);
        assertThrows(RuntimeException.class, () ->{
            bst.put(1000);
        });
        assertThrows(RuntimeException.class, () ->{
            bst.put(2);
        });

    }
    
    @Test
    public void hasTheValues(){
        Tree bst = new Tree();
        bst.put(1000);
        bst.put(19920);
        bst.put(2);
        bst.put(59);
        bst.put(84);
        assertTrue(bst.hasValue(1000));
        assertTrue(bst.hasValue(19920));
        assertTrue(bst.hasValue(2));
        assertTrue(bst.hasValue(59));
        assertTrue(bst.hasValue(84));
        
        assertFalse(bst.hasValue(9837));
        assertFalse(bst.hasValue(85));
        assertFalse(bst.hasValue(3));
    }
    
    @Test 
        public void addsCorrectly(){
        Tree bst = new Tree();
        bst.put(1000);
        bst.put(19920);
        bst.put(2);
        bst.put(59);
        bst.put(84);
        assertEquals(21065, bst.getSumOfAllValues());
        bst.put(-21000);
        assertEquals(65, bst.getSumOfAllValues());
        bst.put(-100);
        assertEquals(-35, bst.getSumOfAllValues());
    }
        
    @Test
   public void valuesInOrder(){
        Tree bst = new Tree();
        bst.put(5);
        bst.put(8);
        bst.put(3);
        bst.put(4);
        bst.put(9);
        bst.put(7);
        bst.put(1);
        bst.put(2);
        bst.put(6);
        bst.put(0);
        int increment = 0;
        for (int leaf: bst){
            assertTrue(leaf == increment++);
        }
        int [] intArray = bst.getValuesInOrder();
        increment = 0;
        for (int i = 0; i < bst.getSize(); i++){
            assertTrue(intArray[i] == i);
        }
   }
    
    
    
}
