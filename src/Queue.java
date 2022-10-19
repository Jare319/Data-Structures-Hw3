public class Queue {

    Node head;
    Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(Node node) {
        // Handles when queue is empty
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else { // Handles every other case
            Node temp = this.head;
            this.head = node;
            node.setNext(temp);
            temp.setPrev(node);
        }
    }

    public Node dequeue() {
        // Handles when the node being removed
        if (this.head.getNext() == null) {
            Node temp = this.head;
            this.head = null;
            this.tail = null;
            return temp;
        } else { // Handles every other case
            Node temp = this.tail;
            this.tail = this.tail.getPrev();
            temp.setPrev(null);
            this.tail.setNext(null);
            return temp;
        }

    }

    // Returns head node
    public Node getHead() {
        return head;
    }

    // Returns tail node
    public Node getTail() {
        return tail;
    }
}
