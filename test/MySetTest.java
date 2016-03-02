import org.junit.Assert;
import org.junit.Test;

public class MySetTest {
    @Test
    public void testAddAString() throws Exception {
        MySet<String> set = new MySet<>();
        set.add("A");
        set.add("B");
        Assert.assertTrue(set.contains("A"));
    }

    @Test
    public void testAddNumeric() throws Exception {
        MySet<Integer> set = new MySet<>();
        set.add(1);
        set.add(2);
        Assert.assertTrue(set.contains(1));
    }

    @Test
    public void testAddingDuplicateValue() throws Exception {
        MySet<String> set = new MySet<>();
        set.add("A");
        set.add("B");
        set.add("B");
        Assert.assertEquals(set.size(),2);
    }

    @Test
    public void testContainsAnElement() throws Exception {
        MySet<String> set = new MySet<>();
        set.add("A");
        set.add("B");
        Assert.assertTrue(set.contains("A"));
        Assert.assertFalse(set.contains("C"));
    }

    @Test
    public void testForCheckSetIsEmpty() throws Exception {
        MySet<String> set = new MySet<>();
        Assert.assertTrue(set.isEmpty());
    }

    @Test
    public void testForGettingNumberOfElementInSet() throws Exception {
        MySet<String> set = new MySet<>();
        set.add("A");
        set.add("B");
        set.add("B");
        set.add("C");
        set.add("D");
        Assert.assertEquals(set.size(),4);
    }

    @Test
    public void testForClearSet() throws Exception {
        MySet<String> set = new MySet<>();
        set.add("A");
        set.add("B");
        set.add("B");
        set.add("C");
        set.add("D");
        set.clear();
        Assert.assertEquals(set.size(),0);
    }

    @Test
    public void testAddCollectionsToSet() throws Exception {
        MySet<String> set = new MySet<>();
        set.add("A");
        set.add("E");
        MySet<String> newSet = new MySet<>();
        newSet.add("A");
        newSet.add("C");
        Boolean result = newSet.addAll(set);
        Assert.assertTrue(result);
        Assert.assertEquals(newSet.size(),3);

    }
    @Test
    public void testAddCollectionsToSetIfElementIsSameAsCollection() throws Exception {
        MySet<String> set = new MySet<>();
        set.add("A");
        set.add("E");
        set.add("D");
        MySet<String> newSet = new MySet<>();
        newSet.add("A");
        newSet.add("E");
        Assert.assertEquals(newSet.size(),2);
        Assert.assertTrue(newSet.addAll(set));
    }

    @Test
    public void testSetContainAllElementOfCollection() throws Exception {
        MySet<Integer> set = new MySet<>();
        set.add(1);
        set.add(2);
        MySet<Integer> newSet = new MySet<>();
        newSet.add(1);
        newSet.add(2);
        newSet.add(3);
        Assert.assertTrue(newSet.containAll(set));
    }
    @Test
    public void testSetContainAllElementOfCollectionReturnFalseIfNot() throws Exception {
        MySet<Integer> set = new MySet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        MySet<Integer> newSet = new MySet<>();
        newSet.add(1);
        newSet.add(2);
        newSet.add(3);
        Assert.assertFalse(newSet.containAll(set));
    }

    @Test
    public void testCheckIsEqualTwoSets() throws Exception {
        MySet<Integer> set = new MySet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        MySet<Integer> newSet = new MySet<>();
        newSet.add(1);
        newSet.add(2);
        newSet.add(3);
        Assert.assertFalse(newSet.equals(set));
        Assert.assertTrue(newSet.equals(newSet));
    }

    @Test
    public void testGetHashCodeOfSet() throws Exception {
        MySet<Integer> set = new MySet<>();
        set.add(2);
        set.add(0);
        set.add(2);
        Assert.assertEquals(set.hashCode(),62);
    }
}