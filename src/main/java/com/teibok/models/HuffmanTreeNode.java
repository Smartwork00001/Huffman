package com.teibok.models;

public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {
    byte byt;
	int freq;
    HuffmanTreeNode left, right;
    HuffmanTreeNode(byte byt, int freq){
        this.byt = byt;
        this.freq = freq;
        this.left = this.right = null;
    }

    public int compareTo(HuffmanTreeNode other){
        return this.freq - other.freq;
    }
    
    public byte getByt() {
		return byt;
	}

	public void setByt(byte byt) {
		this.byt = byt;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public HuffmanTreeNode getLeft() {
		return left;
	}

	public void setLeft(HuffmanTreeNode left) {
		this.left = left;
	}

	public HuffmanTreeNode getRight() {
		return right;
	}

	public void setRight(HuffmanTreeNode right) {
		this.right = right;
	}
}

