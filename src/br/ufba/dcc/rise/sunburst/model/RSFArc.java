package br.ufba.dcc.rise.sunburst.model;


public class RSFArc extends Leaf{

	private Feature feature;

	public RSFArc(Leaf l) {
		super();
		Feature f = (Feature)l;
		this.feature = f;
	}

	public String getLabel() {
		return this.feature.getName();
	}

	public void buildTree() {
		build(this);
	}

	private void build(RSFArc root) {
		for (Leaf l : root.getFeature().getChildren()) {
			Feature f = (Feature) l;
			RSFArc newArc = new RSFArc(f);
			build(newArc);
			root.addChild(newArc);
		}		
	}

	public Feature getFeature() {
		return this.feature;
	}

}
