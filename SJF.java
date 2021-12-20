import java.util.*;
 
public class SJF {
 public static void main(String args[])
 {
  Scanner sc = new Scanner(System.in);
  System.out.println ("Enter total number of process:");
  int m = sc.nextInt();
  int p_id[] = new int[m];
  int arrive_t[] = new int[m]; 
  int burs_t[] = new int[m]; 
  int ct[] = new int[m]; 
  int tat[] = new int[m];
  int wt[] = new int[m]; 
  int flag[] = new int[m];
  int start=0, total=0;
  float avg_wt=0, avg_tat=0;
 
  for(int i=0;i<m;i++)
  {
   System.out.println ("Enter process " + (i+1) + " arrival time:");
   arrive_t[i] = sc.nextInt();
   System.out.println ("Enter process " + (i+1) + " brust time:");
   burs_t[i] = sc.nextInt();
   p_id[i] = i+1;
   flag[i] = 0;
  }
  
  
  boolean x = true;
  while(true)
  {
   int p=m, min=888;
   if (total == m)
    break;
   
   for (int i=0; i<m; i++)
   {
          
    if ((arrive_t[i] <= start) && (flag[i] == 0) && (burs_t[i]<min))
    {
     min=burs_t[i];
     p=i;
    }
   }
   
   
   if (p==m) 
    start++;
   else
   {
    ct[p]=start+burs_t[p];
    start+=burs_t[p];
    tat[p]=ct[p]-arrive_t[p];
    wt[p]=tat[p]-burs_t[p];
    flag[p]=1;
    total++;
   }
  }
  
  System.out.println("\npid  arrival brust  complete turn waiting");
  for(int i=0;i<m;i++)
  {
   avg_wt+= wt[i];
   avg_tat+= tat[i];
   System.out.println( p_id[i] + "\t" + arrive_t[i] + "\t" + burs_t[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i] );
  }
  System.out.println ("\naverage tat is "+ (float)(avg_tat/m));
  System.out.println ("average wt is "+ (float)(avg_wt/m));
  sc.close();
 }
}