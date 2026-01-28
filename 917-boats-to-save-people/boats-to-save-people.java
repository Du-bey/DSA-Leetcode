class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;

        int i = 0;
        int j = n-1;
        int ans = 0;
        Arrays.sort(people);

        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
                
            }
            j--;
            ans++;
        }

        return ans;
    }
}