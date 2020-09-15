package algorithms.l08graph.rep.undir;

import algorithms.l08graph.rep.AbstractGraphA;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * I intentionally made it abstract to force user
 * to create a new instance with the new underlying structure
 * by declaring the new class and further usage it
 */
public abstract class GraphA<L extends Collection<Integer>> extends AbstractGraphA<L> {

  public GraphA(int v, Supplier<L> constructorRef) {
    super(v, constructorRef);
  }

  /**
   * I don't care if given v index
   * isn't in my array
   */
  @Override
  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
  }

  @Override
  public void removeEdge(int v, int w) {
    adj[v].remove(w);
    adj[w].remove(v);
  }

}
