package algorithms.l08graph;

import java.util.Collection;
import java.util.StringJoiner;

public class XGraphApp {

  public XGraph create() {
    XGraph g = new XGraph(17);
    g.add(0, 1);

    g.add(1, 2);
    g.add(1, 3);

    g.add(2, 4);
    g.add(2, 5);

    g.add(4, 8);
    g.add(4, 9);

    g.add(5, 10);
    g.add(5, 11);

    g.add(3, 6);
    g.add(3, 7);

    g.add(6, 12);

    g.add(7, 13);
    g.add(7, 14);

    g.add(12, 15);

    // cycle - will produce stack overflow in Graph.isConnectedBasic(from, to)
    g.add(6, 16);
    g.add(16, 3);

    return g;
  }

  private static String list_to_string(Collection<Integer> vertices) {
    StringJoiner sj = new StringJoiner(", ", "<", ">");
    vertices.forEach(n -> sj.add(String.valueOf(n)));
    return sj.toString();
  }

  private void print_traverse(String msg, Collection<Integer> data) {
    System.out.printf(msg, list_to_string(data));
  }

  public static void main(String[] args) {
    XGraphApp app = new XGraphApp();
    XGraph g = app.create();

    Paths paths = new Paths(g);
    Traversable<Integer> bfs_itr = new TraverseBFS(g);
    Traversable<Integer> dfs_itr = new TraverseDFSitr(g);
    Traversable<Integer> dfs_r1 = new TraverseDFSr1(g);
    Traversable<Integer> dfs_r2 = new TraverseDFSr2(g);

//    System.out.printf("Path (Basic) from 0 to 15:%b\n", paths.isConnectedBasic(0, 15)); // true
//    System.out.printf("Path (Basic) from 6 to 13:%b\n", paths.isConnectedBasic(6, 13)); // false
    System.out.printf("== Connection from 0 to 15: %b\n", paths.isConnected(0, 15)); // true
    System.out.printf("== Connection from 6 to 13: %b\n", paths.isConnected(6, 13)); // false
    System.out.printf("== Connection from 13 to 6: %b\n", paths.isConnected(13, 6)); // false
    System.out.printf("== Connection from 2 to 1 : %b\n", paths.isConnected(2, 1)); // false
    app.print_traverse("BFS traversal               : %s\n", bfs_itr.traverse(0));
    app.print_traverse("DFS traversal (recursive,v1): %s\n", dfs_r1.traverse(0));
    app.print_traverse("DFS traversal (recursive,v2): %s\n", dfs_r2.traverse(0));
    app.print_traverse("DFS traversal (iterative)   : %s\n", dfs_itr.traverse(0));
    app.print_traverse("== Path from 0 to 15: %s\n", paths.path(0, 15)); // <0, 1, 3, 6, 12, 15>
    app.print_traverse("== Path from 6 to 13: %s\n", paths.path(6, 13)); // <6, 16, 3, 7, 13>
    app.print_traverse("== Path from 2 to 3 : %s\n", paths.path(2, 3));  // <>
  }

}
