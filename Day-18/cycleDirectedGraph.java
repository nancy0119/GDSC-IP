// Link - https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
import java.util.*;
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[V];
        boolean dfsVisited[] = new boolean [V];
        for(int i = 0 ; i < V; i++){
            if(!visited[i]){
                if(dfs(adj, i, visited, dfsVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, boolean [] dfsVisited){
        visited[src] = true;
        dfsVisited[src] = true;
        for(int nbr : adj.get(src)){
            if(dfsVisited[nbr])return true;
            else if(!visited[nbr]){
                if(dfs(adj, nbr, visited, dfsVisited))
                return true;
            }
        }
        dfsVisited[src] = false;
        return false;
    }
}