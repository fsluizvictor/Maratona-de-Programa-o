import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

class Node implements Comparable<Node> {
    private char symbol;
    private int count;

    private Node left;
    private Node right;

    public Node(char symbol) {
        this.symbol = symbol;
    }

    public Node(Node left, Node right) {
        this.symbol = '+';
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int getFrequency() {
        if (isLeaf())
            return count;
        return left.getFrequency() + right.getFrequency();
    }

    public char getSymbol() {
        return symbol;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void add() {
        count++;
    }

    @Override
    public int compareTo(Node o) {
        return getFrequency() - o.getFrequency();
    }

    @Override
    public String toString() {
        String ch = symbol == '\n' ? "\\n" : "" + symbol;

        return String.format("'%s': %d", ch, getFrequency());
    }

    public void fillCodeMap(Map<Character, String> codemap, String work) {
        if (isLeaf()) {
            codemap.put(getSymbol(), work);
            return;
        }

        left.fillCodeMap(codemap, work + "0");
        right.fillCodeMap(codemap, work + "1");
    }
}

class HuffmanTree {
    private Node root;

    private PriorityQueue<Node> countFrequencies(char[] letters) {
        Map<Character, Node> count = new HashMap<>();
        for (char ch : letters) {
            if (!count.containsKey((ch))) {
                count.put(ch, new Node(ch));
            }
            count.get(ch).add();
        }
        return new PriorityQueue<>(count.values());
    }

    private Node createTree(PriorityQueue<Node> nodes) {
        while (true) {

            // Remover nós do mais frequente para o menos frequente
            Node node1 = nodes.poll();
            Node node2 = nodes.poll();

            // Cria-se um nó parent com os dois nós
            Node parent = new Node(node1, node2);

            // se a fila estiver vazia o processo termina e retornamos o pai criado
            if (nodes.isEmpty()) {
                return parent;
            }

            // Se não readiciono o pai na lista
            nodes.add(parent);
        }
    }

    private Map<Character, String> createCodeMap() {
        Map<Character, String> result = new TreeMap<>();
        root.fillCodeMap(result, "");
        return result;
    }

    private char[] getChars(String text) {
        char[] letters = new char[text.length()];
        text.getChars(0, text.length(), letters, 0);
        return letters;
    }

    public String encode(String text) {
        char[] letters = getChars(text);
        root = createTree(countFrequencies(letters));
        Map<Character, String> codemap = createCodeMap();

        StringBuilder data = new StringBuilder();
        for (char ch : letters) {
            data.append(codemap.get(ch));
        }
        return data.toString();
    }

    public String decode(String data) {
        Node current = root;

        StringBuilder result = new StringBuilder();
        for (char ch : getChars(data)) {
            if (ch == '0') {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            if (current.isLeaf()) {
                result.append(current.getSymbol());
                current = root;
            }
        }
        return result.toString();
    }
}

public class arvore_huffman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String text = in.nextLine().trim();
        HuffmanTree tree = new HuffmanTree();
        String compressed = tree.encode(text);
        System.out.println(compressed);
        String descompressed = tree.decode(compressed);
        System.out.println(descompressed);
        // System.out.println(compressed.getBytes().length * 8 + " bits");

    }

}
