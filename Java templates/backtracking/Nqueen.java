 static boolean isAttacked(int x,int y,int board[][])
    {
        //row
        for(int col=0;col<board.length;col++)
        {
            if(board[x][col]==1)
                return true;
        }
        //column
        for(int row=0;row<board.length;row++)
        {
            if(board[row][y]==1)
                return true;
        }

        //diagonal

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if((i+j)==(x+y) || (i-j)==(x-y) )
                {
                    if(board[i][j]==1)
                    return true;
                }
            }
        }
        return false;
    }

    static boolean nQueen(int board[][],int n,int currN)
    {
        if(currN==0)
            return true;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isAttacked(i,j,board))
                    continue;
                board[i][j]=1;
                if(nQueen(board,n,currN-1))
                    return true;
                board[i][j]=0;
            }
        }
        return false;
    }