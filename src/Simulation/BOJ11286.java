package Simulation;


// 절댓값 힙
	// 기능 1. 배열에 정수 x를 넣는다
	// 기능 2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거
		// 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고 제거

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286 {
	private static class Main {
		private class Abs implements Comparable<Abs> {
			int number;
			int absNumber;

			public Abs(int number, int absNumber) {
				this.number = number;
				this.absNumber = absNumber;
			}

			@Override
			public int compareTo(Abs o) {
				if (this.absNumber == o.absNumber) {
					return this.number - o.number;
				}

				return this.absNumber - o.absNumber;
			}
		}

		private static PriorityQueue<Abs> heap = new PriorityQueue<Abs>();
		private static Scanner scanner = new Scanner(System.in);

		public void solution() {
			int n = scanner.nextInt();

			for (int i = 0; i < n; i++) {
				checkNumber(scanner.nextInt());
			}
		}

		public void checkNumber(int number) {
			if (number == 0) {
				removeMin();
				return;
			}

			heap.add(new Abs(number, Math.abs(number)));
		}

		public void removeMin() {
			if (heap.isEmpty()) {
				System.out.println(0);
				return;
			}

			System.out.println(heap.poll().number);
		}

		public static void main(String[] args) {
			new Main().solution();
		}
	}
}
