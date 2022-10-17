public class Queue {

    Node head;
    Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(Node node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            Node temp = this.head;
            this.head = node;
            node.setNext(temp);
            temp.setPrev(node);
        }
    }

    public Node dequeue() {
        if (this.head.getNext() == null) {
            Node temp = this.head;
            this.head = null;
            this.tail = null;
            return temp;
        } else {
            Node temp = this.tail;
            this.tail = this.tail.getPrev();
            temp.setPrev(null);
            this.tail.setNext(null);
            return temp;
        }

    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
