/**
 * ArrayHeap provides an array implementation of a minheap.
 */
public class ArrayHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T>{
  /**
   * Creates an empty heap.
   */
  public ArrayHeap(){
    super();
  }

  /**
   * Adds the specified element to this heap in the appropriate
   * position according to its key value.  
   *
   * @param obj the element to be added to the heap
   */
  public void addElement(T obj){
    if (!(obj instanceof Comparable)){
      throw new NonComparableElementException("ArrayHeap");
    }

    if(count == tree.length){
      expandCapacity();
    }

    tree[count] = obj;
    count++;

    if (count > 1){
      heapifyAdd();
    }
  }

  /**
   * swap a parent with a child
   */
  private void swap(int parent, int child){
    T temp = tree[parent];
    tree[parent] = tree[child];
    tree[child] = temp;
  }

  /**
   * Reorders this heap to maintain the ordering property after
   * adding a node.
   */
  private void heapifyAdd(){
    int child = count - 1; // start from last node added
    int parent = (child-1)/2; // find parent location

    boolean done = false;
    while (parent >= 0 && ! done){
      if (((Comparable) tree[parent]).compareTo(tree[child]) > 0){
        swap(parent, child);
        child = parent;
        parent = (child-1)/2;
      }else{
        done = true;
      }
    }
  }

  /**
   * Remove the element with the lowest value in this heap and
   * returns a reference to it. Throws an EmptyCollectionException if
   * the heap is empty.
   *
   * @return a reference to the element with the lowest value in this heap
   * @throws EmptyCollectionException if the heap is empty
   */
  public T removeMin() throws EmptyCollectionException{
    // TO BE IMPLEMENTED
    return null;
  }

  /**
   * Reorders this heap to maintain the ordering property
  * after the minimum element has been removed.
   */
  private void heapifyRemove(){
    // TO BE IMPLEMENTED
  }

  /**
   * Returns the element with the lowest value in this heap.
   * Throws an EmptyCollectionException if the heap is empty.
   *
   * @return the element with the lowest value in this heap
   * @throws EmptyCollectionException if the heap is empty
   */
  public T findMin() throws EmptyCollectionException{
    if (isEmpty()){
      throw new EmptyCollectionException("ArrayHeap");
    }
    return tree[0];
  }
}


