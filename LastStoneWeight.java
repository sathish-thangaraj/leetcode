package leetcode;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args){
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b-a);

        for(int i:stones)
            queue.add(i);

        while(queue.size()>1){
            int a = queue.poll();
            int b = queue.poll();
            if(a!=b)
                queue.add(a-b);
        }

        return queue.isEmpty()?0:queue.peek();
    }
}
