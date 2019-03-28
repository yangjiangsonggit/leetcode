package com.yjs.leetcodelearning.add_two_numbers_2;

import java.util.Random;

/**
 * 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * create by jiangsongy on 2019/3/27
 */
public class AddTwoNumbers {

	public static class ListNode {
		int val;
        ListNode next;
        ListNode(int x) { val = x; }

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int currentSum = 0;
		int carry = 0;
		ListNode lastNode = null;
		ListNode currentNode = null;
		ListNode head = null;
		while(l1!=null || l2!=null) {

			if (l1!=null && l2!=null) {
				//两个都不为空
				currentSum = l1.val + l2.val + carry;

			} else if (l1!=null) {
				//有一个为空
				currentSum = l1.val + carry;

			} else {
				currentSum = l2.val + carry;
			}

			if (currentSum > 9) {
				carry = currentSum / 10;
				currentSum = currentSum % 10;
			} else {
				carry = 0;
			}

			//指针加迭代
			currentNode = new ListNode(currentSum);
			if (lastNode != null) {
				lastNode.next = currentNode;
			} else {
				head = currentNode;
			}
			lastNode = currentNode;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			continue;
		}

		if (carry != 0) {
			currentNode = new ListNode(carry);
			lastNode.next = currentNode;
		}

		return head;
	}

	public static ListNode generateListNode() {
		Random random = new Random();
		ListNode lastNode = null;
		ListNode head = null;
		for (int i = 0; i < random.nextInt(9); i++) {
			ListNode current = new ListNode(random.nextInt(9));
			if (lastNode != null) {
				lastNode.next = current;
			} else {
				head = current;
			}
			lastNode = current;
		}
		return head;
	}

	public static void sout(ListNode listNode) {
		String tmp = "";
		while(listNode != null) {
			tmp += listNode.val + ",";
			listNode = listNode.next;
		}
		System.out.println(tmp);;
	}

	public static void main(String[] args) {
		ListNode listNode1 = generateListNode();
		ListNode listNode2 = generateListNode();
		sout(listNode1);
		sout(listNode2);

		ListNode listNode = addTwoNumbers(listNode1, listNode2);
		sout(listNode);
	}

}
