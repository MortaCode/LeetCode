package 贪心;

import java.util.Arrays;

public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0 || s == null || s.length == 0)
            return 0;
        int gLen = g.length, sLen = s.length;
        boolean[] used = new boolean[gLen];
        int cnt = 0;
        for (int i=0; i<gLen; i++){
            boolean flag = false;
            int idx = sLen;//初始化为sLen
            int value = Integer.MAX_VALUE;
            for (int j=0; j<sLen; j++){
                if (s[j]>=g[i] && used[j] == false){ //可满足
                    if (s[j] <= value){ //最小满足
                        idx = j;
                        value = s[j];
                    }
                    flag = true;
                }
            }
            if (flag){
                used[idx] = true;
                cnt++;
            }
        }
        return cnt;
    }

    public int findContentChildrenUp(int[] g, int[] s) {
        if(g == null || g.length == 0 || s == null || s.length == 0)
            return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int gLen = g.length, sLen = s.length;
        int cnt = 0;
        for (int i=0, j=0; i<gLen && j<sLen; i++,j++){
            while (j<sLen && g[i]>s[j]){j++;}
            if (j<sLen){cnt++;}
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{3,2,1};
        FindContentChildren findContentChildren = new FindContentChildren();
        System.out.println(findContentChildren.findContentChildrenUp(g,s));
    }
}
