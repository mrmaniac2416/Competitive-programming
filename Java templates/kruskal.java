 static void kruskal(HashMap<Integer,HashSet<Pair>> graph,HashMap<Integer,HashSet<Integer>> spanningTree,PriorityQueue<Edge> edges)
    {
              DisjointSet ds=new DisjointSet();
              for(int i=1;i<=graph.size();i++)
                  ds.makeSet(i);
              while (!edges.isEmpty())
              {
                  Edge e=edges.poll();
                  int start=e.start;
                  int end=e.end;
                  if(ds.findSet(start)!=ds.findSet(end))
                  {
                      spanningTree.get(start).add(end);
                      spanningTree.get(end).add(start);
                      ds.union(start,end);
                  }
              }
    }


     static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        Edge(int start,int end,int weight)
        {
            this.start=start;
            this.end=end;
            this.weight=weight;
        }

        public int compareTo(Edge o)
        {
            return Integer.compare(this.weight,o.weight);
        }
    }
    