/*
   Disjoint Set | Union by size:
   This is as same as the Union by rank method except this method uses the size to compare the components while connecting. That is why we need a ‘size’ array of size N(no. of nodes) instead of a rank array. The size array will be storing the size for each particular node i.e. size[i] will be the size of the component starting from node i.
   
   Typically, the size of a node refers to the number of nodes that are connected to it.
   
   Algorithm:
   
   Initial configuration:
   
   size array: This array is initialized with one.
   
   parent array: The array is initialized with the value of nodes i.e. parent[i] = i.
   
   The algorithm steps are as follows:
   
   Firstly, the Union function requires two nodes(let’s say u and v) as arguments. Then we will find the ultimate parent (using the findPar() function discussed earlier) of u and v. Let’s consider the ultimate parent of u is pu and the ultimate parent of v is pv.
   After that, we will find the size of pu and pv i.e. size[pu] and size[pv].
   Finally, we will connect the ultimate parent with a smaller size to the other ultimate parent with a larger size. But if the size of the two is equal, we can connect any parent to the other parent.
   While connecting in both cases we will increase the size of the parent node to whom we have connected by the size of the other parent node which is actually connected.
   Let’s understand it further using the below example. 
   
   Given the edges of a graph are {{1,2}, {2,3}, {4,5}, {6,7}, {5,6}, {3,7}}
   
   
   After applying the union by size function to every edge the graph and the arrays will look like the following:
   
   
   Note: It seems much more intuitive than union by rank as the rank gets distorted after path compression.
   
   Note: The findPar() function remains the exact same as we have discussed earlier.
   
   Note: If you wish to see the dry run of the above approach, you can watch the video attached to this article.
   
   Disjoint Set data structure implementation:
   
*/

class DisjointSet{
    int[] size, parent;
    // Constructor
    DisjointSet(int n){
        size = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    // find Ultimate Parent
    public int findUPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Unioun by Rank
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = parent[ulp_v];
            size[ulp_v] += size[ulp_u];
        }
        else{
            parent[ulp_v] = parent[ulp_u];
            size[ulp_u] += size[ulp_v];
        }
    }
}

public class Disjoint_Set_Union_by_Size {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // Check Wheather 3 & 7 is from same Component or not
        if(ds.findUPar(3) == ds.findUPar(7)){
            System.out.println("Yes, 3 & 7 Belongs to the Same Component!");
        }
        else System.out.println("No, it doesn't belongs to the same Component!");

        ds.unionBySize(3, 7);

        // Now Again, Check Wheather 3 & 7 is from same Component or not
        if(ds.findUPar(3) == ds.findUPar(7)){
            System.out.println("Yes, 3 & 7 Belongs to the Same Component!");
        }
        else System.out.println("No, it doesn't belongs to the same Component!");
    }
}
