package pkg282project3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// demonstrates shortest path with weighted, directed graphs
// to run this program: C>java PathApp
////////////////////////////////////////////////////////////////
public class PathApp {

    public static void main(String[] args) throws IOException {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');     // 0  (start)
        theGraph.addVertex('B');     // 1
        theGraph.addVertex('C');     // 2
        theGraph.addVertex('D');     // 3
        theGraph.addVertex('E');     // 4

        theGraph.addEdge(0, 1, 50);  // AB 50
        theGraph.addEdge(0, 3, 80);  // AD 80
        theGraph.addEdge(1, 2, 60);  // BC 60
        theGraph.addEdge(1, 3, 90);  // BD 90
        theGraph.addEdge(2, 4, 40);  // CE 40
        theGraph.addEdge(3, 2, 20);  // DC 20
        theGraph.addEdge(3, 4, 70);  // DE 70
        theGraph.addEdge(4, 1, 50);  // EB 50

        while (true) {

            System.out.print("Enter first letter of the menue: \n");

            System.out.print("Change the weight, Add, Delete, Find path(s), Read, Write, or Quit: ");

            char choice = getChar();

            switch (choice) {

                case 'c':

                    System.out.println("Please enter a 'from' vertex: ");
                    char vertexF = getChar();
                    int F = getCharForNumber(vertexF);

                    System.out.println("Please enter a 'to' vertex: ");
                    char vertexT = getChar();
                    int T = getCharForNumber(vertexT);

                    if (theGraph.hasPath(F, T)) {

                        System.out.println("Please enter a new weight for that edge: ");
                        int weight = getInt();
                        theGraph.addEdge(F, T, weight);
                    } else {
                        break;
                    }
                case 'a':
                    System.out.println("Please enter a 'from' vertex: ");
                    char vtexF = getChar();
                    int vF = getCharForNumber(vtexF);

                    System.out.println("Please enter a 'to' vertex: ");
                    char vtexT = getChar();
                    int vT = getCharForNumber(vtexT);

                    if (theGraph.hasPath(vF, vT) == false) {

                        System.out.println("Please enter a new weight for that edge: ");
                        int weight = getInt();
                        theGraph.addEdge(vF, vT, weight);
                    }

                    break;

                case 'd':

                    System.out.println("Please enter a 'from' vertex: ");
                    char verF = getChar();
                    int veF = getCharForNumber(verF);

                    System.out.println("Please enter a 'to' vertex: ");
                    char verT = getChar();
                    int veT = getCharForNumber(verT);

                    theGraph.addEdge(veF, veT, 1000000);

                    System.out.println("Edge from vertex " + verF + " to " + verT
                            + " has been deleted");

                    break;
                case 'f':
                    System.out.println("Which vertex you wish to find? ");
                    char find = getChar();
                    int findit = getCharForNumber(find);
                    theGraph.findvertex(findit);

                    break;
                case 'r':
                    
                case 'w':
                    
                case 'q':
                    System.exit(0);
                    break;
                default:

                    System.out.print("Invalid entry\n");
            }

            System.out.println("Shortest paths");
            theGraph.path();             // shortest paths
            System.out.println();
        }  // end main()
    }  // end class PathApp
////////////////////////////////////////////////////////////////

    public static char getChar() throws IOException {

        String s = getString();

        return s.charAt(0);

    }

    public static String getString() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();

        return s;

    }

    public static int getInt() throws IOException {

        String s = getString();

        return Integer.parseInt(s);

    }

    private static int getCharForNumber(char i) {
        switch (i) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
        }

        return 0;
    }
}
