package practice.leetcode;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] test1 = new String[] {"eat","tea","tan","ate","nat","bat"};
        String[] test1a = new String[] {"eat","tea","tan","ate","nat","bat","eat"};
        String[] test2 = new String[] {"a"};
        String[] test3 = new String[] {""};
        String[] test4 = new String[] {"", ""};
        String[] test5 = new String[] {"a", "a", "", ""};

        System.out.println(groupAnagrams(test4));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 2)
            return List.of(List.of(strs[0]));

        Map<Map<String, Long>, List<String>> map = new HashMap<>();
        for(String str : strs) {
            Map<String, Long> strMap = getStringMap(str);
            List<String> list = new ArrayList<>();
            if (map.containsKey(strMap)) {
                list = map.get(strMap);
            }
            list.add(str);
            map.put(strMap, list);
            System.out.println(map);
        }

        return new ArrayList<>(map.values());
    }

    public static Map<String, Long> getStringMap(String str) {
        return Arrays.stream(str.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }
}