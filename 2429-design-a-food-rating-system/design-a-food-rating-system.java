class FoodRatings {
    Map<String, Integer> food_rating = new HashMap<>();
    Map<String, TreeSet<Pair<Integer, String>>> cuisine_rating_food = new HashMap<>();
    Map<String, String> food_cuisine = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i = 0;i<n;i++){
            String food = foods[i];
            String cuisine = cuisines[i];
            int rat = ratings[i];

            food_rating.put(food, rat);
            food_cuisine.put(food, cuisine);
            cuisine_rating_food
                .computeIfAbsent(cuisine, k -> new TreeSet<>((a, b) -> {
                    int compareByRating = Integer.compare(a.getKey(), b.getKey());
                    if (compareByRating == 0) {
                        return a.getValue().compareTo(b.getValue());
                    }
                    return compareByRating;
                }))
                .add(new Pair(-rat, food));
        }
    }
    
    public void changeRating(String food, int newRating) {
        int old = food_rating.get(food);
        food_rating.put(food, newRating);

        String cuisine = food_cuisine.get(food);
        TreeSet<Pair<Integer, String>> rating_food = cuisine_rating_food.get(cuisine);
        Pair<Integer, String> oldElement = new Pair<>(-old, food);
        rating_food.remove(oldElement);
        rating_food.add(new Pair<>(-newRating, food));
    }
    
    public String highestRated(String cuisine) {
        Pair<Integer, String> rating_food = cuisine_rating_food.get(cuisine).first();
        return rating_food.getValue();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */