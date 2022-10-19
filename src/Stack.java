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
            q2.enqueue(node);
            while (q1.getHead() != null) {
                q2.enqueue(q1.dequeue());
            }
            while (q2.getHead() != null) {
                q1.enqueue(q2.dequeue());
            }
        }
    }

    public Node pop() {
        return this.q1.dequeue();
    }

    public boolean isEmpty() {
        if (this.q1.getHead() == null) {
            return true;
        }
        else {
            return false;
        }
    }
}
