class MagicDictionary {
    Set<String> h;
    public MagicDictionary() {
        h = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s : dictionary){
            h.add(s);
        }
    }
    
    public boolean search(String searchWord) {
        int n = searchWord.length();
        char[] c = searchWord.toCharArray();
        for(int i =0;i<n;i++){
            char oc = c[i]; 
            for(char ch = 'a'; ch <= 'z'; ch++){
                if(ch == oc) continue;
                c[i] = ch;
                String news = new String(c);
                if(h.contains(news)) return true;
            }
            c[i] = oc;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */