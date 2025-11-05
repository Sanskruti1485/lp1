import java.util.*;

public class NextFit {
    public static void main(String[] args) {
        int[] blockSize = {100, 500, 200, 300, 600};
        int[] processSize = {212, 417, 112, 426};

        int m = blockSize.length, n = processSize.length;
        int[] allocation = new int[n];
        Arrays.fill(allocation, -1);
        int j = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            while (count < m) {
                if (blockSize[j] >= processSize[i]) {
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    break;
                }
                j = (j + 1) % m;
                count++;
            }
        }

        System.out.println("Process No.\tProcess Size\tBlock No.");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.println(allocation[i] + 1);
            else
                System.out.println("Not Allocated");
        }
    }
}
