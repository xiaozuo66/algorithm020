class Trie {

    private boolean isWord;
    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        isWord=false;
        next=new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node=this;
        char []temp=word.toCharArray();
        for(char c:temp){
            if(node.next[c-'a']==null){
                node.next[c-'a']=new Trie();
            }
            node=node.next[c-'a'];
        }
        node.isWord=true;
        return;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node=this;
        char[] temp=word.toCharArray();
        for(char c:temp){
            if(node.next[c-'a']==null){
                return false;
            }
            node=node.next[c-'a'];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node=this;
        char[] temp=prefix.toCharArray();
        for(char c:temp){
            if(node.next[c-'a']==null){
                return false;
            }
            node=node.next[c-'a'];
        }
        return node!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */