package br.ufba.dcc.rise.sunburst.factory;

import br.ufba.dcc.rise.sunburst.model.Feature;
import br.ufba.dcc.rise.sunburst.model.FeatureModel;

public class FMFactory {

	public static FeatureModel createFeatureModel() {
		return new FeatureModel();
	}

	public static FeatureModel createFeatureModelSample() {
		Feature f = new Feature();
		return new FeatureModel(f);
	}

	public static FeatureModel createFeatureModelSample(int treeLevels) {
		Feature root = new Feature();
		buildFeatureModelTree(root,treeLevels);
		return new FeatureModel(root);
	}

	private static void buildFeatureModelTree(Feature root, int treeLevels){
		Feature a;
		Feature b;
		if(treeLevels>0){
			a = new Feature();
			b = new Feature();
			buildFeatureModelTree(a, treeLevels-1);
			buildFeatureModelTree(b, treeLevels-1);
			root.addChild(a);
			root.addChild(b);
		}
	}
}
