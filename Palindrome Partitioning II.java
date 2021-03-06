public class Solution {
    public int minCut(String s) {
        int n = s.length();
        // Use dp to get all the palindrome 
        ArrayList<ArrayList<Integer>> prevsList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> curPrevs = new ArrayList<Integer>();
            prevsList.add(curPrevs);
            curPrevs.add(i);
            if (i > 0) {
                if (s.charAt(i - 1) == s.charAt(i))
                    curPrevs.add(i - 1);
                for (int prev : prevsList.get(i - 1)) {
                    if (prev > 0 && s.charAt(prev - 1) == s.charAt(i))
                        curPrevs.add(prev - 1);
                }
            }
        }
        // Use dp to get the min dist. could also use bfs.
        int[] minCuts = new int[n];
        int min;
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int prevIndex : prevsList.get(i)) {
                if (prevIndex > 0) {
                    min = Math.min(min, minCuts[prevIndex - 1] + 1);
                } else {
                    min = 0;
                }
            }
            minCuts[i] = min;
        }
        return minCuts[n - 1];
    }
}