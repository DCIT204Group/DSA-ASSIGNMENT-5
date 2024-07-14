/* 
import java.util.List;
import java.util.Scanner;

public class AlgorithmTester {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select an algorithm to test:");
            System.out.println("1. QuickSort");
            System.out.println("2. MergeSort");
            System.out.println("3. Closest-Pair Problem");
            System.out.println("4. Strassen’s Matrix Multiplication");
            System.out.println("5. Quickhull (Convex Hull)");
            System.out.println("6. Prim’s Minimum Spanning Tree (MST)");
            System.out.println("7. Traveling Salesman Problem (Approximate Solution)");
            System.out.println("8. Kruskal’s MST");
            System.out.println("9. Dijkstra’s Shortest Path");
            System.out.println("10. Huffman Codes");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    testQuickSort();
                    break;
                case 2:
                    testMergeSort();
                    break;
                case 3:
                    testClosestPair();
                    break;
                case 4:
                    testStrassenMatrixMultiplication();
                    break;
                case 5:
                    testQuickhull();
                    break;
                case 6:
                    testPrimMST();
                    break;
                case 7:
                    testTSPApprox();
                    break;
                case 8:
                    testKruskalMST();
                    break;
                case 9:
                    testDijkstraShortestPath();
                    break;
                case 10:
                    testHuffmanCodes();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void testQuickSort() {
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void testMergeSort() {
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void testClosestPair() {
        System.out.println("Enter the number of points:");
        int n = scanner.nextInt();
        ClosestPair.Point[] points = new ClosestPair.Point[n];
        System.out.println("Enter the coordinates of the points:");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new ClosestPair().new Point(x, y);
        }

        ClosestPair closestPair = new ClosestPair();
        double distance = closestPair.findClosestPair(points);
        System.out.println("Closest distance: " + distance);
    }

    private static void testStrassenMatrixMultiplication() {
        System.out.println("Enter the dimension of the matrices (n x n):");
        int n = scanner.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        System.out.println("Enter the elements of matrix A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter the elements of matrix B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        StrassenMatrixMultiplication smm = new StrassenMatrixMultiplication();
        int[][] result = smm.multiply(A, B);

        System.out.println("Resultant matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void testQuickhull() {
        System.out.println("Enter the number of points:");
        int n = scanner.nextInt();
        Quickhull.Point[] points = new Quickhull.Point[n];
        System.out.println("Enter the coordinates of the points:");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Quickhull().new Point(x, y);
        }

        Quickhull quickhull = new Quickhull();
        List<Quickhull.Point> hull = quickhull.quickHull(points);

        System.out.println("Points in the convex hull:");
        for (Quickhull.Point point : hull) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }

    private static void testPrimMST() {
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        PrimMST primMST = new PrimMST();
        int[] mst = primMST.primMST(graph);

        System.out.println("Minimum Spanning Tree (Parent Array):");
        for (int i = 1; i < V; i++) {
            System.out.println("Parent of " + i + " is " + mst[i]);
        }
    }

    private static void testTSPApprox() {
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the starting vertex:");
        int start = scanner.nextInt();

        TSPApprox tspApprox = new TSPApprox();
        List<Integer> path = tspApprox.tspApprox(graph, start);

        System.out.println("Approximate TSP path:");
        for (int vertex : path) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }

    private static void testKruskalMST() {
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();

        KruskalMST kruskalMST = new KruskalMST();
        KruskalMST.Edge[] edges = new KruskalMST.Edge[E];
        System.out.println("Enter the edges (source, destination, weight):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            edges[i] = kruskalMST.new Edge(src, dest, weight);
        }

        KruskalMST.Edge[] mst = kruskalMST.kruskalMST(edges, V);

        System.out.println("Minimum Spanning Tree (Edges):");
        for (KruskalMST.Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight);
        }
    }

    private static void testDijkstraShortestPath() {
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the source vertex:");
        int src = scanner.nextInt();

        DijkstraShortestPath dsp = new DijkstraShortestPath();
        int[] dist = dsp.dijkstra(graph, src);

        System.out.println("Shortest path distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + ": " + dist[i]);
        }
    }

    private static void testHuffmanCodes() {
        System.out.println("Enter the number of characters:");
        int n = scanner.nextInt();
        char[] charArray = new char[n];
        int[] charFreq = new int[n];
        System.out.println("Enter the characters and their frequencies:");
        for (int i = 0; i < n; i++) {
            charArray[i] = scanner.next().charAt(0);
            charFreq[i] = scanner.nextInt();
        }

        HuffmanCodes huffmanCodes = new HuffmanCodes();
        huffmanCodes.buildHuffmanTree(charArray, charFreq);
    }
}
*/

