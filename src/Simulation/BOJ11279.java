package Simulation;


// 최대힙을 이용
	// 기능1. 배열에 자연수 x를 넣는다
	// 기능2. 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거

// 수가 자연수라면 수를 배열에 추가
// 수가 0이라면 배열에서 가장 큰 값을 출력하고 제거

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11279 {
	private static Scanner scanner = new Scanner(System.in);
	private static PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

	public void solution() {
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			checkNumber(scanner.nextInt());
		}
	}

	public void checkNumber(int num) {
		if (num == 0) {
			removeMaxNumber();
			return;
		}
		heap.add(num);
	}

	public void removeMaxNumber() {
		if (heap.isEmpty()) {
			System.out.println(0);
			return;
		}
		System.out.println(heap.poll());
	}

	public static void main(String[] args) {
		new BOJ11279().solution();
	}
}
