package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args) {
//        int[] v = {20, 5, 10, 40, 15, 25};
//        int[] w = {1, 2, 3, 8, 7, 4};
//
        int[] v = {60,100,120};
        int[] w = {10,20,30};

        // Knapsack capacity
        int W = 50;
        System.out.println(new FractionalKnapsack().collectedMaximum(v, w, W));
    }

    private double collectedMaximum(int[] values, int[] weights, int knapsackCapacity) {

        //create a combination for values, weight as an Item class then sort the items
        Item [] items = createItems(values, weights);
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.value/item1.weight > item2.value/item2.weight ? -1 : 1;
            }
        });

        double collectedValue = 0;
        for(Item item: items) {
            if(item.weight < knapsackCapacity) {
                knapsackCapacity -=item.weight;
                collectedValue +=item.value;
            }
            else if(item.weight > knapsackCapacity) {
                collectedValue += ( (double)item.value/item.weight)*knapsackCapacity;
               knapsackCapacity =0;
            }
            if(knapsackCapacity == 0) {
                break;
            }

//            System.out.println(item.value  +" | " + item.weight );
        }


        return collectedValue;
    }

    private Item[] createItems(int[] values, int[] weights) {
        Item []  items = new Item[values.length];
        for(int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        return items;
    }


    private class Item {
        int weight;
        int value;
         Item(int value, int weight) {
             this.weight = weight;
             this.value = value;
         }
    }
}
