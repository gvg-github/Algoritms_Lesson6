class BinarySearchTree {

    Node root;

    static class Node {
        int key;
        int value;
        Node l;
        Node r;
        Node p;

        public Node(int key, int value, Node p) {
            this.key = key;
            this.value = value;
            this.p = p;
        }
    }

    Node search(Node t, int key) {
        if (t == null || t.key == key)
            return t;
        if (key < t.key)
            return search(t.l, key);
        else
            return search(t.r, key);
    }

    public Node search(int key) {
        return search(root, key);
    }

    Node insert(Node t, Node p, int key, int value) {
        if (t == null) {
            t = new Node(key, value, p);
        } else {
            if (key < t.key)
                t.l = insert(t.l, t, key, value);
            else
                t.r = insert(t.r, t, key, value);
        }
        return t;
    }

    public void insert(int key, int value) {
        root = insert(root, null, key, value);
    }

    void replace(Node a, Node b) {
        if (a.p == null)
            root = b;
        else if (a == a.p.l)
            a.p.l = b;
        else
            a.p.r = b;
        if (b != null)
            b.p = a.p;
    }

    void remove(Node t, int key) {
        if (t == null)
            return;
        if (key < t.key)
            remove(t.l, key);
        else if (key > t.key)
            remove(t.r, key);
        else if (t.l != null && t.r != null) {
            Node m = t.r;
            while (m.l != null)
                m = m.l;
            t.key = m.key;
            t.value = m.value;
            replace(m, m.r);
        } else if (t.l != null) {
            replace(t, t.l);
        } else if (t.r != null) {
            replace(t, t.r);
        } else {
            replace(t, null);
        }
    }

    public void remove(int key) {
        remove(root, key);
    }

    void print(Node t, int mode) {
        if (t != null) {
            if (mode == 1) {
                System.out.print(t.key + ":" + t.value + " ");
                print(t.l, mode);
                print(t.r, mode);
            } else if (mode == 2) {
                print(t.l, mode);
                System.out.print(t.key + ":" + t.value + " ");
                print(t.r, mode);
            } else if (mode == 3) {
                print(t.l, mode);
                print(t.r, mode);
                System.out.print(t.key + ":" + t.value + " ");
            }
        }
    }

    public void print(int mode) {
        print(root, mode);
        System.out.println();
    }
}
