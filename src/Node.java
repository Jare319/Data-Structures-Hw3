public class Node {
    
    Node next;
    Node prev;
    String tag;

    public Node() {
        this.next = null;
        this.prev = null;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public void setPrev(Node node) {
        this.prev = node;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }
}
