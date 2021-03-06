import java.util.*;
 
public class Robin_round{
   public static void WaitingTime(int process[],int wait_t[],int m ,int burs_t[],int quantum,int comp_t[],int arrive_t[]){
        
        int rt[] = new int[m]; 
         
        for(int i=0;i<wait_t.length;i++){
            rt[i]= burs_t[i];
        }
        int t=0;
        int arrival=0;
       
        while(true){

            boolean done = true;
            for(int i=0;i<m;i++){
                if(rt[i]>0){
                     done =false;
                    if(rt[i]>quantum && arrive_t[i]<=arrival){
                        t +=quantum;
                        rt[i]-=quantum;
                        arrival++;
                    }
                    else{
                    if(arrive_t[i]<=arrival){
                        arrival++;
                        t+=rt[i];
                        rt[i]=0;
                        comp_t[i]=t; }
                    }
                 }
              }
             
            if(done==true)    
            { 
                break;
                }
        }    
        }
    public static void TurnAroundTime(int process[] ,int wt[],int m,int bt[],int ta[],int ct[],int at[]){
        for(int i=0;i<m;i++){
            ta[i]= ct[i]-at[i];
            wt[i] = ta[i]-bt[i];
             
             
        }
         
    }
     
    public static void AvgTime(int process[],int m,int bt[],int quantum,int at[]){
      int wt[] = new int[m];
      int ta[] = new int[m];
      int ct[] = new int[m];
      WaitingTime(process,wt,m,bt,quantum,ct,at);    
      TurnAroundTime(process,wt,m,bt,ta,ct,at);
      int total_wt = 0, total_ta= 0; 
       
      System.out.println("Processes " +" Arrival Time\t"+ "  Burst time " +" completion time"+ 
              " Turn Around Time " + " Waiting time");
      for (int i=0; i<m; i++) 
      { 
          total_wt = total_wt + wt[i]; 
          total_ta = total_ta + ta[i]; 
          System.out.println(" " + (i+1) + "\t\t"+ at[i]+"\t\t"+ + bt[i] +"\t " +ct[i]+"\t\t"
                            +ta[i] +"\t\t " + wt[i]); 
      } 
      
      System.out.println("Average waiting time = " + 
                        (float)total_wt / (float)m); 
      System.out.println("Average turn around time = " + 
                         (float)total_ta / (float)m); 
    }
 
    public static void main(String []agrs){
    
    Scanner scan = new Scanner(System.in);
     
    int quan_time = 4;
    int arrival_time[] = new int[]{0,0,0};
    int processes[] = new int[]{1,2,3};
    int burs_time[] = new int[]{24,3,3};
    int m  = processes.length;
     
    AvgTime(processes,m,burs_time,quan_time,arrival_time);
     
    scan.close();
         
    }
}
  
     