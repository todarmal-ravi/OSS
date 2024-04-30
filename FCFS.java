import java.util.*;

public class FCFS {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of processes: ");
    int n = sc.nextInt();
    int bt[] = new int[20];
    System.out.println("\nEnter the Burst Time for each process.");
    for (int i = 0; i < n; i++) {
      System.out.print("\nFor Process " + (i + 1) + ":");
      bt[i] = sc.nextInt();
    }
    avg_wt_tt(n, bt);
  }
  private static void waiting_time(int n, int[] bt, int[] wt) {
    wt[0] = 0;
    for (int i = 1; i < n; i++) {
      wt[i] = bt[i - 1] + wt[i - 1];
    }
  }
  private static void turnaround_time(int n, int[] bt, int[] wt, int[] tt) {
    for (int i = 0; i < n; i++) {
      tt[i] = bt[i] + wt[i];
    }
  }
  private static void avg_wt_tt(int n, int[] bt) {
    int wt[] = new int[n];
    int tt[] = new int[n];
    waiting_time(n, bt, wt);
    turnaround_time(n, bt, wt, tt);
  System.out.println("\nProcesses ||" + " Burst Time ||" + " Arrival Time ||" + " Waiting Time||" + " Turn-Around Time ");
  float awt = 0;
  float att = 0;
  for (int i = 0; i < n; i++) {
      awt = awt + wt[i];
      att = att + tt[i];
      System.out.println(
          i + 1 + "\t ||\t" + bt[i] + "\t||\t" + wt[i] + "\t||\t " + tt[i]);
  }
  awt = awt / n;
  att = att / n;
  System.out.println("\nAverage waiting time = " + awt);
  System.out.println("\nAverage turn around time = " + att);
  }
}
 