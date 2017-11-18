 public static void dfs(HashMap<Integer,HashSet<Integer>> graph,int start,HashSet<Integer> visited)
    {
        visited.add(start);
        out.println(start);
        Iterator it=graph.get(start).iterator();


        while (it.hasNext())
        {
            int toBevisited=(int)it.next;
            if(!(visited.contains(toBevisited))
            dfs(graph,toBevisited,visited);
        }
    }