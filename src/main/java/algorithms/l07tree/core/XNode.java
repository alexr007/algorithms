package algorithms.l07tree.core;

public class XNode<T> {
  public final T value;
  public XNode<T> left;
  public XNode<T> right;

  public XNode(T value) {
    this(value, null, null);
  }

  // probably we need that constructor for delete implementation
  public XNode(T value, XNode<T> left, XNode<T> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return String.format("Node v:%s L:%s R:%s", value,
        left == null ? "_" : "N:"+left.value,
        right == null ? "_" : "N:"+right.value
    );
  }
}
