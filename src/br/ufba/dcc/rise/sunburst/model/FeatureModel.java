package br.ufba.dcc.rise.sunburst.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FeatureModel {

	private Feature root;
	private List<Constraint> constraints;

	public FeatureModel(){
		this(new Feature(), new ArrayList<Constraint>());
	}
	
	public FeatureModel(Feature root) {
		this(root, new ArrayList<Constraint>());
	}
	
	public FeatureModel(Feature root, List<Constraint> constraints) {
		this.root = root;
		this.constraints = constraints;
	}

	public Feature getRoot() {
		return this.root;
	}

	public List<Constraint> getConstraints() {
		return this.constraints;
	}

	public int getNumberOfFeatures() {
		int numFeatures;
		if(this.root==null) return 0;
		else if(this.root.hasChildren())
			numFeatures = this.root.getFamilySize() +1;
		else
			return 1;
		return numFeatures;
	}

	@Override
	public String toString(){
		return printTree(this.root);
	}
	
	private String printTree(Feature root){
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		String NEW_TAB = "\t";

		result.append(root+"::["+NEW_LINE);
		
		if(this.root.hasChildren()){
			
			for (Iterator<Feature> i = this.root.getChildren().iterator(); i.hasNext();) {
				Feature f = i.next();
				result.append(NEW_TAB+printTree(f));
			}
			result.append("]");
		}
		return result.toString();
	}
}
