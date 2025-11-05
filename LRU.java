1.	Problem Statement 12: Page Replacement – LRU
Write a program to simulate the Least Recently Used (LRU) page replacement algorithm.
The program should display the frame contents after each page reference and the total number of page faults.

import java.util.*;

public class SimpleLRU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of frames
        System.out.print("Enter number of frames: ");
        int frames = sc.nextInt();

        // Step 2: Input number of pages
        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();

        int pages[] = new int[n];
        System.out.println("Enter the page reference string:");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        // Step 3: Use LinkedHashSet to store pages (preserves order)
        LinkedHashSet<Integer> memory = new LinkedHashSet<>();
        int pageFaults = 0;

        System.out.println("\nPage\tFrames\t\tPage Fault");
        for (int i = 0; i < n; i++) {
            int page = pages[i];

            // Step 4: If page not in memory → page fault
            if (!memory.contains(page)) {
                // Step 5: If memory full, remove least recently used (first item)
                if (memory.size() == frames) {
                    int lru = memory.iterator().next(); // get first inserted (least recently used)
                    memory.remove(lru);
                }

                // Step 6: Add new page
                memory.add(page);
                pageFaults++;

                System.out.println(page + "\t" + memory + "\tYes");
            } else {
                // Step 7: Page already present → move it to most recently used position
                memory.remove(page);
                memory.add(page);
                System.out.println(page + "\t" + memory + "\tNo");
            }
        }

        // Step 8: Display total page faults
        System.out.println("\nTotal Page Faults = " + pageFaults);

        sc.close();
    }
}
 
