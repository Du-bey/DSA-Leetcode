class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, beginWord));
        Set<String> set = new HashSet<>();
        for(int i=0;i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while(!q.isEmpty()){
            int t = q.peek().first;
            String s = q.peek().second;
            q.remove();
            int n = s.length();
            if(s.equals(endWord)) return t;
            for(int i =0;i<n;i++){
                char[] convertedArray = s.toCharArray();
                for(char c = 'a'; c<='z'; c++){
                    convertedArray[i] = c;
                    String convertedString = new String(convertedArray);
                    if(set.contains(convertedString)){
                        set.remove(convertedString);
                        q.add(new Pair(t+1, convertedString));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    int first;
    String second;

    public Pair(int first, String second){
        this.first = first;
        this.second = second; 
    }
}