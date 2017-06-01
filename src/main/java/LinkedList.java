// A complete working Java program to demonstrate all insertion and deletion methods on linked list

/**
 * Created by subhajit.sen on 15-05-2017.
 */
class LinkedList {
    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
        System.out.print(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data) {
        /* 1. Check if the given Node is null */
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        System.out.print(new_data + " after head");
        /* 2 & 3: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;
 
        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    /* Appends a new node at the end.  This method is 
       defined inside LinkedList class shown above */
    public void append(int new_data) {
        /* 1. Allocate the Node &
           2. Put in the data
           3. Set next as null */
        Node new_node = new Node(new_data);
        System.out.print(new_data);
        /* 4. If the Linked List is empty, then make the
              new node as head */
        if (head == null) {
            head = new Node(new_data);
            return;
        }
 
        /* 4. This new node is going to be the last node, so
              make next of it as null */
        new_node.next = null;
 
        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;
 
        /* 6. Change the next of last node */
        last.next = new_node;
        System.out.print(new_data);
        return;
    }

    /* Takes index as argument and return data at index*/
    public int getIndexElement(int index) {
        System.out.print(index);
        Node current = head;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null) {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }
        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert (false);
        return 0;
    }

    /* This function prints contents of linked list starting from
      the given node */
    public void printList() {
        System.out.println("List length: " + this.getListLength());
        Node tnode = head;
        System.out.print("List: ");
        while (tnode != null) {
            System.out.print(tnode.data + " -> ");
            tnode = tnode.next;
        }
        System.out.print("Null");
    }

    public int getListLength() {
        Node current = head;
        int count = 1;

        if (head == null) {
            return 0;
        }

        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public void insertAtIndex(int index, int element) {
        Node new_data = new Node(element);
        Node current = head;

        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null) {
            if (count == index) {
                new_data.data = current.data;
                new_data.next = current.next;
                current.data = element;
                current.next = new_data;
                System.out.print(element + " at " + index + " index: ");
                return;
            }
            count++;
            current = current.next;
        }

    }

    public int getMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public int getNthElementFromLast(int n) {
        Node slow = head;
        Node nTh = head;
        int length = this.getListLength();
        if (n > length) {
            System.out.print("index is beyond than the list size");
            return -1;
        }

        for (int i = 0; i < n; i++) {
            nTh = nTh.next;
        }
        while (nTh != null) {
            nTh = nTh.next;
            slow = slow.next;
        }
        System.out.print(n + " index ");
        return slow.data;
    }

    public void deleteWholeList() {
        head = null;
        System.gc();
    }

    public void deleteAtIndex(int index) {
        Node current = head;
        int count = 1;
        System.out.println(index);

        if (index == 0) {
            head = current.next;
            return;
        }

        while (current != null) {
            Node temp = current;
            current = current.next;
            if (count == index) {
                temp.next = temp.next.next;
                return;
            }
            count++;
        }
        System.out.println("Index is out of bound");
        return;
    }

    public void reverse() {
        Node current = head;
        Node before = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = before;
            before = current;
            current = next;
        }
        head = before;
    }

    public boolean isPalindromeUtil(String st) {
        int length = st.length();

        for (int i = 0; i < length; i++)
            if (st.charAt(i) != st.charAt(length - i - 1))
                return false;

        return true;
    }

    public boolean isPalindrome() {
        Node current = head;
        String st = "";
        while (current != null) {
            st=st.concat(String.valueOf(current.data));
            current = current.next;
        }
        return isPalindromeUtil(st);
    }

    public void deleteAtNode(Node del_node) {
        // assign the next node of the node to be deleted to temp
        System.out.print(del_node.data);
        Node temp = del_node.next;
        // copy the data from next node
        del_node.data = temp.data;
        // copy the next node reference of next node
        del_node.next = temp.next;
        temp = null;
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
        LinkedList palindrome = new LinkedList();

        llist.append(6);
        System.out.println("Append ");
        llist.printList();

        System.out.println("\n--------------");

        llist.push(7);
        System.out.println("Push");
        llist.printList();

        System.out.println("\n--------------");

        llist.push(1);
        System.out.println("Push ");
        llist.printList();

        System.out.println("\n--------------");

        llist.append(4);
        System.out.println("Append ");
        llist.printList();

        System.out.println("\n--------------");

        llist.push(9);
        System.out.println("Push ");
        llist.printList();

        System.out.println("\n--------------");

        llist.insertAfter(llist.head, 8);
        System.out.println("Insert ");
        llist.printList();

        System.out.println("\n--------------");

        System.out.println("Created Linked list is: ");
        llist.printList();

        System.out.println("\n--------------");

        System.out.print("Deleted element from @head.next.next : ");
        llist.deleteAtNode(llist.head.next.next);
        llist.printList();

        System.out.println("\n--------------");

        System.out.print("New Linked list after adding ");
        llist.insertAtIndex(0, 3);
        System.out.println();
        llist.printList();

        System.out.println("\n--------------");

        System.out.println("Element at index " + llist.getIndexElement(2));
        llist.printList();

        System.out.println("\n--------------");

        System.out.println("Middle element is: " + llist.getMiddle());
        llist.printList();

        System.out.println("\n--------------");

        System.out.println("Element from last is: " + llist.getNthElementFromLast(3));
        llist.printList();

        System.out.println("\n--------------");

        System.out.print("Delete element at index ");
        llist.deleteAtIndex(4);
        llist.printList();

        System.out.println("\n--------------");

        System.out.println("Reverse the list");
        llist.reverse();
        llist.printList();

        System.out.println("\n--------------");

        System.out.println("Delete whole list");
        llist.deleteWholeList();
        llist.printList();

        System.out.println("\n--------------");

        palindrome.append(1);
        palindrome.append(8);
        palindrome.append(3);
        palindrome.append(8);
        palindrome.append(1);

        palindrome.printList();
        System.out.print(" is Palindrome? "+palindrome.isPalindrome());

    }
}