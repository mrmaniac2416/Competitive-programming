  public static void bfs(HashMap<Integer,HashSet<Integer>> graph,int start)
      {
          HashSet<Integer> visited=new HashSet<>();
          Queue<Integer> neigbours=new ArrayDeque<>();
          neigbours.add(start);
          visited.add(neigbours.peek());
          while (!neigbours.isEmpty())
          {
              int visiting=neigbours.poll();
              out.println(visiting);
              for(int vertex:graph.get(visiting))
              {
                  if(!visited.contains(vertex))
                  {
                      neigbours.add(vertex);
                      visited.add(vertex);
              
                  }
              }
          }
      }
