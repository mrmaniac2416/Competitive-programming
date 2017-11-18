#include <bits/stdc++.h> 
#define LOCAL 0 
#define forn(i, n) for(int i = 0; i < int(n); i++) 
#define form(i,b) for(int i=1;i<=b;i++) 
#define lli long long 
#define mp make_pair 
#define pi pair<int,int> 
#define pli pair<lli,int> 
#define pb push_back 
#define u first 
#define v second 
#define sl(x) scanf("%I64d",&x) 
#define pl(x) printf("%I64d\n",x) 
#define sf(x) sort(x.begin(),x.end(),func) 
#define s1(x) sort(x.begin(),x.end()) 
#define all(v) v.begin(),v.end() 
#define r(v) {reverse(all(v));} 
 
 
 
using namespace std; 
 
typedef vector< int > vi; 
typedef vector< lli > vli; 
typedef vector< vi > vvi; 
 
 
int main() 
{ 
ios::sync_with_stdio(false);     
cin.tie(NULL); 
int n; 
cin>>n; 
vi a(n); 
forn(i,n){ 
    cin>>a[i]; 
} 

int ans=0; 
int i=0,j=n-1; 
while(i<j){ 
    if(a[i]%2==1 && a[j]%2==0){ 
        i++; 
        j--; 
        ans++; 
    } 
    else if(a[i]%2==0){ 
        i++; 
    } 
    else if(a[j]%2==1){ 
        j--; 
    } 
} 
cout<<ans<<endl; 
return 0;    
}