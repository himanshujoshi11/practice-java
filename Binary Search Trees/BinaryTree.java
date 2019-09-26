import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node<K, V> getRoot() {
        return this.root;
    }

    public void add(K key, V value) {
      Queue<Node<K,V>> q = new LinkedList<>();

      Node<K,V> temp = this.root;
      q.add(temp);
        if (this.root == null){
            this.root = new Node(key, value);
            return;
        }
      while(!q.isEmpty()){
        temp = q.peek();
        q.remove();

        if (temp == null){
          temp = new Node(key, value);
          break;
        }
        if(temp.getKey().compareTo(key) == 0){
            temp.setValue(value);
        }
        if (temp.getLeft() == null && temp.getKey().compareTo(key) > 0)  {
            temp.setLeft(new Node(key, value));
            break;

        }

        else if (temp.getKey().compareTo(key) > 0){
            q.add(temp.getLeft());
          }

        if (temp.getRight() == null&& temp.getKey().compareTo(key) < 0) {
            temp.setRight(new Node(key, value));
            break;
        }

        else if(temp.getKey().compareTo(key) < 0){
            q.add(temp.getRight());
          }
    }
  }


    public V find(K key) {
      Queue<Node<K,V>> q = new LinkedList<>();
      Node<K,V> temp = this.root;
      if (temp.getKey()==key){
        return temp.getValue();
      }

      q.add(temp);
      while(!q.isEmpty()){
        temp = q.peek();
        q.remove();

        if (temp.getLeft()!= null && temp.getLeft().getKey() == key ){
            return temp.getLeft().getValue();
        } else if (temp.getLeft()!= null){
            q.add(temp.getLeft());
          }

          if (temp.getRight()!= null && temp.getRight().getKey() == key){
              return temp.getRight().getValue();
          } else if (temp.getRight()!= null){
              q.add(temp.getRight());
            }
    }
    return null;
  }

    @SuppressWarnings("unchecked")
    public V[] flatten() {

        ArrayList<V> toReturn = new ArrayList<V>();

        Queue<Node<K,V>> q = new LinkedList<>();
        Node<K,V> temp = this.root;


        q.add(temp);
        while(!q.isEmpty()){
            toReturn.ensureCapacity(toReturn.size() +1);
            if(q.peek() == null){
                break;
            }
            else{
            temp = q.peek();
            toReturn.add(temp.getValue());
            q.remove();
            }
            if (temp.getLeft()!= null ){
                q.add(temp.getLeft());
            }

            if (temp.getRight()!= null ){
                q.add(temp.getRight());
            }
        }

        return (V[]) toReturn.toArray();
    }

    public void remove(K key) {

    }

    public boolean containsSubtree(BinaryTree<K, V> other) {
        return false;
    }
}
