
import com.mycompany.binarytreekeyvalue.GenericBinaryTree;
import com.mycompany.binarytreekeyvalue.Pair;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GenericKeyValueTest {

    public GenericKeyValueTest() {
    }

    @Test
    public void testPutAndSizeIntString() {
        GenericBinaryTree<Integer, String> genTree = new GenericBinaryTree<>();
        assertEquals(0, genTree.getSize());
        genTree.put(2764, "Alex");
        genTree.put(2357, "Tim");
        genTree.put(9374, "Steph");
        genTree.put(2947, "Zac");
        genTree.put(1234, "Noemie");
        genTree.put(3487, "Chris");
        assertEquals(6, genTree.getSize());
        genTree.put(2947, "Justine");
        genTree.put(1234, "Emma");
        genTree.put(3487, "Leah");
        assertEquals(6, genTree.getSize());

    }

    @Test
    public void testPutAndSizeStringString() {
        GenericBinaryTree<String, String> genTree = new GenericBinaryTree<>();
        assertEquals(0, genTree.getSize());
        genTree.put("DHKB", "Alex");
        genTree.put("JSBI", "Tim");
        genTree.put("SJEI", "Steph");
        genTree.put("SBFK", "Zac");
        genTree.put("SOBF", "Noemie");
        genTree.put("SIFH", "Chris");
        assertEquals(6, genTree.getSize());
        genTree.put("SOBF", "Justine");
        genTree.put("SIFH", "Emma");
        genTree.put("JSBI", "Leah");
        assertEquals(6, genTree.getSize());

    }

    @Test
    public void testGetValueIntString() {
        GenericBinaryTree<Integer, String> genTree = new GenericBinaryTree<>();
        genTree.put(2764, "Alex");
        genTree.put(2357, "Tim");
        genTree.put(9374, "Steph");
        genTree.put(2947, "Zac");
        genTree.put(1234, "Noemie");
        genTree.put(3487, "Chris");
        assertThrows(RuntimeException.class, () ->{
            genTree.getValByKey(12345);
        });
        assertEquals("Alex", genTree.getValByKey(2764));
        assertEquals("Tim", genTree.getValByKey(2357));
        assertEquals("Steph", genTree.getValByKey(9374));
        assertEquals("Zac", genTree.getValByKey(2947));
        assertEquals("Noemie", genTree.getValByKey(1234));
        assertEquals("Chris", genTree.getValByKey(3487));
        genTree.put(2947, "Justine");
        genTree.put(1234, "Emma");
        genTree.put(3487, "Leah");
        assertEquals("Justine", genTree.getValByKey(2947));
        assertEquals("Emma", genTree.getValByKey(1234));
        assertEquals("Leah", genTree.getValByKey(3487));
        assertThrows(RuntimeException.class, () ->{
            genTree.getValByKey(9000);
        });
    }

    @Test
    public void testGetValueStringString() {
        GenericBinaryTree<String, String> genTree = new GenericBinaryTree<>();
        genTree.put("DHKB", "Alex");
        genTree.put("JSBI", "Tim");
        genTree.put("SJEI", "Steph");
        genTree.put("SBFK", "Zac");
        genTree.put("SOBF", "Noemie");
        genTree.put("SIFH", "Chris");
        assertThrows(RuntimeException.class, () ->{
            genTree.getValByKey("SJEO");
        });
        assertEquals("Alex", genTree.getValByKey("DHKB"));
        assertEquals("Tim", genTree.getValByKey("JSBI"));
        assertEquals("Steph", genTree.getValByKey("SJEI"));
        assertEquals("Zac", genTree.getValByKey("SBFK"));
        assertEquals("Noemie", genTree.getValByKey("SOBF"));
        assertEquals("Chris", genTree.getValByKey("SIFH"));
        genTree.put("SOBF", "Justine");
        genTree.put("SIFH", "Emma");
        genTree.put("JSBI", "Leah");
        assertEquals("Emma", genTree.getValByKey("SIFH"));
        assertEquals("Leah", genTree.getValByKey("JSBI"));
        assertEquals("Justine", genTree.getValByKey("SOBF"));
        assertThrows(RuntimeException.class, () ->{
            genTree.getValByKey("BBBB");
        });

    }

    @Test
    public void returnsKeysInOrderIntString() {
        GenericBinaryTree<Integer, String> genTree = new GenericBinaryTree<>();
        genTree.put(2764, "Alex");
        genTree.put(2357, "Tim");
        genTree.put(9374, "Steph");
        genTree.put(2947, "Zac");
        genTree.put(1234, "Noemie");
        genTree.put(3487, "Chris");
        int[] expected1 = {
            1234, 2357, 2764, 2947, 3487, 9374
        };
        Integer[] template = new Integer[genTree.getSize()];
        Integer[] keys = genTree.getKeysInOrder(template);

        for (int i = 0; i < genTree.getSize(); i++) {
            assertEquals(expected1[i], keys[i]);
        }

        genTree.put(100, "Zac");
        genTree.put(-1000, "Noemie");
        genTree.put(10000, "Chris");
        int[] expected2 = {
            -1000, 100, 1234, 2357, 2764, 2947, 3487, 9374, 10000
        };
        Integer[] template2 = new Integer[genTree.getSize()];
        Integer[] keys2 = genTree.getKeysInOrder(template2);

        for (int i = 0; i < genTree.getSize(); i++) {
            assertEquals(expected2[i], keys2[i]);
        }
    }

    @Test
    public void returnsKeysInOrderStringString() {
        GenericBinaryTree<String, String> genTree = new GenericBinaryTree<>();
        genTree.put("DHKB", "Alex");
        genTree.put("JSBI", "Tim");
        genTree.put("SJEI", "Steph");
        genTree.put("SBFK", "Zac");
        String[] expected1 = {
            "DHKB", "JSBI", "SBFK", "SJEI"
        };
        String[] template = new String[genTree.getSize()];
        String[] keys = genTree.getKeysInOrder(template);

        for (int i = 0; i < genTree.getSize(); i++) {
            assertEquals(expected1[i], keys[i]);
        }
        genTree.put("SOBF", "Noemie");
        genTree.put("SIFH", "Chris");
        genTree.put("AAAA", "Noemie");
        genTree.put("ZZZZ", "Chris");

        String[] expected2 = {
            "AAAA", "DHKB", "JSBI", "SBFK", "SIFH", "SJEI", "SOBF", "ZZZZ"
        };
        String[] template2 = new String[genTree.getSize()];
        String[] keys2 = genTree.getKeysInOrder(template2);

        for (int i = 0; i < genTree.getSize(); i++) {
            assertEquals(expected2[i], keys2[i]);
        }
    }

    @Test
    public void iterationIntString() {
        GenericBinaryTree<Integer, String> genTree = new GenericBinaryTree<>();
        genTree.put(2764, "Alex");
        genTree.put(2357, "Tim");
        genTree.put(9374, "Steph");
        int[] keys1 = {
            2357, 2764, 9374
        };
        String[] values1 = {
            "Tim", "Alex", "Steph"
        };
        int increment = 0;
        for (Pair pair : genTree) {
            assertEquals(keys1[increment], pair.key);
            assertEquals(values1[increment], pair.value);
            increment++;
        }

        genTree.put(2947, "Zac");
        genTree.put(1234, "Noemie");
        genTree.put(3487, "Chris");

        int[] keys2 = {
            1234, 2357, 2764, 2947, 3487, 9374
        };
        String[] values2 = {
            "Noemie", "Tim", "Alex", "Zac", "Chris", "Steph"
        };
        increment = 0;
        for (Pair pair : genTree) {
            assertEquals(keys2[increment], pair.key);
            assertEquals(values2[increment], pair.value);
            increment++;
        }
        
    }
    
    @Test
    public void iterationStringString(){
        GenericBinaryTree<String, String> genTree = new GenericBinaryTree<>();
        genTree.put("DHKB", "Alex");
        genTree.put("JSBI", "Tim");
        genTree.put("SJEI", "Steph");
        genTree.put("SBFK", "Zac");
        String[] keys1 = {
            "DHKB", "JSBI", "SBFK", "SJEI"
        };
        String[] values1 = {
            "Alex", "Tim", "Zac", "Steph"
        };
        int increment = 0;
        for (Pair pair : genTree){
            assertEquals(keys1[increment], pair.key);
            assertEquals(values1[increment], pair.value);
            increment++;
        }
        
        genTree.put("SOBF", "Noemie");
        genTree.put("SIFH", "Chris");
        genTree.put("AAAA", "Noemie");
        genTree.put("ZZZZ", "Chris");

        String[] keys2 = {
            "AAAA", "DHKB", "JSBI", "SBFK", "SIFH", "SJEI", "SOBF", "ZZZZ"
        };
        String[] values2 = {
            "Noemie", "Alex", "Tim", "Zac", "Chris", "Steph", "Noemie", "Chris"
        };
        increment = 0;
        for (Pair pair : genTree){
            assertEquals(keys2[increment], pair.key);
            assertEquals(values2[increment], pair.value);
            increment++;
        }
    }

}
