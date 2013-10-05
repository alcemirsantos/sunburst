package br.ufba.dcc.rise.sunburst.model;

public class RSFFeatureModel extends Tree {

	private FeatureModel fm;

	public RSFFeatureModel(FeatureModel fm) {
		super(new RSFArc(fm.getRoot()));
		this.fm = fm;
	}

	public FeatureModel getFeatureModel() {
		return this.fm;
	}

	public RSFArc getArcTree() {
		return (RSFArc) this.root;
	}

	public int getNumberOfArcs() {
		return 0;
	}

	public void buildModel() {
		((RSFArc) this.root).buildTree();
	}

	// TODO recursively draw tree(root);
	public void drawSunburst(Feature root) {
		// TODO draw actual feature;
		// TODO draw children
		for (Leaf l : root.getChildren()) {
			Feature f = (Feature) l;
			drawSunburst(f);
		}
	}

}
