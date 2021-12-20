import java.util.*;

public class Priority_Scheduling {
 public static void main(String args[])
 {
  Scanner sc = new Scanner(System.in);
  System.out.println ("Enter number of total process:");
  int n = sc.nextInt();
  int process_id[] = new int[n];
  int arrival_t[] = new int[n];
  int burst_t[] = new int[n]; 
  int prior[]= new int[n]; 
  int comp_t[] = new int[n]; 
  int t_around[] = new int[n]; 
  int wait_t[] = new int[n];  
  int f[] = new int[n]; 
  int start=0, total=0;
  float avg_wait_t=0, avg_t_around=0;
 
  for(int i=0;i<n;i++)
  {
   System.out.println ("Enter process " + (i+1) + " priority:");
   prior[i] = sc.nextInt();
   System.out.println ("Enter process " + (i+1) + " arrival time:");
   arrival_t[i] = sc.nextInt();
   System.out.println ("Enter process " + (i+1) + " brust time:");
   burst_t[i] = sc.nextInt();
   process_id[i] = i+1;
   f[i] = 0;
  }
  
  boolean a = true;
  while(true)
  {
   int p=n, min=888;
   if (total == n)
    break;
   
   for (int i=0; i<n; i++)
   {
          
    if ((arrival_t[i] <= start) && (f[i] == 0) && (prior[i]<min))
    {
     min=prior[i];
     p=i;
    }
   }
   
   
   if (p==n) 
    start++;
   else
   {
    comp_t[p]=start+burst_t[p];
    start+=burst_t[p];
    t_around[p]=comp_t[p]-arrival_t[p];
    wait_t[p]=t_around[p]-burst_t[p];
    f[p]=1;
    total++;
   }
  }
  
  System.out.println("pid" +"   " +"arrival" +"     " + "brust" + "     "+"priority" + "   " + "complete" + "   " + "turn" +"   " + "waiting");
  for(int i=0;i<n;i++)
  {
   avg_wait_t+= wait_t[i];
   avg_t_around+= t_around[i];
   System.out.println( process_id[i] + "\t" + arrival_t[i] + "\t" + burst_t[i] +"\t"+ prior[i]+ "\t" + comp_t[i] + "\t" + t_around[i] + "\t" + wait_t[i] );
  }
  System.out.println ("\naverage tat is "+ (float)(avg_t_around/n));
  System.out.println ("average wt is "+ (float)(avg_wait_t/n));
  sc.close();
 }
}