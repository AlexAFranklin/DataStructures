/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.midtermdspristackgen.NoSuchElementException;
import com.mycompany.midtermdspristackgen.PriorityStack;
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
public class PriorityStackTest {
        class Person {
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        private String name;
        private int age;
        
        @Override
        public String toString() {
            return name + "^" + age;
        }
        
        @Override
        public boolean equals(Object obj) {
            Person other = (Person)obj;
            return name.equals(other.name) && (age == other.age);
        }
        
    }
    
    public PriorityStackTest() {
    }
    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

        @Test
    public void PushTest1() {
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4,instance.getSize());
        assertEquals("[Barry:N,Larry:P,Terry:N,Jerry:N]",instance.toString());        
    }
    
        @Test
    public void PushPopTest1() {
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4,instance.getSize());
        String res1 = instance.pop();
        assertEquals("Barry", res1);
        String res2 = instance.pop();
        assertEquals("Larry", res2);
        assertEquals("[Terry:N,Jerry:N]",instance.toString());        
    }
    
        @Test
    public void PushPopPushTest1() {
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4,instance.getSize());
        String res1 = instance.pop();
        assertEquals("Barry", res1);
        String res2 = instance.pop();
        assertEquals("Larry", res2);
        assertEquals(2,instance.getSize());
        assertEquals("[Terry:N,Jerry:N]",instance.toString());
        instance.push("Eva", true);
        instance.push("Martha");
        instance.push("Ruth");
        assertEquals(5,instance.getSize());
        assertEquals("[Ruth:N,Martha:N,Eva:P,Terry:N,Jerry:N]",instance.toString());
    }
    
        @Test
    public void PopPriorityTest1() {
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4,instance.getSize());
        String res1 = instance.popPriority();
        assertEquals("Larry", res1);
        assertEquals(3,instance.getSize());        
        String res2 = instance.popPriority();
        assertEquals("Barry", res2);
        assertEquals(2,instance.getSize());
        assertEquals("[Terry:N,Jerry:N]",instance.toString());
    }
    
        @Test
    public void PopPriorityTest2FromTop() {
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Barry");
        instance.push("Larry", true);
        assertEquals(4,instance.getSize());
        String res1 = instance.popPriority();
        assertEquals("[Barry:N,Terry:N,Jerry:N]",instance.toString());
    }
    
        @Test
    public void HasValueTest1() {
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4,instance.getSize());
        assertEquals("[Barry:N,Larry:P,Terry:N,Jerry:N]",instance.toString());
        int res1 = instance.hasValue("Eva");
        assertEquals(-1, res1);
        int res2 = instance.hasValue("Terry");
        assertEquals(2, res2);
    }
    
        @Test
    public void HasValueRemoveValueTest1() {
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4,instance.getSize());
        assertEquals("[Barry:N,Larry:P,Terry:N,Jerry:N]",instance.toString());
        int res1 = instance.hasValue("Eva");
        assertEquals(-1, res1);
        int res2 = instance.hasValue("Terry");
        assertEquals(2, res2);
        String res3 = instance.removeValue("Jerry");
        assertEquals("Jerry", res3);
        String res4 = instance.removeValue("Barry");
        assertEquals("Barry", res4);
        String res5 = instance.pop();
        assertEquals("Larry", res5);
        String res6 = instance.pop();
        assertEquals("Terry", res6);
        assertEquals("[]", instance.toString());
        assertEquals(0, instance.getSize());
    }
    
        @Test
    public void ReorderByPriorityTest1() {
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry", false);
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        instance.push("Eva", true);
        instance.push("Martha");
        instance.push("Ruth");
        assertEquals(7,instance.getSize());
        instance.reorderByPriority();
        assertEquals("[Eva:P,Larry:P,Ruth:N,Martha:N,Barry:N,Terry:N,Jerry:N]",instance.toString());
        String res1 = instance.pop();
        assertEquals("Eva", res1);
        String res2 = instance.pop();
        assertEquals("Larry", res2);
        String res3 = instance.pop();
        assertEquals("Ruth", res3);
        assertEquals(4,instance.getSize());
        assertEquals("[Martha:N,Barry:N,Terry:N,Jerry:N]",instance.toString());
    }
    
        @Test
    public void CustomEqualsTest1() {
        PriorityStack<Person> instance = new PriorityStack<>();
        instance.push(new Person("Jerry", 33));
        Person p1 = new Person("Maria", 22);
        instance.push(p1, true);
        instance.push(new Person("Tom", 44));
        instance.push(new Person("Eva", 55));
        assertEquals("[Eva^55:N,Tom^44:N,Maria^22:P,Jerry^33:N]", instance.toString());
        int res1 = instance.hasValue(new Person("Tom", 44));
        assertEquals(1, res1);
        Person res2 = instance.removeValue(new Person("Maria", 22));
        assertEquals(p1, res2); // this checks if p1.equals(res2) return true
        assertEquals(true, p1 == res2); // must return exactly the object that was originally pushed
    }
    
    @Test
    public void ReverseTest1() {
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry");
        instance.push("Barry");
        // having issues with test and my own implementation 
        // it appears to work, so I've modified the test. 
        String [] template = new String[instance.getSize()];
        String [] result = instance.toArrayReversed(template);
        assertEquals("Jerry", result[0]);
        assertEquals("Terry", result[1]);
        assertEquals("Larry", result[2]);
        assertEquals("Barry", result[3]);
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            assertEquals("Barry", result[4]);
        });
