package io.github.joseguzmann.dsaimplementation;

/**
 * @author Jose Guzman
 */

public class Graphs {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertice('A');    // 0
        theGraph.addVertice('B');    // 1
        theGraph.addVertice('C');    // 2
        theGraph.addVertice('D');    // 3
        theGraph.addVertice('E');    // 4
        theGraph.addVertice('F');    // 5
        theGraph.addVertice('G');    // 6
        theGraph.addVertice('H');    // 7

        theGraph.addEdge(0, 3);     // AD
        theGraph.addEdge(0, 4);     // AE
        theGraph.addEdge(1, 4);     // BE
        theGraph.addEdge(2, 5);     // CF
        theGraph.addEdge(3, 6);     // DG
        theGraph.addEdge(4, 6);     // EG
        theGraph.addEdge(5, 7);     // FH
        theGraph.addEdge(6, 7);     // GH

        theGraph.topo();            // do the sort

        System.out.println("Fin");
    }

    static class Vertice {
        public char label;
        public Vertice(char label) {
            this.label = label;
        }
    }

    public static class Graph {
        private final int MAX_VERTS = 20;
        private Vertice[] listaVertices;
        private int[][] adjMat;
        private int nVerts;
        private char[] sortedArray;

        public Graph() {
            listaVertices =  new Vertice[MAX_VERTS];
            adjMat = new int[MAX_VERTS][MAX_VERTS];
            nVerts = 0;
            sortedArray = new char[MAX_VERTS];
            for(int i = 0; i < MAX_VERTS; i++) {
                for(int j = 0; j < MAX_VERTS; j++) {
                    adjMat[i][j] = 0;
                }
            }
        }

        //AddVertex
        public void addVertice(char c) {
            listaVertices[nVerts] = new Vertice(c);
            nVerts++;
        }

        //AddEdge
        public void addEdge(int i1, int i2) {
            adjMat[i1][i2] = 1;
        }

        //DisplayVertex
        public void displayVertice(int i) {
            System.out.print(listaVertices[i].label);
        }

        public void topo() {
            int orig_nVerts = nVerts;  // remember how many verts

            while(nVerts > 0)  // while vertices remain,
            {
                // get a vertex with no successors, or -1
                int currentVertex = noSuccessors();
                if(currentVertex == -1)       // must be a cycle
                {
                    System.out.println("ERROR: Graph has cycles");
                    return;
                }
                // insert vertex label in sorted array (start at end)
                sortedArray[nVerts-1] = listaVertices[currentVertex].label;

                deleteVertex(currentVertex);  // delete vertex
            }  // end while

            // vertices all gone; display sortedArray
            System.out.print("Topologically sorted order: ");
            for(int j=0; j<orig_nVerts; j++)
                System.out.print( sortedArray[j] );
            System.out.println("");
        }

        public int noSuccessors() {
            boolean isEdge = false;

            for(int row = 0; row < nVerts; row++) {
                isEdge = false;
                for(int col = 0; col < nVerts; col++) {
                    if(adjMat[row][col] > 0) {
                        isEdge = true;
                        break;
                    }
                }
                if(!isEdge) {
                    return row;
                }
            }
            return -1;
        }

        public void deleteVertex(int delVert) {
            if(delVert != nVerts - 1) {
                for(int i = delVert; i < nVerts - 1; i++) {
                    listaVertices[i] = listaVertices[i + 1];
                }
                for(int row=delVert; row<nVerts-1; row++)
                    moveRowUp(row, nVerts);
                // delete col from adjMat
                for(int col=delVert; col<nVerts-1; col++)
                    moveColLeft(col, nVerts-1);
            }
        }

        public void moveRowUp(int row, int length) {
            for(int col = 0; col < length; col++) {
                adjMat[row][col] = adjMat[row + 1][col];
            }
        }

        public void moveColLeft(int col, int length) {
            for(int row = 0; row < length; row++) {
                adjMat[row][col] = adjMat[row][col + 1];
            }
        }
    }

}
