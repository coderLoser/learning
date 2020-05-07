package com.bin.queue;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * 普通的单向队列
 * @param <T>
 */
public class CommonQueue<T> extends AbstractQueue<T> implements Serializable {
    private static final long serialVersionUID = 6210614755646588873L;

    /**
     * 双端链表
     */
    private class Node<N> {
        N item;
        Node<N> prev;
        Node<N> next;

        Node(N n) {
            item = n;
        }
    }

    private Node<T> head; // 最头的链表
    private int size;

    public CommonQueue() {}

    public Iterator<T> iterator() {
        return null;
    }

    public int size() {
        return size;
    }

    public boolean offer(T t) {
        if (t == null) throw new NullPointerException();

        Node<T> node = new Node<>(t);
        if (head == null) {
            head = node;
        } else {
            Node<T> last = getLast(head);
            last.next = node;
        }
        size++;
        return false;
    }

    public T poll() {
        if (head == null) return null;

        final Node<T> h = head;
        head = head.next;
        size--;
        return h.item;
    }

    public T peek() {
        if (head == null) return null;
        return head.item;
    }

    private Node<T> getLast(Node<T> node) {
        if (node.next == null) return node;
        else return getLast(node.next);
    }
}
