import java.util.ArrayList;

public class NumbersFinder {

    class Item{
        private int value;
        private int index;

        public Item(int value, int index){
            this.value = value;
            this.index = index;
        }

        public int getValue(){
            return value;
        }

        public int getIndex(){
            return index;
        }
    }

    public ArrayList<Item> find(int[] values, int target){      
        ArrayList<Item> items = new ArrayList<Item>();
        for(int i = 0; i < values.length; i++)
            items.add(new Item(values[i], i));

        items = quicksort(items);
        ArrayList<Integer> diffs = computeDiffs(items, target);

        Item item1 = null;
        Item item2 = null;

        boolean found = false;

        for(int i = 0; i < diffs.get(i) && !found; i++){
            item1 = items.get(i);
            item2 = searchSortedItems(items, diffs.get(i), 0, items.size());
            found = item2 != null;
        }
        if(found){
            ArrayList<Item> result = new ArrayList<Item>();
            result.add(item1);
            result.add(item2);
            return result;
        }
        else
            return null;
    }

    // find "value" in the sorted array of "items" using Binary search in O(log n)
    private Item searchSortedItems(ArrayList<Item> items, Integer value, int lower, int upper) {
        if(lower > upper)
            return null;
        int middle = (lower + upper)/2;
        Item middleItem = items.get(middle);
        if(middleItem.getValue() == value)
            return middleItem;
        else if(middleItem.getValue() < value)
            return searchSortedItems(items, value, middle+1, upper);
        else
            return searchSortedItems(items, value, lower, middle-1);
    }

    // Simply calculates difference between the target value and each item in the array; O(n)
    private ArrayList<Integer> computeDiffs(ArrayList<Item> items, int target) {
        ArrayList<Integer> diffs = new ArrayList<Integer>();
        for(int i = 0; i < items.size(); i++)
            diffs.add(target - items.get(i).getValue());
        return diffs;
    }

    // Sorts items using QuickSort algorithm in O(n Log n)
    private ArrayList<Item> quicksort(ArrayList<Item> items) {
        if (items.size() <= 1)
            return items;
        int pivot = items.size() / 2;
        ArrayList<Item> lesser = new ArrayList<Item>();
        ArrayList<Item> greater = new ArrayList<Item>();
        int sameAsPivot = 0;
        for (Item item : items) {
            if (item.getValue() > items.get(pivot).getValue())
                greater.add(item);
            else if (item.getValue() < items.get(pivot).getValue())
                lesser.add(item);
            else
                sameAsPivot++;
        }
        lesser = quicksort(lesser);
        for (int i = 0; i < sameAsPivot; i++)
            lesser.add(items.get(pivot));
        greater = quicksort(greater);
        ArrayList<Item> sorted = new ArrayList<Item>();
        for (Item item : lesser)
            sorted.add(item);
        for (Item item: greater)
            sorted.add(item);
        return sorted;
    }


    public static void main(String[] args){
        int[] s = {2,7,10,9};
        int value = 9;

        NumbersFinder finder = new NumbersFinder();
        ArrayList<Item> numbers = finder.find(s, value);

        if(numbers != null){
            System.out.println("First Number Found = " + numbers.get(0).getValue() + " ; Index = " + + numbers.get(0).getIndex());
            System.out.println("Second Number Found = " + numbers.get(1).getValue() + " ; Index = " + + numbers.get(1).getIndex());
        }
        else{
            System.out.println("No such two numbers found in the array!");
        }
    }
}