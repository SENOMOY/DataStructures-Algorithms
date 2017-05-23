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
        return;
    }

    /* Takes index as argument and return data at index*/
    public int getIndexElement(int index) {
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
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.print("Null");
    }

    public void insertAtIndex(int index, int element) {
        Node new_data = new Node(element);
        Node temp;
        Node current = head;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null) {
            if (count == index) {
                temp = current;
                new_data.data = current.data;
                new_data.next = current.next;
                current.data = element;
                current.next = new_data;
                System.out.print(element);
                System.out.print(" at " + index + " index: ");
                return;
            }

            count++;
            current = current.next;
        }

    }

    public void deleteNode(Node del_node) {
        // assign the next node of the node to be deleted to temp
        Node temp = del_node.next;
        // copy the data from next node
        del_node.data = temp.data;
        System.out.print(del_node.data);
        // copy the next node reference of next node
        del_node.next = temp.next;
        temp = null;
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();

        llist.append(6);
        System.out.println("Append 6");
        llist.printList();

        System.out.println("\n--------------");

        llist.push(7);
        System.out.println("Push 7");
        llist.printList();

        System.out.println("\n--------------");

        llist.push(1);
        System.out.println("Push 1");
        llist.printList();

        System.out.println("\n--------------");

        llist.append(4);
        System.out.println("Append 4");
        llist.printList();

        System.out.println("\n--------------");

        llist.insertAfter(llist.head, 8);
        System.out.println("Insert 8 after head");
        llist.printList();

        System.out.println("\n--------------");

        System.out.println("Created Linked list is: ");
        llist.printList();

        System.out.println("\n--------------");

        System.out.print("Deleted 3rd element ");
        llist.deleteNode(llist.head.next.next);
        System.out.println(" @head.next.next :");
        llist.printList();

        System.out.println("\n--------------");

        System.out.println("New Linked list after deletion: ");
        llist.printList();

        System.out.println("\n--------------");

        System.out.print("New Linked list after adding ");
        llist.insertAtIndex(0, 3);
        System.out.println();
        llist.printList();

        System.out.println("\n--------------");

        System.out.println("Element at index 2 : " + llist.getIndexElement(2));
    }
}