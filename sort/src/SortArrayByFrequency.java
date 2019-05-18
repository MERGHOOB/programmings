import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
Sort elements by frequency | Set 1
Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.

Examples:

Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}

Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution.
 */
public class SortArrayByFrequency {


    public static void main(String[] args) {
        Integer input[] = {5,2,8,9,9,9,2};
        SortArrayByFrequency saf = new SortArrayByFrequency();
        saf.sortByFrequence(input);
        for(int i : input){
            System.out.println(i + " ");
        }
    }

    private void sortByFrequence(Integer[] input) {

        Map<Integer, SortNode> countMap = new HashMap<>();
        int index = 0;


        for(int ele : input) {
            if(countMap.containsKey(ele)) {

                SortNode s = countMap.get(ele);
                s.count++;
            }
            else{
                SortNode sortNode = new SortNode();
                sortNode.count = 1;
                sortNode.firstIndex = index;
                countMap.put(ele, sortNode);
            }
            index++;
        }

        FrequenceComparator frequencyComparator = new FrequenceComparator(countMap);
        Arrays.sort(input, frequencyComparator);

    }

}

class SortNode {
    int count;
    int firstIndex;
}

class FrequenceComparator implements Comparator<Integer> {


    Map<Integer, SortNode> countMap = null;

    FrequenceComparator(Map<Integer, SortNode> countMap) {
        this.countMap = countMap;
    }


    @Override
    public int compare(Integer first, Integer second) {
        SortNode firstNode = countMap.get(first);
        SortNode secondNode = countMap.get(second);

        if(firstNode.count > secondNode.count) {
            return -1;
        }
        else if(firstNode.count < secondNode.count) {
            return 1;
        }
        else {
            return firstNode.firstIndex < secondNode.firstIndex ? -1 : 1;
        }

    }
}
