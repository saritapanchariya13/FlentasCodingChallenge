
import java.util.Arrays;
import java.util.Scanner;

public class RiverCrossing {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int noOfTestCases = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (noOfTestCases >= 1 && noOfTestCases <= 10) {
            for (int testcase = 0; testcase < noOfTestCases; testcase++) {
                int noOfVillagers = scanner.nextInt();
                if (noOfVillagers >= 1 && noOfVillagers <= 100000) {

                    long costs[] = new long[noOfVillagers];

                    for (int count = 0; count < costs.length; count++) {
                        costs[count] = scanner.nextLong();
                        if (!(costs[count] >= 1 && costs[count] <= 1000000)) {
                            System.out.println("Invalid input");
                            System.exit(0);
                        }
                    }
                    System.out.println(minimumCost(costs, noOfVillagers));
                } else {
                    System.out.println("Invalid input");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Invalid input");
            System.exit(0);
        }
        scanner.close();
    }

    private static long minimumCost(long costs[], int n) {

        Arrays.sort(costs);

        long total = 0;

        for (int i = n - 1; i > 1; i -= 2) {
            if (i == 2) {
                total += costs[2] + costs[0];
            } else {

                long priceFirst = costs[i] + costs[0] + 2 * costs[1];
                long priceSecond = costs[i] + costs[i - 1] + 2 * costs[0];
                total += Math.min(priceFirst, priceSecond);
            }
        }

        total += n == 1 ? costs[0] : costs[1];

        return total;
    }

}

