static class TrieNode{
        HashMap<Character,TrieNode> characters;
        boolean isEndOfWord;

        TrieNode()
        {
            this.characters=new HashMap<>();
            isEndOfWord=false;
        }
    }

    static  class TrieImplementation{
        TrieNode root;

        TrieImplementation()
        {
            root=new TrieNode();
        }

        void insert(String s)
        {
            TrieNode temp=root;
            for(int i=0;i<s.length();i++)
            {
                if(temp.characters.containsKey(s.charAt(i)))
                    temp=temp.characters.get(s.charAt(i));
                else
                {
                    temp.characters.put(s.charAt(i),new TrieNode());
                    temp=temp.characters.get(s.charAt(i));
                }
            }
            temp.isEndOfWord=true;
        }
        void bfs()
        {
            TrieNode temp=root;
            Queue<TrieNode> neighbours=new ArrayDeque<>();
            neighbours.add(root);
            while (!neighbours.isEmpty())
            {
                TrieNode toBeVisited=neighbours.poll();
                for(char c: toBeVisited.characters.keySet())
                {
                    System.out.print(c + " " );
                    neighbours.add(toBeVisited.characters.get(c));
                }
                System.out.println();
            }

        }

        boolean doesPrefixExist(String s)
        {
               TrieNode temp=root;
               for(int i=0;i<s.length();i++)
               {
                   if(temp.characters.containsKey(s.charAt(i)))
                       temp=temp.characters.get(s.charAt(i));
                   else
                       return false;
               }
               return true;
        }

        boolean doesWordExist(String s)
        {
            TrieNode temp=root;
            for(int i=0;i<s.length();i++)
            {
                if(temp.characters.containsKey(s.charAt(i)))
                    temp=temp.characters.get(s.charAt(i));
                else
                    return false;
            }
            if(temp.isEndOfWord)
                return true;
            else
                return false;
        }

        void delete(String word)
        {
          deleteHelper(root,word,0);
        }

        private boolean deleteHelper(TrieNode current, String word, int index) {
            if (index == word.length()) {
                //when end of word is reached only delete if currrent.endOfWord is true.
                if (!current.isEndOfWord) {
                    return false;
                }
                current.isEndOfWord = false;
                //if current has no other mapping then return true
                return current.characters.size() == 0;
            }
            char ch = word.charAt(index);
            TrieNode node = current.characters.get(ch);
            if (node == null) {
                return false;
            }
            boolean shouldDeleteCurrentNode = deleteHelper(node, word, index + 1);

            //if true is returned then delete the mapping of character and trienode reference from map.
            if (shouldDeleteCurrentNode) {
                current.characters.remove(ch);
                //return true if no mappings are left in the map.
                return current.characters.size() == 0;
            }
            return false;
        }
    }
    