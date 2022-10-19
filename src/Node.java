public class Node {
    
    Node next;
    Node prev;
    String tag;

    public Node(String tag) {
        this.next = null;
        this.prev = null;
        this.tag = tag;
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

    public String getTag() {
        return tag;
    }
}
