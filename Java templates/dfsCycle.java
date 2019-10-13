 static boolean dfs(HashMap<Integer,HashSet<Integer>> graph,HashSet<Integer> visited,int calling,int called,Stack<Integer> current)
    {
        visited.add(called);
        current.add(called);


        for(int vertex:graph.get(called))
        {
            if(!visited.contains(vertex))
            {
                boolean result=dfs(graph,visited,called,vertex,current);
                if(result==true)
                {
                    return true;
                }
            }
            else if(vertex!=calling)
            {
                current.add(vertex);
                return true;
            }

        }
        return false;
    }