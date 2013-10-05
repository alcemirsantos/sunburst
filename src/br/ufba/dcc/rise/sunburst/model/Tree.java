package br.ufba.dcc.rise.sunburst.model;

import java.util.Iterator;

public abstract class Tree {

	protected Leaf root;

	public Tree(){}
	public Tree(Leaf root) {
		this.root = root;
	}
	
	/**
	 * Returns <code>true</code> if there is any child and <code>false</code> otherwise.
	 * 
	 * @return a flag indicating if there is any child.
	 */
	public boolean hasChildren(){
		return this.root == null ? false: true;
	}
	/**
	 * Returns an instance of {@link Leaf} that is the root of this tree.
	 * @return the root of this tree.
	 */
	public Leaf getRoot(){
		return this.root;
	}

	/**
	 * @return the depth of this tree.
	 */
	public int getDepth(){
		return this.root.getDepth();
	}

	@Override
	public String toString() {
		return printTree(root);
	}

	private String printTree(Leaf root) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		String NEW_TAB = "\t";

		result.append(root + "::[" + NEW_LINE);

		if (this.root.hasChildren()) {

			for (Iterator<Leaf> i = this.root.getChildren().iterator(); i
					.hasNext();) {
				Leaf f = i.next();
				result.append(NEW_TAB + printTree(f));
			}
			result.append("]");
		}
		return result.toString();
	}

} // end of the Tree class