import java.util.*;

public class AlgorithmTester {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                switch (choice) {
                    case 1: testQuickSort(); break;
                    case 2: testMergeSort(); break;
                    case 3: testClosestPair(); break;
                    case 4: testStrassenMatrixMultiplication(); break;
                    case 5: testQuickhull(); break;
                    case 6: testPrimMST(); break;
                    case 7: testTSPApprox(); break;
                    case 8: testKruskalMST(); break;
                    case 9: testDijkstraShortestPath(); break;
                    case 10: testHuffmanCodes(); break;
                    case 0: System.exit(0);
                    default: System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Clear invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nSelect an algorithm to test:");
        System.out.println("1. QuickSort");
        System.out.println("2. MergeSort");
        System.out.println("3. Closest-Pair Problem");
        System.out.println("4. Strassen’s Matrix Multiplication");
        System.out.println("5. Quickhull (Convex Hull)");
        System.out.println("6. Prim’s Minimum Spanning Tree (MST)");
        System.out.println("7. Traveling Salesman Problem (Approximate Solution)");
        System.out.println("8. Kruskal’s MST");
        System.out.println("9. Dijkstra’s Shortest Path");
        System.out.println("10. Huffman Codes");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void testQuickSort() {
        try {
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Array size must be greater than zero.");
                return;
            }
            int[] array = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            QuickSort quickSort = new QuickSort();
            quickSort.sort(array);

            System.out.println("Sorted array:");
            System.out.println(Arrays.toString(array));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void testMergeSort() {
        try {
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Array size must be greater than zero.");
                return;
            }
            int[] array = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            MergeSort mergeSort = new MergeSort();
            mergeSort.sort(array);

            System.out.println("Sorted array:");
            System.out.println(Arrays.toString(array));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void testClosestPair() {
        try {
            System.out.print("Enter the number of points: ");
            int n = scanner.nextInt();
            if (n <= 1) {
                System.out.println("There must be at least two points.");
                return;
            }
            ClosestPair.Point[] points = new ClosestPair.Point[n];
            System.out.println("Enter the coordinates of the points:");
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                points[i] = new ClosestPair().new Point(x, y);
            }

            ClosestPair closestPair = new ClosestPair();
            double distance = closestPair.findClosestPair(points);
            System.out.println("Closest distance: " + distance);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void testStrassenMatrixMultiplication() {
        try {
            System.out.print("Enter the dimension of the matrices (n x n): ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Matrix dimension must be greater than zero.");
                return;
            }
            int[][] A = new int[n][n];
            int[][] B = new int[n][n];
            System.out.println("Enter the elements of matrix A:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Enter the elements of matrix B:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    B[i][j] = scanner.nextInt();
                }
            }

            StrassenMatrixMultiplication smm = new StrassenMatrixMultiplication();
            int[][] result = smm.multiply(A, B);

            System.out.println("Resultant matrix:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void testQuickhull() {
        try {
            System.out.print("Enter the number of points: ");
            int n = scanner.nextInt();
            if (n <= 1) {
                System.out.println("There must be at least two points.");
                return;
            }
            Quickhull.Point[] points = new Quickhull.Point[n];
            System.out.println("Enter the coordinates of the points:");
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                points[i] = new Quickhull().new Point(x, y);
            }

            Quickhull quickhull = new Quickhull();
            List<Quickhull.Point> hull = quickhull.quickHull(points);

            System.out.println("Points in the convex hull:");
            for (Quickhull.Point point : hull) {
                System.out.println("(" + point.x + ", " + point.y + ")");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void testPrimMST() {
        try {
            System.out.print("Enter the number of vertices: ");
            int V = scanner.nextInt();
            if (V <= 0) {
                System.out.println("Number of vertices must be greater than zero.");
                return;
            }
            int[][] graph = new int[V][V];
            System.out.println("Enter the adjacency matrix:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph[i][j] = scanner.nextInt();
                }
            }

            PrimMST primMST = new PrimMST();
            int[] mst = primMST.primMST(graph);

            System.out.println("Minimum Spanning Tree (Parent Array):");
            for (int i = 1; i < V; i++) {
                System.out.println("Parent of " + i + " is " + mst[i]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void testTSPApprox() {
        try {
            System.out.print("Enter the number of vertices: ");
            int V = scanner.nextInt();
            if (V <= 1) {
                System.out.println("There must be at least two vertices.");
                return;
            }
            int[][] graph = new int[V][V];
            System.out.println("Enter the adjacency matrix:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Enter the starting vertex: ");
            int start = scanner.nextInt();
            if (start < 0 || start >= V) {
                System.out.println("Invalid starting vertex.");
                return;
            }

            TSPApprox tspApprox = new TSPApprox();
            List<Integer> path = tspApprox.tspApprox(graph, start);

            System.out.println("Approximate TSP path:");
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void testKruskalMST() {
        try {
            System.out.print("Enter the number of vertices: ");
            int V = scanner.nextInt();
            if (V <= 1) {
                System.out.println("There must be at least two vertices.");
                return;
            }
            System.out.print("Enter the number of edges: ");
            int E = scanner.nextInt();
            if (E <= 0) {
                System.out.println("Number of edges must be greater than zero.");
                return;
            }

            KruskalMST kruskalMST = new KruskalMST();
            KruskalMST.Edge[] edges = new KruskalMST.Edge[E];
            System.out.println("Enter the edges (source, destination, weight):");
            for (int i = 0; i < E; i++) {
                int src = scanner.nextInt();
                int dest = scanner.nextInt();
                int weight = scanner.nextInt();
                edges[i] = kruskalMST.new Edge(src, dest, weight);
            }

            KruskalMST.Edge[] mst = kruskalMST.kruskalMST(edges, V);

            System.out.println("Minimum Spanning Tree (Edges):");
            for (KruskalMST.Edge edge : mst) {
                System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void testDijkstraShortestPath() {
        try {
            System.out.print("Enter the number of vertices: ");
            int V = scanner.nextInt();
            if (V <= 0) {
                System.out.println("Number of vertices must be greater than zero.");
                return;
            }
            int[][] graph = new int[V][V];
            System.out.println("Enter the adjacency matrix:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Enter the source vertex: ");
            int src = scanner.nextInt();
            if (src < 0 || src >= V) {
                System.out.println("Invalid source vertex.");
                return;
            }

            DijkstraShortestPath dsp = new DijkstraShortestPath();
            int[] dist = dsp.dijkstra(graph, src);

            System.out.println("Shortest path distances from source:");
            for (int i = 0; i < V; i++) {
                System.out.println("To " + i + ": " + dist[i]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void testHuffmanCodes() {
        try {
            System.out.print("Enter the number of characters: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Number of characters must be greater than zero.");
                return;
            }
            char[] charArray = new char[n];
            int[] charFreq = new int[n];
            System.out.println("Enter the characters and their frequencies:");
            for (int i = 0; i < n; i++) {
                charArray[i] = scanner.next().charAt(0);
                charFreq[i] = scanner.nextInt();
            }

            HuffmanCodes huffmanCodes = new HuffmanCodes();
            huffmanCodes.buildHuffmanTree(charArray, charFreq);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid characters and integers.");
            scanner.nextLine();  // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
