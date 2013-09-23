package br.ufba.dcc.rise.sunburst.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	SunburstTest.class,
	RSFFeatureModelTest.class, 
	FeatureModelTest.class, 
	FeatureRelationshipsTest.class })
public class AllTests {

}
