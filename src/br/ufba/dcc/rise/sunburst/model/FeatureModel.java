package br.ufba.dcc.rise.sunburst.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FeatureModel extends Tree {

	private List<CrossTreeConstraint> constraints;

	public FeatureModel(){
		this(new Feature(), new ArrayList<CrossTreeConstraint>());
	}
	
	public FeatureModel(Feature root) {
		this(root, new ArrayList<CrossTreeConstraint>());
	}
	
	public FeatureModel(Feature root, List<CrossTreeConstraint> constraints) {
//		this.root = root;
		super(root);
		this.constraints = constraints;
	}

	public List<CrossTreeConstraint> getConstraints() {
		return this.constraints;
	}

	public int getNumberOfFeatures() {
		int numFeatures;
		if(this.root==null) return 0;
		else if(this.root.hasChildren())
			numFeatures = this.root.getTreeSize() +1;
		else
			return 1;
		return numFeatures;
	}

}
