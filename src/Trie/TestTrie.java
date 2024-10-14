package Trie;

public class TestTrie {

    public static void main(String[] args) {

        Trie trie = new Trie();

//        String[] operations = new String[]{"Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"};
//        String[][] values = new String[][]{{},{"app"},{"apple"},{"beer"},{"add"},{"jam"},{"rental"},{"apps"},{"app"},{"ad"},{"applepie"},{"rest"},{"jan"},{"rent"},{"beer"},{"jam"},{"apps"},{"app"},{"ad"},{"applepie"},{"rest"},{"jan"},{"rent"},{"beer"},{"jam"}};

        String[] operations = new String[]{"insert","insert","search","search","search"};
        String[][] values = new String[][]{{"app"},{"apple"},{"apps"},{"apple"},{"app"}};


        for (int i=0;i<operations.length;i++) {
            switch(operations[i]) {
                case "insert":
                    trie.insert(values[i][0]);
                    break;
                case "search":
                    System.out.println(trie.search(values[i][0]));
                    break;
                case "startsWith":
                    System.out.println(trie.startsWith(values[i][0]));
                    break;
            }
        }


    }

}
