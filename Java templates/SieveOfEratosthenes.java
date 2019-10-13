 static boolean[] sieveOfEratosthenes(int n)
    {
        boolean isPrime[]=new boolean[n+1];
        for(int i=0;i<isPrime.length;i++)
        {
            isPrime[i]=true;
        }
        isPrime[1]=false;
        isPrime[0]=false;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(isPrime[i])
            {
                for(int j=i;i*j<=n;j++)
                {
                    isPrime[i*j]=false;
                }
            }
        }
        return isPrime;
    }


 static int [] smallestPrimeFactor(int n)
    {
        int smallestPrimes[]=new int[n+1];
        for(int i=1;i<=n;i++)
            smallestPrimes[i]=i;

        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(smallestPrimes[i]==i)
            {
                for(int j=i;i*j<=n;j++)
                {

                    if(smallestPrimes[i*j]==i*j)
                      smallestPrimes[i*j]=i;
                }
            }
        }
        return smallestPrimes;
    }



    static ArrayList<Integer> findPrimeFactors(int n,int smallersPrimeFactor[])
    {
        ArrayList<Integer> ans=new ArrayList<>();

        while (n!=1)
        {
            ans.add(smallersPrimeFactor[n]);
            n=n/smallersPrimeFactor[n];
        }
        return ans;
    }


     static void findPrimeFactors(int n,int smallersPrimeFactor[],ArrayList<Integer> primefactors,ArrayList<Integer> frequency)
    {

        while (n!=1)
        {
            primefactors.add(smallersPrimeFactor[n]);
            int frequencyOfFactor=0;
            int primeFactor=smallersPrimeFactor[n];
            while (n%primeFactor==0)
            {
                frequencyOfFactor++;
                n=n/primeFactor;
            }
            frequency.add(frequencyOfFactor);
        }
    }


 static boolean [] segmentedSieveOfErathosenes(int a,int b)
    {
        boolean isPrime[]=new boolean[b-a+1];
        for(int i=0;i<isPrime.length;i++)
            isPrime[i]=true;
        for(int i=2;i<=Math.sqrt(b);i++)
        {
            int j = (int) (Math.ceil((double)a / i)) * i;

                for (; j <= b; j = j + i) {
                    isPrime[j-a] = false;

            }
        }
        return isPrime;
    }



//finding prime factors in a single method


     static void sieveOfEratosthenes(int n,ArrayList<Integer> freq[],ArrayList<Integer> primeFactors[],int numbers[])
    {
        boolean isPrime[]=new boolean[n+1];
        for(int i=2;i<=n;i++)
            isPrime[i]=true;
        for(int i=2;i<=n;i++)
        {

            if (isPrime[i])
            {
                primeFactors[i].add(i);
                freq[i].add(1);
                for(int j=2;i*j<=n;j++)
                {
                      isPrime[i*j]=false;
                      primeFactors[i*j].add(i);
                      int frequency=0;
                      int num=i*j;
                      while (num%i==0)
                      {
                          num=num/i;
                          frequency++;
                      }
                      freq[i*j].add(frequency);
                }
            }
        }
    }