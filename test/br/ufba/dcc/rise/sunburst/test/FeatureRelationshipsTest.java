package br.ufba.dcc.rise.sunburst.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.ufba.dcc.rise.sunburst.model.Feature;
import br.ufba.dcc.rise.sunburst.model.enums.Type;

public class FeatureRelationshipsTest {

	@Test
	public void testSetFeatureType() {
		Feature f = new Feature();
		f.addChild(new Feature("aChild")); // mandatory
		f.addChild(new Feature("bChild"), Type.OPTIONAL); // optional
		f.addChild(new Feature("bbChild"), Type.OPTIONAL); // optional
		f.addChild(new Feature("cChild"), Type.XOR); // xor
		f.addChild(new Feature("ccChild"), Type.XOR); // xor
		f.addChild(new Feature("cccChild"), Type.XOR); // xor
		f.addChild(new Feature("dChild"), Type.OR); // or
		f.addChild(new Feature("ddChild"), Type.OR); // or
		f.addChild(new Feature("dddChild"), Type.OR); // or
		f.addChild(new Feature("ddddChild"), Type.OR); // or
		List<Feature> mandatories = f.getMandatoryChildren();
		List<Feature> optionals = f.getOptionalChildren();
		List<Feature> xors = f.getXORChildren();
		List<Feature> ors = f.getORChildren();
		assertEquals("should exist only one mandatory feature.", 1, mandatories.size());
		assertEquals("should exist only two optional features.", 2, optionals.size());
		assertEquals("should exist only three XOR features.", 3, xors.size());
		assertEquals("should exist only four OR features.", 4, ors.size());
	}

}
