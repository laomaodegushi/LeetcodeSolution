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
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
	return addTwoNumbers(node1, node2, 0);
    }

    private ListNode addTwoNumbers(ListNode node1, ListNode node2, int nextPlusValue) {
	ListNode result = null;
	if (node1 != null || node2 != null || nextPlusValue > 0) {
	    int node1Val = (node1 != null ? node1.val : 0);
	    int node2Val = (node2 != null ? node2.val : 0);
	    ListNode node1Next = (node1 == null ? null : node1.next);
	    ListNode node2Next = (node2 == null ? null : node2.next);

	    int val = node1Val + node2Val + nextPlusValue;
	    result = new ListNode(val % 10);
	    result.next = addTwoNumbers(node1Next, node2Next, val / 10);
	}
	return result;
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
	ListNode n22 = new ListNode(0);
	ListNode n23 = new ListNode(1);
	n21.next = n22;
	n22.next = n23;

	ListNode n3 = addTwoNumbers.addTwoNumbers(n21, n11);
	addTwoNumbers.display("输入1", n11);
	addTwoNumbers.display("输入2", n21);
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
