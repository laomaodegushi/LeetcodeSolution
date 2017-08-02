/**
 * Project description
 * com.leetcode.problem2
 */
package com.leetcode.problem2;

import com.leetcode.main.MainInterface;

/**
 * @author nixianmiao
 * @date 2017年8月2日
 */
public class AddTwoNumbers implements MainInterface {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			if (l2 == null) {
				return null;
			} else {
				l1 = l2;
				return l1;
			}
		} else {
			if (l2 == null)
				l2 = new ListNode(0);
			l1.val = l1.val + l2.val;
			if (l1.val / 10 > 0) {// 进位
				if (l1.next == null) {
					l1.next = new ListNode(1);
				} else {
					l1.next.val += 1;
				}
			}
			l1.val = l1.val % 10;
			l1.next = addTwoNumbers(l1.next, l2.next);
			return l1;
		}
	}

	public void display(String desc, ListNode listNode) {
		System.out.print(desc + ": ");
		while (listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
		System.out.println();
	}

	@Override
	public void excute() {
		System.out.println("problem 2 :");
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode n11 = new ListNode(9);
		ListNode n12 = new ListNode(9);
		ListNode n13 = new ListNode(7);
		n11.next = n12;
		n12.next = n13;
		ListNode n21 = new ListNode(9);
		ListNode n22 = new ListNode(2);
		ListNode n23 = new ListNode(1);
		n21.next = n22;
		n22.next = n23;
		
		addTwoNumbers.display("输入1", n11);
		addTwoNumbers.display("输入2", n21);
		
		ListNode n3 = addTwoNumbers.addTwoNumbers(n21, n11);
		addTwoNumbers.display("结果", n3);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
