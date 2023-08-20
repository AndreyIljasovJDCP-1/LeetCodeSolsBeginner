package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class DifferenceTwoArrays {
    public static void main(String[] args) {
        findDifference(new int[]{1, 2,  3, 3,}, new int[]{1, 1, 2, 2});
    }

    public static List<List<Integer>> findDifferenceTwoPointers(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
            res.add(list1);
            res.add(list2);
            System.out.println(list1);
            System.out.println(list2);
            return res;
        }
        public static List<List<Integer>> findDifference ( int[] nums1, int[] nums2){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            res.add(new ArrayList<>());
            Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

            for (int i : set1) {
                if (!set2.contains(i)) res.get(0).add(i);
            }
            for (int i :set2) {
                if (!set1.contains(i)) res.get(1).add(i);
            }
            return res;
        }

        public static List<List<Integer>> findDifference1 ( int[] nums1, int[] nums2){
            List<List<Integer>> res = new ArrayList<>();
            var list1 = Arrays.stream(nums1)
                    .distinct()
                    .boxed()
                    .collect(Collectors.toList());
            var list2 = Arrays.stream(nums2)
                    .distinct()
                    .boxed()
                    .collect(Collectors.toList());
            var list11 = new ArrayList<>(list1);
            list1.removeAll(list2);
            res.add(list1);
            list2.removeAll(list11);
            res.add(list2);
            return res;
        }
    }
