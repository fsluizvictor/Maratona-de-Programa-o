package aed2praticas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Pontes {

    static class Graph {

        private int V;   // No. of vertices 

        // Array  of lists for Adjacency List Representation 
        private LinkedList<Integer> adj[];

        // Constructor 
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList();
            }
        }

        //Function to add an edge into the graph 
        void addEdge(int v, int w) {
            v--;
            w--;
            adj[v].add(w);// Add w to v's list. 
            adj[w].add(v); //The graph is undirected 
        }

        // A function used by DFS 
        void DFSUtil(int v, boolean visited[]) {
            // Mark the current node as visited 
            visited[v] = true;

            // Recur for all the vertices adjacent to this vertex 
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }
        }

        // Method to check if all non-zero degree vertices are 
        // connected. It mainly does DFS traversal starting from 
        boolean isConnected() {
            // Mark all the vertices as not visited 
            boolean visited[] = new boolean[V];
            int i;
            for (i = 0; i < V; i++) {
                visited[i] = false;
            }

            // Find a vertex with non-zero degree 
            for (i = 0; i < V; i++) {
                if (adj[i].size() != 0) {
                    break;
                }
            }

            // If there are no edges in the graph, return true 
            if (i == V) {
                return true;
            }

            // Start DFS traversal from a vertex with non-zero degree 
            DFSUtil(i, visited);

            // Check if all non-zero degree vertices are visited 
            for (i = 0; i < V; i++) {
                if (visited[i] == false && adj[i].size() > 0) {
                    return false;
                }
            }

            return true;
        }

        /* The function returns one of the following values 
       0 --> If grpah is not Eulerian 
       1 --> If graph has an Euler path (Semi-Eulerian) 
       2 --> If graph has an Euler Circuit (Eulerian)  */
        int isEulerian() {
            // Check if all non-zero degree vertices are connected 
            if (isConnected() == false) {
                return 0;
            }

            // Count vertices with odd degree 
            int odd = 0;
            for (int i = 0; i < V; i++) {
                if (adj[i].size() % 2 != 0) {
                    odd++;
                }
            }

            // If count is more than 2, then graph is not Eulerian 
            if (odd > 2) {
                return 0;
            }

            // If odd count is 2, then semi-eulerian. 
            // If odd count is 0, then eulerian 
            // Note that odd count can never be 1 for undirected graph 
            return (odd == 2) ? 1 : 2;
        }
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int qtd = -1;
        int nPontes = -1;

        do {

            qtd = leia.nextInt();
            nPontes = leia.nextInt();

            Graph g = new Graph(qtd);

            for (int i = 0; i < nPontes; i++) {
                g.addEdge(leia.nextInt(), leia.nextInt());
            }

            int cont = 0;
            int par = 0, impar = 0;
            for (LinkedList lista : g.adj) {
                if (lista.size() == nPontes) {
                    cont++;
                }
                System.out.println(lista.size());
                if (lista.size() % 2 == 0) {
                    par++;
                } else {
                    impar++;
                }

            }

            System.out.println("Par:" + par);
            System.out.println("Impar:" + impar);
            System.out.println(cont);

            if ((g.isEulerian() == 1 || g.isEulerian() == 2) && cont == qtd) {
                System.out.println("S");
            } else {
                System.out.println("N");
            }

        } while (leia.hasNextInt());
    }
}
