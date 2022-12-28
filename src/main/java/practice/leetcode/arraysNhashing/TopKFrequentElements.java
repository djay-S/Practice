package practice.leetcode.arraysNhashing;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public static void main(String[] args) {
//        test(new int[] {1,1,1,2,2,3}, 2);
        test(new int[] {1,2}, 2);
//        test(new int[] {1}, 1);
    }

    private static void test(int[] nums, int k) {
        System.out.println(Arrays.asList(topKFrequent(nums, k)));
    }

    public static Integer[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] arr = new Integer[k];
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            if(map.containsKey(nums[i])) {
                count = map.get(nums[i]);
            }
            map.put(nums[i], count + 1);
        }

        System.out.println(map);

        List<Integer> collect = map.entrySet().stream()
                .sorted((e1, e2) -> -1 * e1.getValue().compareTo(e2.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (int i = 0; i < k; i++) {
            arr[i] = collect.get(i);
        }

//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            treeMap.put(entry.getValue(), entry.getKey());
//        }
//
//        System.out.println(treeMap);
//
//        int i = 0;
//        for(Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
//            if (i < k) {
//                arr[i] = entry.getValue();
//                i++;
//            }
//            else {
//                break;
//            }
//        }

        return arr;
    }
}
