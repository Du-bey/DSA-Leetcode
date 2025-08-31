class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] ans = new int[n];
        int j = 0;
        int i = 0;
        boolean skip = false;

        while(i < n){
            if(ans[j] == 0){
                if(skip == false){
                    ans[j] = deck[i];
                    i++;
                }
                skip = !skip;
            }
            j = (j+1) % n;
        }
        return ans;
    }
}