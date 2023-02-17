package two_heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Maximize Capital
 *
 * You need to develop a program for making automatic investment decisions for a busy investor. The investor has some start-up capital, c
 * , to invest and a portfolio of projects in which they would like to invest in. The investor wants to maximize their cumulative capital as a result of this investment.
 * To help them with their decision, they have information on the capital requirement for each project and the profit it’s expected to yield. For example, if project A has a capital requirement of 3
 * , and the investor’s current capital is 1
 * , then the investor can’t invest in this project. On the other hand, if the capital requirement of a project B is 1
 * , then the investor can invest in this project. Now, supposing that the project yields a profit of2
 * , the investor’s capital at the end of the project will be 1+2=3
 * . The investor can now choose to invest in project A as well since their current capital has increased.
 *
 * As a basic risk-mitigation measure, the investor would like to set a limit on the number of projects, k, they invest in. For example, if the value of k is 2, then we need to identify the two projects that the investor can afford to invest in, given their capital requirements, and that yield the maximum profits.
 *
 * Further, these are one-time investment opportunities, that is, the investor can only invest once in a given project.
 */
public class MaximizeCapital {

    public static void main(String[] args) {
        int[] capital = {1, 2, 2, 3};
        int[] profits = {2, 4, 6, 8};
        int k = 2;
        int c = 1;
        System.out.println("Maximum Capital: " + maximizeCapital(capital, profits, k, c));
    }


    /**
     * In the below solution, we use two heaps, a min heap to store the capital requirements of the projects and a max heap to store the profits of the projects. We start by adding all the project indices to the min heap. Then, we iterate k times to select the k most profitable projects. In each iteration, we poll the project with the least capital requirement from the min heap and add it to the max heap. We then get the most profitable project from the max heap and invest in it by adding its profit to the current capital. Finally
     *
     * @param capitals
     * @param profits
     * @param k
     * @param c
     * @return
     */
    public static int maximizeCapital(int[] capitals, int[] profits, int k, int c) {
        // Create a min heap to store the capitals requirements of the projects
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> capitals[a]));

        // Create a max heap to store the profits of the projects
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);

        // Add all the project indices to the min heap
        for (int i = 0; i < capitals.length; i++) {
            minHeap.add(i);
        }

        // Iterate k times to select the k most profitable projects
        for (int i = 0; i < k; i++) {
            // Poll the project with the least capitals requirement from the min heap
            while (!minHeap.isEmpty() && capitals[minHeap.peek()] <= c) {
                // Add the project to the max heap
                maxHeap.add(minHeap.poll());
            }

            // If there are no more projects to invest in, return the current capitals
            if (maxHeap.isEmpty()) {
                return c;
            }

            // Get the most profitable project from the max heap
            int project = maxHeap.poll();

            // Invest in the project
            c += profits[project];
        }

        // Return the final capitals after k investments
        return c;
    }
}

