static boolean bellmanFord(HashMap<Integer,HashSet<Pair>> graph,int distances[],int parents[],int source)
    {
        int noOfVertices=graph.size();
        for(int i=1;i<=noOfVertices;i++)
            distances[i]=Integer.MAX_VALUE;
        distances[source]=0;
        parents[source]=source;
        for(int i=1;i<noOfVertices;i++)
        {
            for(int vertex:graph.keySet())
            {
                for(Pair edge:graph.get(vertex))
                {
                    int start=vertex;
                    int end=edge.vertex;
                    int weight=edge.weight;
                    if(distances[start]!=Integer.MAX_VALUE && distances[end]>distances[start]+weight)
                    {
                        distances[end]=distances[start]+weight;
                        parents[end]=start;
                    }
                }
            }
        }
        for(int vertex:graph.keySet())
        {
            for(Pair edge:graph.get(vertex))
            {
                int start=vertex;
                int end=edge.vertex;
                int weight=edge.weight;
                if(distances[start]!=Integer.MAX_VALUE && distances[end]>distances[start]+weight)
                {
                    return false;
                }
            }
        }
        return true;

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