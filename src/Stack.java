public class Stack {
    
    Queue q1;
    Queue q2;

    public Stack() {
        this.q1 = new Queue();
        this.q2 = new Queue();
    }

    public void push(Node node) {
        if (q1.getHead() == null) {
            q1.enqueue(node);
        } else {
            while (q1.getHead() != null) {
                q2.enqueue(q1.dequeue());
            }
            q2.enqueue(node);
            while (q2.getHead() != null) {
                q1.enqueue(q2.dequeue());
            }
        }
    }

    public Node pop() {
        return this.q1.dequeue();
    }
}
