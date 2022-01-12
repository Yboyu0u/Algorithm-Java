package Simulation;

// 미국 전역의 나무들이 주어졌을 때,
// 각 종이 전체에서 몇 %를 차지하는지 구하는 프로그램을 만들어라

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BOJ4358 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scanner = new Scanner(System.in);
	private static Map<String, Double> map = new TreeMap<>();
	private static double total;

	public void Solution() throws IOException {

		while (true) {
			String tree = br.readLine();

			if (tree == null || tree.length() == 0) {
				break;
			}

			map.put(tree, map.getOrDefault(tree, 0.0) + 1);
			total++;
		}

		printPercentages();
	}

	private void printPercentages() {
		map.keySet().forEach(tree -> System.out.println(tree + " " + calculate(map.get(tree))));
	}

	private String calculate(double count) {
		return String.format("%.4f", (count / total) * 100.0);
	}

	public static void main(String[] args) throws IOException {
		new BOJ4358().Solution();
	}
}
