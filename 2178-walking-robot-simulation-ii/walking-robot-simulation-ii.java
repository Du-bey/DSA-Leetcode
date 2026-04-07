class Robot {
    List<int[]> pos = new ArrayList<>();
    boolean move = false;
    int ind;

    public Robot(int width, int height) {
        ind = 0;

        for(int x = 0;x <width;x++){
            pos.add(new int[]{x, 0, 0});
        }

        for(int y = 1; y < height; y++){
            pos.add(new int[]{width - 1, y, 1});
        }

        for(int x = width - 2 ;x >= 0;x--){
            pos.add(new int[]{x, height - 1, 2});
        }

        for(int y = height - 2; y > 0; y--){
            pos.add(new int[]{0, y, 3});
        }

        pos.get(0)[2] = 3;
    }
    
    public void step(int num) {
        move = true;
        ind = ind + num;
        ind %= pos.size();
    }
    
    public int[] getPos() {
        int[] p = pos.get(ind);
        return new int[]{p[0], p[1]};
    }
    
    public String getDir() {
        if(!move) return "East";

        int d = pos.get(ind)[2];
        if(d == 0) return "East";
        if(d == 1) return "North";
        if(d == 2) return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */