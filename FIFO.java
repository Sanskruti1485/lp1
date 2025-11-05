import java.util.*;

public class SimpleFIFO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int frames = sc.nextInt();

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();

        int pages[] = new int[n];
        System.out.println("Enter the page reference string:");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        // FIX APPLIED HERE
        Queue<Integer> memory = new LinkedList<Integer>();
        int pageFaults = 0;

        System.out.println("\nPage\tFrames\t\tPage Fault");
        for (int i = 0; i < n; i++) {
            int page = pages[i];

            if (!memory.contains(page)) {
                if (memory.size() == frames) {
                    memory.poll();
                }

                memory.add(page);
                pageFaults++;
                System.out.println(page + "\t" + memory + "\tYes");
            } else {
                System.out.println(page + "\t" + memory + "\tNo");
            }
        }

        System.out.println("\nTotal Page Faults = " + pageFaults);

        sc.close();
    }
}
