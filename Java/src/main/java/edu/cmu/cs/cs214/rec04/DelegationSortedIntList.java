package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    private int totalAdded;
    private IntegerList sortedIntList;

    public DelegationSortedIntList() {
        this.totalAdded = 0;
        this.sortedIntList = new SortedIntList();
    }

    @Override
    public boolean add(int num) {
        boolean success = this.sortedIntList.add(num);
        if (success) {
            this.totalAdded++;
        }
        return success;
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean success = this.sortedIntList.addAll(list);
        if (success) {
            this.totalAdded += list.size();
        }
        return success;
    }

    @Override
    public int get(int index) {
        return this.sortedIntList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return this.sortedIntList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return this.sortedIntList.removeAll(list);
    }

    @Override
    public int size() {
        return this.sortedIntList.size();
    }
    

    public int getTotalAdded() {
        return this.totalAdded;
    }
}