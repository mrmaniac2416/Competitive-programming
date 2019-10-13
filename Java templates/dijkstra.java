static void dijkstra(HashMap<Integer,HashSet<Pair>> graph,int distances[],int source,int parent[])
{
    PriorityQueue<Pair> pq=new PriorityQueue<>();
    for(int i=1;i<=graph.size();i++)
    {
        distances[i]=Integer.MAX_VALUE;
    }
    distances[source]=0;
    pq.add(new Pair(source,0));
    parent[source]=source;
    HashSet<Integer> visited=new HashSet<>();


    while (!pq.isEmpty())
    {
      
        int vertexToBeVisited=(int)pq.poll().vertex;
          if(visited.contains(vertexToBeVisited))
                continue;
            visited.add(vertexToBeVisited);

        for(Pair vertex:graph.get(vertexToBeVisited))
        {
            if(distances[vertexToBeVisited]!=Integer.MAX_VALUE && distances[vertex.vertex]>distances[vertexToBeVisited]+vertex.weight)
            {
                distances[(int)vertex.vertex]= (int) (distances[vertexToBeVisited]+vertex.weight);
                pq.add(new Pair(vertex.vertex,distances[vertex.vertex]));
                parent[(int)vertex.vertex]=vertexToBeVisited;
            }
        }
    }
}



    public static class Pair implements Comparable<Pair> {
        int vertex;
        int weight;

        public Pair(int  vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }


        public int hashCode() {
            int hu = (int) (vertex ^ (vertex >>> 32));
            int hv = (int) (weight ^ (weight >>> 32));
            return 31 * hu + hv;
        }

        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return vertex == other.vertex && weight == other.weight;
        }

        public int compareTo(Pair other) {
            return Integer.compare(weight, other.weight) != 0 ? Integer.compare(weight, other.weight) : Integer.compare(vertex, other.vertex);
        }

        public String toString() {
            return "[vertex=" + vertex + ", weight=" + weight + "]";
        }
    }