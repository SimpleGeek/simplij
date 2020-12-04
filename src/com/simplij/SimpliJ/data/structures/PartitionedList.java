package com.simplij.SimpliJ.data.structures;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a partitioned list.  This class
 * wraps a list, and will return partitions (or sublists) from the list,
 * based on the desired partition size.  For instance, if an instance of
 * this class is created with a list of 25 elements and a partition size
 * of 5, partitionList.get(0) would get elements 0-4 from the wrapped list.
 * Calling get(1) would grab elements 5-9, and so on.  IF the list size isn't
 * cleanly divisible by the partition size, then the last partition will just
 * contain as many elements as are remaining.
 * <br><br>
 * Based off of an implementation by Szymon Stepniak at
 * this blog post here: https://e.printstacktrace.blog/divide-a-list-to-lists-of-n-size-in-Java-8
 * 
 * @author Isaiah Edwards
 *
 * @param <T>
 */
public class PartitionedList<T> extends AbstractList<List<T>> {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2282675222489824406L;
	private List<T> list;
	private int partitionSize;
	
	public PartitionedList(List<T> list, int partitionSize) {
		if (partitionSize < 1) {
			throw new IllegalArgumentException("Partition sizes must be at least 1.  Received: " + partitionSize);
		}
		
		this.list = list;
		this.partitionSize = partitionSize;
	}
	
	@Override
	public List<T> get(int index) {
		int start = index * partitionSize;
		int end = Math.min(start + partitionSize, list.size());
		
		if (start > end) {
			throw new IndexOutOfBoundsException("Index of " + index + " is out of bounds in list of size " + size());
		}
		
		return new ArrayList<>(list.subList(start, end));
	}
	
	@Override
	public int size() {
		return (int) Math.ceil((double) list.size() / (double) partitionSize);
	}
	
	// Getters/Setters
	public int getPartitionSize() {
		return partitionSize;
	}

	public void setPartitionSize(int partitionSize) {
		this.partitionSize = partitionSize;
	}
}
