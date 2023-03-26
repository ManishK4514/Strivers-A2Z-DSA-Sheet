/*
   Accounts Merge – DSU: G-50 -> LeetCode (https://leetcode.com/problems/accounts-merge/description/)
   Problem Statement: Given a list of accounts where each element account [ i ] is a list of strings, where the first element account [ i ][ 0 ]  is a name, and the rest of the elements are emails representing emails of the account.
   
   Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
   
   After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order.
   
   Note: Accounts themselves can be returned in any order.
   
   Pre-requisite: Disjoint Set data structure
   
   Examples:
   
   Example 1:
   Input: N = 4
   accounts [ ] =
   [["John","johnsmith@mail.com","john_newyork@mail.com"],
   ["John","johnsmith@mail.com","john00@mail.com"],
   ["Mary","mary@mail.com"],
   ["John","johnnybravo@mail.com"]]
   
   Output: [["John","john00@mail.com","john_newyork@mail.com", "johnsmith@mail.com"],
   ["Mary","mary@mail.com"],
   ["John","johnnybravo@mail.com"]]
   
   Explanation: The first and the second John are the same person as they have a common email. But the third Mary and fourth John are not the same as they do not have any common email.  The result can be in any order but the emails must be in sorted order. The following is also a valid result:
   [['Mary', 'mary@mail.com'],
   ['John', 'johnnybravo@mail.com'],
   ['John', 'john00@mail.com' , 'john_newyork@mail.com', 'johnsmith@mail.com' ]]
   
   Example 2:
   Input: N = 6
   accounts [ ] =
   [["John","j1@com","j2@com","j3@com"],
   ["John","j4@com"],
   ["Raj",”r1@com”, “r2@com”],
   ["John","j1@com","j5@com"],
   ["Raj",”r2@com”, “r3@com”],
   ["Mary","m1@com"]]
   
   Output: [["John","j1@com","j2@com","j3@com","j5@com"],
   ["John","j4@com"],
   ["Raj",”r1@com”, “r2@com”,  “r3@com”],
   ["Mary","m1@com"]]
   
   Explanation: The first and the fourth John are the same person here as they have a common email. And the third and the fifth Raj are also the same person. So, the same accounts are merged.
  
*/

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    // Union by Size
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

public class Accounts_merge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail, i);
                }
                else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }
        
        List<String>[] mergedMail = new ArrayList[n];
        for(int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();
        for(Map.Entry<String, Integer> it : mapMailNode.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            // Adding names to the starting
            mergedMail[i].add(0, accounts.get(i).get(0));
            res.add(mergedMail[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };

        List<List<String>> ans = accountsMerge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
        }
    }
}
