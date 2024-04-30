import java.util.ArrayList;
public class LRU {
  public static void main(String[] args) {
    int capacity = 4;
    int arr[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
    ArrayList<Integer> s = new ArrayList<>(capacity);
    int count = 0;
    int page_faults = 0;
    for (int i : arr) {
      if (!s.contains(i)) {
        if (s.size() == capacity) {
          s.remove(0);
          s.add(capacity - 1, i);
        } else
          s.add(count, i);
        page_faults++;
        ++count;
      } else {
        s.remove((Object) i);
        s.add(s.size(), i);
      }
    }
    int page_Hit = arr.length - page_faults;
    System.out.println("Page Fault :-" + page_faults);
    System.out.println("Page Hit :-" + page_Hit);
    System.out.println(Math.round(((double)page_Hit / arr.length) * 100) + "%");
    System.out.println(Math.round(((double)page_faults / arr.length) * 100) + "%");
  }
}