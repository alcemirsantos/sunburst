package br.ufba.dcc.rise.sunburst.model;

import java.util.ArrayList;
import java.util.List;

public class RSFArc {

	private Feature feature;
	private List<RSFArc> children;

	public RSFArc(Feature f) {
		this.feature = f;
		this.children = new ArrayList<RSFArc>();
	}

	public String getLabel() {
		return this.feature.getName();
	}

	public void buildTree() {
		build(this);
	}

	private void build(RSFArc root) {
		for (Feature f : root.getFeature().getChildren()) {
			RSFArc arc = new RSFArc(f);
			build(arc);
			root.addChild(arc);
		}		
	}

	public Feature getFeature() {
		return this.feature;
	}

	public void addChild(RSFArc arc) {
		this.children.add(arc);
	}

	public int getDepth(){
		return getNumberOfLevels();
	}
	public int getNumberOfLevels() {
		if (this.children.isEmpty()) 
			return 0;
		else 
			return getBiggerDepth(this);
	}
	private int getBiggerDepth(RSFArc arc){
		int depth=0;
		int biggerDepth = 0;
		for (RSFArc a : arc.getChildren()) {
			depth = a.getNumberOfLevels();
			if (depth>biggerDepth) {
				biggerDepth = depth;
			}
		}
		return biggerDepth+1;
	}

	public boolean hasChildren() {
		return this.children.isEmpty()? false:true;
	}

	public List<RSFArc> getChildren() {
		return this.children;
	}

}
