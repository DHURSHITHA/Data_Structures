import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        int sum=0,result=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            int avg=(int)((sum+i)/(i+1));
            result=Math.max(avg,result);
        }
        System.out.print(result);
    }
}






import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        int[] arr2=new int[n];
        for(int i=0;i<n;i++)
        {
            arr2[i]=arr[i];
        }
        Arrays.sort(arr2);
        int start=-1,end=-1;
        for(int i=0;i<n;i++)
        {
            if(start==-1&&arr[i]!=arr2[i])
            {
                start=i;
            }
            if(arr[i]!=arr2[i])
            {
                end=i;
            }
        }
        if(start==end&&start==-1) System.out.print("already in sorted");
        else System.out.print(end-start+1);
        
    }
}
     
     
     





import java.util.*;
public class Main{
    public static void check(int[][] queens,int[] king)
    {
        List<List<Integer>> result=new ArrayList<>();
        boolean[][] queen=new boolean[8][8];
        for(int[] q:queens)
        {
            queen[q[0]][q[1]]=true;
        }
        int[][] direction={
            {-1,-1},{-1,0},{-1,1},
            {0,-1},        {0,1},
            {1,-1},{1,0},{1,1}
        };
        for(int[] dir:direction)
        {
            int x=dir[0]+king[0];
            int y=dir[1]+king[1];
            while(x>=0&&x<8&&y>=0&&y<8)
            {
                if(queen[x][y])
                {
                    result.add(Arrays.asList(x,y));
                    break;
                }
                x+=dir[0];
                y+=dir[1];
            }
            
        }
        for(List<Integer> res:result)
        {
            System.out.print(res+"\n");
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] queens=new int[n][2];
        for (int i=0;i<n;i++)
        {
            queens[i][0]=scanner.nextInt();
            queens[i][1]=scanner.nextInt();
        }
        int[] king=new int[2];
        king[0]=scanner.nextInt();
        king[1]=scanner.nextInt();
        check(queens,king);
    }
}
        


import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        List<String> result=new ArrayList<>();
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        int start=arr[0];
        for(int i=1;i<=arr.length;i++)
        {
            if(i==arr.length||arr[i]!=arr[i-1]+1)
            {
                if(start==arr[i-1])
                {
                    result.add(String.valueOf(arr[i-1]));
                }
                else
                {
                    result.add(start+"->"+arr[i-1]);
                }
                if(i<arr.length)
                {
                    start=arr[i];
                }
            }
        }
        for(String str:result)
        {
            System.out.print(str+"\n");
        }
    }
}




import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        String[] strnums=new String[arr.length];
        for(int i=0;i<n;i++)
        {
            strnums[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(strnums,(a,b)->(b+a).compareTo(a+b));
        if(strnums[0].equals("0"))
        {
            System.out.print("0");
            return;
        }
        StringBuilder str=new StringBuilder();
        for(String s:strnums)
        {
            str.append(s);
        }
        System.out.print(str.toString());
    }
}



import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        int k=scanner.nextInt();
        for(int i=0;i<k;i++)
        {
            int min=Integer.MAX_VALUE;
            int index=-1;
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j]<min)
                {
                    min=arr[j];
                    index=j;
                }
            }
            arr[index]*=-1;
        }
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        System.out.print(sum);
    }
}


import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int[] arr=new int[256];
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!=' ')
            arr[str.charAt(i)]+=1;
        }
        for(int i=0;i<str.length();i++)
        {
            if(arr[str.charAt(i)]==1&&str.charAt(i)!=' ')
            {
                System.out.print(i);
                return;
            }
        }
    }
}



import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        int currentmax=arr[0];
        int currentmin=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int temp=currentmax;
            currentmax=Math.max(Math.max(arr[i],currentmax*arr[i]),currentmin*arr[i]);
            currentmin=Math.min(Math.min(arr[i],temp*arr[i]),currentmin*arr[i]);
            max=Math.max(max,currentmax);
        }
        System.out.print(max);
        
    }
}




