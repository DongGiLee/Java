import java.util.*;

public class Sample2 {

    public static void main(String[] args) {

        int[] data = { 5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8 };

        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i : data) {
            if (i % 2 == 0)
                dataList.add(i);
        }

        HashSet<Integer> dataSet = new HashSet<>(dataList);
        ArrayList<Integer> distinctList = new ArrayList<Integer>(dataSet);

        distinctList.sort(Comparator.reverseOrder());

        int[] result = new int[distinctList.size()];

        for (int j = 0; j < distinctList.size(); j++) {
            result[j] = distinctList.get(j);
            System.out.println(distinctList.get(j));
        }
        System.out.println(result);

    }

}
