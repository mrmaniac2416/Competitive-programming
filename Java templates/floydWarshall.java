 public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
      
      
      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */
        //The Code Starts here
        int noOfVertices=sc.nextInt();
        int noOfEdges=sc.nextInt();
        int shortestPathMatrix[][]=new int[noOfVertices][noOfVertices];
        int pathMatrix[][]=new int[noOfVertices][noOfVertices];
        for(int i=0;i<noOfVertices;i++)
        {
            for(int j=0;j<noOfVertices;j++)
            {
                if(i!=j)
                    shortestPathMatrix[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<noOfVertices;i++)
            Arrays.fill(pathMatrix[i],-1);
        for(int i=0;i<noOfEdges;i++)
        {
            int start=sc.nextInt();
            int end=sc.nextInt();
            int weight=sc.nextInt();
            shortestPathMatrix[start][end]=weight;
            pathMatrix[start][end]=start;
        }
        floydWarshall(shortestPathMatrix,pathMatrix,noOfVertices);
        debug(shortestPathMatrix);



        //The Code ends here
        out.close();
    }
    static void floydWarshall(int [][]shortestPathMatrix,int pathMatrix[][],int noOfVertices)
    {
        for(int k=0;k<noOfVertices;k++)
        {
            for(int i=0;i<noOfVertices;i++)
            {
                for(int j=0;j<noOfVertices;j++)
                {
                    if(shortestPathMatrix[i][k]!=Integer.MAX_VALUE && shortestPathMatrix[k][j]!=Integer.MAX_VALUE )
                    {
                        if(shortestPathMatrix[i][j]>shortestPathMatrix[i][k]+shortestPathMatrix[k][j])
                        {
                            shortestPathMatrix[i][j]=shortestPathMatrix[i][k]+shortestPathMatrix[k][j];
                            pathMatrix[i][j]=pathMatrix[k][j];
                        }
                    }
                }
            }
        }
    }