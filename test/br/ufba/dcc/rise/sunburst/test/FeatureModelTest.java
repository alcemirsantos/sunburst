package br.ufba.dcc.rise.sunburst.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

import br.ufba.dcc.rise.sunburst.factory.FMFactory;
import br.ufba.dcc.rise.sunburst.model.FeatureModel;

public class FeatureModelTest {

	@Test
	public void testFeatureModelNotNull() {
		FeatureModel fm  = FMFactory.createFeatureModel();
		assertNotNull("feature model should not be null", fm);
	}
	
	@Test
	public void testFeatureModelRootNotNull() {
		FeatureModel fm  = FMFactory.createFeatureModelSample();
		assertNotNull("feature model root feature should not be null.", fm.getRoot());
	}
	
	@Test
	public void testFeatureModelSampleShouldHaveNFeatures(){
		int treeLevels = new Random().nextInt(10);		
		FeatureModel fm  = FMFactory.createFeatureModelSample(treeLevels);
		int numFeatures = 0;
		for(int i=0; i<=treeLevels; i++){
			numFeatures += Math.pow(2, i);
		}
		assertEquals("feature model should have at least "+numFeatures+" features.", numFeatures, fm.getNumberOfFeatures());
	}
	
	@Test
	public void testFeatureModelConstraintsNotNull(){
		FeatureModel fm  = FMFactory.createFeatureModelSample();
		assertNotNull("feature model constraints should not be null.", fm.getConstraints());
	}

}
