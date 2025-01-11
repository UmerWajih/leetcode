package leetcode.questions.x3300.to.x3399;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/maximize-amount-after-two-days-of-conversions/
public class Problem_3387 {

	public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1,
			List<List<String>> pairs2, double[] rates2) {
		// create adjancency list for day 1 and day 2
		// get all possible value for each pair from day 1
		//

		// Graph for Day 1
		Map<String, Map<String, Double>> graph1 = buildGraph(pairs1, rates1);
		// Graph for Day 2
		Map<String, Map<String, Double>> graph2 = buildGraph(pairs2, rates2);

		return getMaxAmounts(initialCurrency, graph2, getMaxAmounts(initialCurrency, graph1))
				.getOrDefault(initialCurrency, 0.0);
	}
	// get total max amounts for each pair on day 1

	private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates) {
		Map<String, Map<String, Double>> graph = new HashMap<>();
		for (int i = 0; i < pairs.size(); i++) {
			String start = pairs.get(i).get(0);
			String target = pairs.get(i).get(1);
			double rate = rates[i];

			graph.putIfAbsent(start, new HashMap<>());
			graph.putIfAbsent(target, new HashMap<>());
			graph.get(start).put(target, rate);
			graph.get(target).put(start, 1 / rate);
		}
		return graph;
	}

	private Map<String, Double> getMaxAmounts(String startCurrency, Map<String, Map<String, Double>> graph) {
		Map<String, Double> maxAmounts = new HashMap<>();
		maxAmounts.put(startCurrency, 1.0);

		Queue<String> queue = new LinkedList<>();
		queue.offer(startCurrency);

		while (!queue.isEmpty()) {
			String current = queue.poll();
			double currentAmount = maxAmounts.get(current);

			for (Map.Entry<String, Double> entry : graph.getOrDefault(current, new HashMap<>()).entrySet()) {
				String neighbor = entry.getKey();
				double rate = entry.getValue();
				double newAmount = currentAmount * rate;
				//check if after conversion if we are being left with more than the origininal amount
				if (newAmount > maxAmounts.getOrDefault(neighbor, 0.0)) {
					maxAmounts.put(neighbor, newAmount);
					queue.offer(neighbor);
				}
			}
		}

		return maxAmounts;
	}

	private Map<String, Double> getMaxAmounts(String startCurrency, Map<String, Map<String, Double>> graph,
			Map<String, Double> initialAmounts) {
		Map<String, Double> maxAmounts = new HashMap<>(initialAmounts);
		Queue<String> queue = new LinkedList<>(initialAmounts.keySet());

		while (!queue.isEmpty()) {
			String current = queue.poll();
			double currentAmount = maxAmounts.get(current);

			for (Map.Entry<String, Double> entry : graph.getOrDefault(current, new HashMap<>()).entrySet()) {
				String neighbor = entry.getKey();
				double rate = entry.getValue();
				double newAmount = currentAmount * rate;

				if (newAmount > maxAmounts.getOrDefault(neighbor, 0.0)) {
					maxAmounts.put(neighbor, newAmount);
					queue.offer(neighbor);
				}
			}
		}

		return maxAmounts;
	}
}
