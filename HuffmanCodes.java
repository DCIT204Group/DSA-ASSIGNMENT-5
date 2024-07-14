import java.util.PriorityQueue;

public class HuffmanCodes {
    class Node implements Comparable<Node> {
        int freq;
        char ch;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq) {
            this.freq = freq;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.freq, o.freq);
        }
    }

    public void buildHuffmanTree(char[] charArray, int[] charFreq) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i < charArray.length; i++) {
            queue.add(new Node(charArray[i], charFreq[i]));
        }

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node sum = new Node(left.freq + right.freq);
            sum.left = left;
            sum.right = right;
            queue.add(sum);
        }

        Node root = queue.poll();
        printCodes(root, "");
    }

    private void printCodes(Node root, String s) {
        if (root == null) {
            return;
        }
        if (root.ch != 0) {
            System.out.println(root.ch + ": " + s);
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }
}
