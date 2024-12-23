class ParkingSystem {
    int b;
    int m;
    int s;
    int bs = 0, ms = 0, ss = 0;
    public ParkingSystem(int big, int medium, int small) {
        b = big;
        m = medium;
        s = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
            if(bs == b) return false;
            bs++;
        }
        else if(carType == 2){
            if(ms == m) return false;
            ms++;
        }
        else{
            if(ss == s) return false;
            ss++;
        }
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */