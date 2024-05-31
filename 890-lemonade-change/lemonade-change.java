class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i =0;i<bills.length;i++){
            if(bills[i] == 5){
                five++;
            }
            else if(bills[i] == 10){
                five--;
                ten++;
            }
            else if(bills[i] == 20){
                five--;
                if(ten > 0) ten--;
                else if(five >1){
                    five = five -2;
                }
                else{return false;}
            }
            if(five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }
}