import java.util.*;
public class Main{
    public static void backtrack(int index,int[] arr,List<Integer> current,List<List<Integer>> result)
    {
        if(current.size()>0)
        result.add(new ArrayList<>(current));
        for(int i=index;i<arr.length;i++)
        {
            if(i>index&&arr[i]==arr[i-1]) continue;
            current.add(arr[i]);
            backtrack(i+1,arr,current,result);
            current.remove(current.size()-1);
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(arr);
        backtrack(0,arr,new ArrayList<>(),result);
        for(List<Integer> res:result)
        {
            System.out.println(res);
        }
    }
}



import java.util.*;
public class Main{
    static int[] cost;
    public static void inc(int l,int r,int inc)
    {
        if(l>r) return;
        cost[l]+=inc;
        if(r+1<cost.length) cost[r+1]-=inc;
    }
    public static int complete()
    {
        for(int i=1;i<cost.length;i++)
        {
            cost[i]+=cost[i-1];
        }
        return Arrays.stream(cost).min().getAsInt();
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        int k=scanner.nextInt();
        cost=new int[k+1];
        for(int i=0;i<n/2;i++)
        {
            int max=Math.max(arr[i],arr[n-i-1]);
            int min=Math.min(arr[i],arr[n-i-1]);
            int onecostx=Math.max(max,k-min);
            inc(0,onecostx,1);
            inc(onecostx+1,k,2);
            inc(max-min,max-min,-1);
        }
        System.out.print(complete());
    }
}



import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        char[][] arr=new char[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=scanner.next().charAt(0);
            }
        }
        for(int i=0;i<m;i++)
        {
            int write=n-1;
            for(int j=n-1;j>=0;j--)
            {
                if(arr[i][j]=='*')
                {
                    write=j-1;
                }
                else if(arr[i][j]=='#')
                {
                    arr[i][j]='.';
                    arr[i][write]='#';
                    write--;
                }
            }

        }
        char[][] rotated=new char[n][m];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                rotated[j][m-i-1]=arr[i][j];
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(rotated[i][j]+" ");
            }
            System.out.println();
        }
    }
}


import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        int option1=arr[n-3]-arr[0];
        int option2=arr[n-2]-arr[1];
        int option3=arr[n-1]-arr[2];
        System.out.print(Math.min(option1,Math.min(option2,option3)));
    }
    
}



import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        int t=scanner.nextInt();
        int i=0,j=arr.length-1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            System.out.print(mid+"\n");
            if(arr[mid]==t)
            {
                System.out.print("target found");
                return;
            }
            if(arr[i]<=arr[mid])
            {
                if(arr[i]>=t&&arr[mid]<t)
                {
                    j=mid-1;
                }
                else
                {
                    i=mid+1;
                }
            }
            else
            {
                if(arr[j]<=t&&arr[mid]>t)
                {
                    i=mid+1;
                }
                else
                {
                    j=mid-1;
                }
            }
        }
        System.out.print("Not found");
    }
}


import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
              arr[i][j]=scanner.nextInt(); 
            }
        }
        for(int d=0;d<=m+n-2;d++)
        {
            if(d%2!=0)
            {
                for(int i=0;i<=d;i++)
                {
                    int j=d-i;
                    if(i<m&&j<n)
                    {
                        System.out.print(arr[i][j]+" ");
                    }
                }
            }
            else
            {
                for(int i=d;i>=0;i--)
                {
                    int j=d-i;
                    if(i<m&&j<n)
                    {
                        System.out.print(arr[i][j]+" ");
                    }
                }
            }
        }
    }
}






import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
              arr[i][j]=scanner.nextInt(); 
            }
        }
        int top=0,bottom=arr.length-1,left=0,right=arr[0].length-1;
        while(top<=bottom&&left<=right)
        {
            for(int i=left;i<=right;i++) System.out.print(arr[top][i]+" ");
            top++;
            for(int i=top;i<=bottom;i++) System.out.print(arr[i][right]+" ");
            right--;
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--) System.out.print(arr[bottom][i]+" ");
                bottom--;
            }
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--) System.out.print(arr[i][left]+" ");
                left++;
            }
        }
    }
}
        