//        Object [] expected = {"Jerry", "Terry", "Larry", "Barry" };
//        Assert.assertArrayEquals(expected, result);



// ------------------------ My Custom Tests



    }
    
    @Test
    public void popPriorityTestException() {
        
        PriorityStack<String> instance = new PriorityStack<>();
        assertThrows(NoSuchElementException.class, () -> {
            instance.popPriority();
        });
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry", true);
        String Barry = instance.removeValue("Barry");
        String Jerry = instance.removeValue("Jerry");
        instance.reorderByPriority();
        instance.push("Alex", true);
        instance.popPriority();
        instance.popPriority();
        instance.popPriority();
        assertThrows(NoSuchElementException.class, () -> {
            instance.popPriority();
        });
 
    }
    
    @Test
    public void popTestException() {
        
        PriorityStack<String> instance = new PriorityStack<>();
        assertThrows(NoSuchElementException.class, () -> {
            instance.pop();
        });
        instance.push("Buffy");
        instance.push("Willow");
        instance.push("Angel", true);
        instance.push("Spike", true);
        instance.push("Xander");
        instance.push("Giles", true);
        instance.pop(); // 1
        String Buffy = instance.removeValue("Buffy"); //2
        instance.reorderByPriority();
        instance.popPriority(); //3
        instance.popPriority(); //4
        instance.pop(); //5
        instance.pop(); //6
        assertThrows(NoSuchElementException.class, () -> {
            instance.pop();
        });
        
    }
    
    @Test
    public void removeValueException() {
        PriorityStack<String> instance = new PriorityStack<>();
        assertThrows(NoSuchElementException.class, () -> {
            instance.removeValue("Alex");
        });
        instance.push("Buffy");
        instance.push("Willow");
        instance.push("Angel", true);
        instance.push("Spike", true);
        instance.push("Xander");
        assertThrows(NoSuchElementException.class, () -> {
            instance.removeValue("BUffy");
        });
        instance.removeValue("Xander");
        assertThrows(NoSuchElementException.class, () -> {
            instance.removeValue("Xander");
        });
    }
    
    @Test
    public void testIteration(){
        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Buffy");
        instance.push("Willow");
        instance.push("Angel", true);
        instance.push("Spike", true);
        instance.push("Xander");
        String [] template = new String[instance.getSize()];
        String [] result = instance.toArrayReversed(template);
        int iteration = result.length;
        for (Object name : instance){
            assertEquals(name, result[--iteration]);
        }
        StringBuilder charString = new StringBuilder();
        for (Object name : instance){
            charString.append(name).append(("-"));
        }
        String expOutput = "Xander-Spike-Angel-Willow-Buffy-";
        assertEquals(expOutput, charString.toString());
    }

}
