class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        for(int i=0; i<n; i++){            
            prices[i] = getDiscount(prices, i, n);         
        }

        return prices;
    }

    int getDiscount(int[] prices, int i, int n){        
        for(int j=i+1; j<n; j++){
            if(prices[j]<=prices[i]){                
                return prices[i]-prices[j];
            }
        }

        return prices[i];
    }
}