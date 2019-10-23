package com.ikouz.algorithm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Gived a dic which contains a lot of words, a source word and target word. Can you find a path from the source word to the target word?
 * The rule of the path from one word to another is the end char of the former word is same with the start char of the next word. Please print the shortest path.
 * <p>
 * Example:
 * Input: hello, world, [old, data, amazon, new, find, a, path, to, success, can, you, do]
 * Output: hello, old, data, amazon, new, world.
 */
public class DP_ShortestPath {

    public static int findShortestPathLength(List<String> dic, String source, String target) {
        Queue<String> queue = new LinkedList();
        queue.offer(source);
        Map<String, Integer> pathLengthMap = new HashMap<>();
        pathLengthMap.put(source, 1);
        Map<String, List<String>> pathMap = new HashMap();
        while (!queue.isEmpty()) {
            String qStr = queue.poll();
            for (String str : dic) {
                if (pathLengthMap.containsKey(str)) {
                    continue;
                }
                if (qStr.charAt(qStr.length() - 1) == str.charAt(0)) {
                    if (target.equals(str)) {
                        return pathLengthMap.get(qStr) + 1;
                    } else {
                        queue.offer(str);
                        pathLengthMap.put(str, pathLengthMap.get(qStr) + 1);
                    }
                }
            }
        }
        return 0;
    }

    public static List findShortestPath(List<String> dic, String source, String target) {
        Queue<String> queue = new LinkedList();
        queue.offer(source);
        Map<String, List<String>> pathMap = new HashMap();
        List list = new ArrayList();
        list.add(source);
        pathMap.put(source, list);
        while (!queue.isEmpty()) {
            String qStr = queue.poll();
            for (String str : dic) {
                if (pathMap.containsKey(str)) {
                    continue;
                }
                if (qStr.charAt(qStr.length() - 1) == str.charAt(0)) {
                    if (target.equals(str)) {
                        pathMap.get(qStr).add(str);
                        return pathMap.get(qStr);
                    } else {
                        queue.offer(str);
                        List l = new ArrayList();
                        l.addAll(pathMap.get(qStr));
                        l.add(str);
                        pathMap.put(str, l);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(findShortestPathLength(Arrays.asList("hello", "old", "data", "amazon", "new", "find", "a", "world"), "hello", "world"));
        System.out.println(findShortestPath(Arrays.asList("hello", "old", "data", "amazon", "nested", "work", "new", "find", "a", "world", "owww"), "hello", "world"));
    }
}
