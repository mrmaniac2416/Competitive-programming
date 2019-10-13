  static class Point implements Comparable<Point>{
        long x;
        long y;

        Point(long x,long y)
        {
            this.x=x;
            this.y=y;
        }

        public int compareTo(Point o)
        {
            return Long.compare(this.x,o.x);
        }
        public String toString()
        {
            return "X:" + x + " Y:" + y ;
        }
    }

    static long distance(Point p1,Point p2)
    {
        long x1=p1.x-p2.x;
        long y1=p1.y-p2.y;

        return x1*x1+y1*y1;
    }

    static long shortestDistance(Point points[])
    {

        Arrays.sort(points);
        Point reversePoints[]=new Point[points.length];

        for(int i=0;i<points.length;i++)
            reversePoints[i]=new Point(points[i].y,points[i].x);
        long min=distance(reversePoints[0],reversePoints[1]);
        TreeSet<Point> active=new TreeSet<>();
        active.add(reversePoints[0]);
        int left=0;
        for(int i=1;i<reversePoints.length;i++)
        {
            while (left<i && points[left].x<(points[i].x-min))
            {
                active.remove(reversePoints[left++]);
            }

            SortedSet<Point> satisfyingPoints=active.tailSet(new Point(reversePoints[i].x-min,reversePoints[i].y-min));

            for(Point satisfyingPoint:satisfyingPoints)
            {
                if(satisfyingPoint.x>reversePoints[i].x+min)
                    break;
                min=Math.min(min,distance(reversePoints[i],satisfyingPoint));
            }
            active.add(reversePoints[i]);
        }
        return min;
    }