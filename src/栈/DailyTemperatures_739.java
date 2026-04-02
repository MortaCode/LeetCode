package 栈;

import java.util.Stack;

//每日温度-739
public class DailyTemperatures_739 {

    //给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[]{};
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (temperatures[j] > temperatures[i]){
                    result[i] = j-i;
                    break;//否则是最后一个大于的
                }
            }
        }
        return result;
    }

    public int[] dailyTemperaturesUP(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[]{};
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for (int i=0; i<n; i++){
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73}; //[1,1,4,2,1,1,0,0]
        DailyTemperatures_739 dailyTemperatures = new DailyTemperatures_739();
        //int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        int[] result = dailyTemperatures.dailyTemperaturesUP(temperatures);
        for (int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
