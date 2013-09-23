package br.ufba.dcc.rise.sunburst.model;

public class RSFFeatureModel {

	private FeatureModel fm;
	private RSFArc treeRoot;
	
	public RSFFeatureModel(FeatureModel fm) {
		this.fm = fm;
		this.treeRoot = new RSFArc(fm.getRoot());
	}

	public FeatureModel getFeatureModel(){
		return this.fm;
	}
	public RSFArc getArcTree(){
		return this.treeRoot;
	}
	public int getNumberOfArcs() {
		return 0;
	}

	public void buildModel() {
		this.treeRoot.buildTree();
	}

	public int getDepth(){
		return getNumberOfLevels();
	}
	public int getNumberOfLevels() {
		return this.treeRoot.getNumberOfLevels();
	}

}
