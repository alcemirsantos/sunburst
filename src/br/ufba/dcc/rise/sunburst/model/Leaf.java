package br.ufba.dcc.rise.sunburst.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Leaf {

	protected List<Leaf> children;
	
	public Leaf(){
		this.children = new ArrayList<Leaf>(); 
	}
	/**
	 * Adds a new child to this leaf.
	 * @param the leaf child
	 */
	public void addChild(Leaf child){
		this.children.add(child);
	}
	/**
	 * Returns <code>true</code> if there is any child and <code>false</code> otherwise.
	 * 
	 * @return a flag indicating if there is any children
	 */
	public boolean hasChildren(){
		return !children.isEmpty();
	}
	/**
	 * Returns a list of children of this leaf.
	 * 
	 * @return the list of children.
	 */
	public List<Leaf> getChildren(){
		return children;
	}
	
	/**
	 * Calculates the depth of this subtree.
	 * @return the depth of this leaf.
	 */
	public int getDepth(){
		if (this.children.isEmpty()) 
			return 0;
		else 
			return getBiggerDepth(this);
	}
	private int getBiggerDepth(Leaf arc){
		int depth=0;
		int biggerDepth = 0;
		for (Leaf a : arc.getChildren()) {
			depth = a.getDepth();
			if (depth>biggerDepth) {
				biggerDepth = depth;
			}
		}
		return biggerDepth+1;
	}
	
	public int getTreeSize(){
		int num = 0;
		if (this.children.isEmpty()) {
			return num;
		}else{
			num = this.children.size();
			for (Leaf f : this.children) {
				num += f.getTreeSize();
			}
		}
		return num;
	}
} // end of the Leaf Class
