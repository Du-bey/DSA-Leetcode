class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int chem = skill[0] + skill[n-1];
        long ans = 0;
        int j = n-1;
        int i = 0;
        while(i < j){
            ans += skill[i] * skill[j];
            if(skill[i] + skill[j] != chem) return -1;
            i++;
            j--;
        }
        return ans;
    }
}
