package com.simplij.SimpliJ.data.structures;

public class Pair<T, U> {
	private T item1;
	private U item2;
	
	public Pair() {}
	
	public Pair(T item1, U item2) {
		this.item1 = item1;
		this.item2 = item2;
	}

	public T getItem1() {
		return item1;
	}

	public void setItem1(T item1) {
		this.item1 = item1;
	}

	public U getItem2() {
		return item2;
	}

	public void setItem2(U item2) {
		this.item2 = item2;
	}
}