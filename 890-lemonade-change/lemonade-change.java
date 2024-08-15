class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0;
        int ten = 0;
        for(int x : bills){
            if(x == 5){
                five++;
            }
            else if(x == 10){
                if(five == 0){
                    return false;
                }
                ten++;
                five--;
            }
            else{
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}