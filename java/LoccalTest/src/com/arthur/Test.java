package com.arthur;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


@MyAnnotation(args = { "", "" }, value="")
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Map<String, Bean> map = new HashMap();
        map.put("k1", new Bean("Tom"));
        map.put("k2", new Bean("Mike"));
        
        Map<String, Bean> outerMap = new HashMap(map);
        
        System.out.println(map);
        System.out.println(outerMap);
        
        outerMap.remove("k1");
        
        outerMap.get("k2").setName("Mike2");
        
        System.out.println("***************");
        System.out.println(map);
        System.out.println(outerMap);
        
//        Set<String> set = new HashSet<String>();
//        
//        set.add("a");
//        set.add("b");
//        set.add("c");
////        set.contains("");
//        set.forEach(e -> {System.out.println(e.toString());});
//        
//        List<Integer> l2 = new ArrayList<>();
//        
        Deque<Integer> stack = new LinkedList<>();
        
        stack.push(1);
        stack.push(1);
        Integer topEle = stack.peek();
        Integer element = stack.pop();
        
        
        Stack<Integer> s2 = new Stack<>();
        
        s2.push(1);
        s2.push(1);
        s2.pop();
        s2.empty();
        s2.peek();
        
        Deque<Integer> dqueue = new LinkedList<>();
        dqueue.add(1);
        dqueue.add(1);
        dqueue.removeFirst();
        dqueue.removeLast();
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("abc");
        sb.insert(0, "A");
        System.out.println(sb.toString());
        sb.substring(0, 3);
        
        String s = sb.toString();
//        s.sub
        
        Class clazz = Test.class;
        clazz.isAnnotationPresent(MyAnnotation.class);
        clazz.getAnnotation(MyAnnotation.class);
//        clazz.getAnnotation(annotationClass)
        
        Thread.currentThread();
        
	}

}
