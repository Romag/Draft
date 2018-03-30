package linkedListReverse;
import java.lang.Math;

public class Yuh {
	public static void main(String[] args) {
		// calculate(50000d, 1.08d, 35);

		ListNode<Integer> head = new ListNode<Integer>(0);
		ListNode<Integer> cursor = head;
		for (int i = 1; i < 10; i++) {
			cursor.next = new ListNode<Integer>(i);
			cursor = cursor.next;
		}

		// print(head);

		head = reverse(head);

	}

	static ListNode<Integer> reverse(ListNode<Integer> node) {
		ListNode<Integer> prev = null;
		ListNode<Integer> current = node;
		ListNode<Integer> next = null;
		while (current != null) {
			System.out.print("Prev: ");
			print(prev);
			System.out.print("Current: ");
			print(current);
			System.out.print("Next: ");
			print(next);
			System.out.println();

			next = current.next;

			current.next = prev;
			prev = current;

			current = next;
		}
		node = prev;
		System.out.print("Prev: ");
		print(prev);
		System.out.print("Current: ");
		print(current);
		System.out.print("Next: ");
		print(next);
		System.out.println();
		return node;
	}

	static void print(ListNode<Integer> list) {
		while (list != null) {
			System.out.print(list.value + " ");
			list = list.next;
		}
		System.out.println();
	}

	static void calculate(double investment, double rate, int years) {
		double sum = 0.0d;
		for (int i = 0; i < years; i++) {
			sum += Math.pow(rate, i + 1);
		}

		System.out.println(investment * years + "\n" + investment * sum);

	}

}
