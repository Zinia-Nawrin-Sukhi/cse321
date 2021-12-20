import java.io.*;
import java.util.*;

public class BankerAlgrithm {

 public static void main(String[] args) throws  IOException {
  
  
  BufferedReader reader = new BufferedReader(new FileReader(("F:/cse321/lab/lab6/bankalgo.txt")));
  int m = Integer.parseInt(reader.readLine());
  int n = Integer.parseInt(reader.readLine());
  char[] process = { 'A', 'B', 'C', 'D'};
  int[][] max = new int[m][n];
  int[][] allocation = new int[m][n];
  int[][] need = new int[m][n];
  int[][] available = new int[m + 1][n];
  LinkedList<Integer> track = new LinkedList<>();

  for (int i = 0; i < m; i++) {
   String strng = reader.readLine();
   StringTokenizer strngtkn = new StringTokenizer(strng, " ");

   int j = 0;
   while (strngtkn.hasMoreTokens()) {
    max[i][j] = Integer.parseInt(strngtkn.nextToken());
    j++;
   }
  }

  for (int i = 0; i < m; i++) {
   String strng = reader.readLine();
   StringTokenizer strngtkn = new StringTokenizer(strng, " ");

   int j = 0;
   while (strngtkn.hasMoreTokens()) {
    allocation[i][j] = Integer.parseInt(strngtkn.nextToken());
    need[i][j] = max[i][j] - allocation[i][j];
    j++;
   }
  }

  String strng = reader.readLine();
  StringTokenizer strngtkn = new StringTokenizer(strng, " ");

  int check = 0;
  while (strngtkn.hasMoreTokens()) {
   available[0][check] = Integer.parseInt(strngtkn.nextToken());
   check++;
  }

  check = 0;
  for (int i = 0;; i++) {
   i = i % m;
   for (int j = 0; j < n; j++) {
    if (need[i][j] > available[check][j]) {
     break;
    } else {
     if (j == (n - 1) && !track.contains(i)) {
      for (int k = 0; k < n; k++) {
       available[check + 1][k] = available[check][k] + allocation[i][k];
      }

      track.addLast(i);
      check++;
     }
    }
   }

   if (track.size() == m) {
    break;
   }
  }

  System.out.println("Need Matrix :");
  for (int i = 0; i < need.length; i++) {
   for (int j = 0; j < n; j++) {
    if (j < (n - 1)) {
     System.out.print(need[i][j] + " ");
    } else {
     System.out.println(need[i][j]);
    }
   }
  }

  System.out.println();
  System.out.println("Safe Sequence is :");
  for (int i = 0; i < track.size(); i++) {
   System.out.print(process[track.get(i)] + " ");
  }

  System.out.println();
  System.out.println("Change in available resource matrix :");
  for (int i = 1; i < available.length; i++) {
   System.out.println();
   for (int j = 0; j < n; j++) {
    System.out.print(available[i][j] + " ");
   }
   System.out.println();
  }

  System.out.println();

 }

}
 
