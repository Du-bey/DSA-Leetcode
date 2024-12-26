class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0, ten = 0;
        for(int i = 0;i<bills.length;i++){
            int num = bills[i];
            if(num == 5) five++;
            else if(num == 10){
                if(five == 0) return false;
                ten++;
                five--;
            }
            else{
                if(ten <= 0){
                    if(five < 3) return false;
                }
                else{
                    if(five < 1) return false;
                }
                if(ten > 0){
                    ten --;
                    five--;
                }
                else{
                    five -= 3;;
                }
            }
        }
        return true;
    }
}