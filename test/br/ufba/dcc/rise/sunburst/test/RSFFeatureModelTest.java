package br.ufba.dcc.rise.sunburst.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufba.dcc.rise.sunburst.factory.FMFactory;
import br.ufba.dcc.rise.sunburst.model.Feature;
import br.ufba.dcc.rise.sunburst.model.FeatureModel;
import br.ufba.dcc.rise.sunburst.model.Leaf;
import br.ufba.dcc.rise.sunburst.model.RSFArc;
import br.ufba.dcc.rise.sunburst.model.RSFFeatureModel;

public class RSFFeatureModelTest {

	@Test
	public void testCreateRadialRepresentation(){
		int numLevels = 3;
		FeatureModel fm = FMFactory.createFeatureModelSample(3);
		RSFFeatureModel rsfFM = new  RSFFeatureModel(fm);
		
		rsfFM.buildModel();
		
		assertEquals("the model should have the same number of levels of the feature model.", numLevels, rsfFM.getDepth());
	}
	
	@Test
	public void testCreateArcs(){
		int numLevels = 3;
		FeatureModel fm = FMFactory.createFeatureModelSample(numLevels);
		RSFFeatureModel rsf = new RSFFeatureModel(fm);
		
		rsf.buildModel();
		
		assertConsistecyBetweenArcsAndFeatures(rsf.getArcTree());
	}
	private void assertConsistecyBetweenArcsAndFeatures(RSFArc arc){
		int expected = arc.getFeature().getChildren().size();
		int real = arc.getChildren().size();
		assertEquals("the model should have the same number of arcs as the the feature model has leaves at this level.", expected, real);
		for (Leaf l : arc.getChildren()) {
			RSFArc a = (RSFArc)l;
			assertConsistecyBetweenArcsAndFeatures(a);
		}
	}
	
	@Test
	public void testArcLabelSynchonized2FeatureName(){
		Feature f = new Feature("aFeature");
		RSFArc arc = new RSFArc(f);
		
		assertEquals("the label of the arc must be the same as the feature associated.", f.getName(), arc.getLabel());
	}
	
}
