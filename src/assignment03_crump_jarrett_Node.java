class Node {
    
    Node next;
    Node prev;
    String tag;

    public Node(String tag) { // Default constructor
        this.next = null;
        this.prev = null;
        this.tag = tag;
    }

    // Sets the next node in the queue
    public void setNext(Node node) {
        this.next = node;
    }

    // Sets the previous node in the queue
    public void setPrev(Node node) {
        this.prev = node;
    }

    // Returns a reference to the next node
    public Node getNext() {
        return this.next;
    }

    // Returns a reference to the previous node
    public Node getPrev() {
        return this.prev;
    }

    // Returns the text of the tag associated with the node
    public String getTag() {
        return tag;
    }
}
