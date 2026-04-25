import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    private final List<Integer> listOfNumbers;
    private final Map<Integer, Integer> numberToIndexMap;
    private final Random random;

    public RandomizedSet() {
        listOfNumbers = new ArrayList<>();
        numberToIndexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(final int val) {
        if (!numberToIndexMap.containsKey(val)) {
            listOfNumbers.add(val);
            numberToIndexMap.put(val, listOfNumbers.size() - 1);
            return true;
        }

        return false;
    }

    public boolean remove(final int val) {
        if (numberToIndexMap.containsKey(val)) {
            final int index = numberToIndexMap.get(val);

            if (index != listOfNumbers.size() - 1) {
                final int last = listOfNumbers.getLast();
                listOfNumbers.set(index, last);
                numberToIndexMap.put(last, index);
            }

            listOfNumbers.removeLast();
            numberToIndexMap.remove(val);

            return true;
        }

        return false;
    }

    public int getRandom() {
        final int randomIndex = random.nextInt(listOfNumbers.size());

        return listOfNumbers.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        final RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.getRandom());
    }
}