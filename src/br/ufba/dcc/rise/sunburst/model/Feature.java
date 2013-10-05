package br.ufba.dcc.rise.sunburst.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufba.dcc.rise.sunburst.model.enums.Type;
// TODO transform the Feature.class into a FeatureGroup.class
public class Feature extends Leaf {

	private String name;
	private Feature father;
	private Type type;
	
	public Feature(){
		this("");
	}

	public Feature(String name) {
		super();
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
	
	public Feature getFather(){
		return this.father;
	}

	private void setFather(Feature father) {
		this.father = father;
	}

	@Override
	public String toString(){
		return "f_"+this.name;
	}

	/**
	 * adds a mandatory feature.
	 * @param f
	 */
	@Override
	public void addChild(Leaf f) {
		addChild((Feature)f, Type.MANDATORY);
	}

	public void addChild(Feature child, Type relationship) {
		child.setFather(this);
		child.setRelationship(relationship);
		this.children.add(child);
	}

	private void setRelationship(Type type) {
		this.type = type;
	}

	private Type getType() {
		return this.type;
	}

	public boolean isMandatory() {
		return this.type == Type.MANDATORY ? true: false;
	}
	
	public boolean isOptional() {
		return this.type == Type.OPTIONAL ? true: false;
	}
	public boolean isXOR() {
		return this.type == Type.XOR ? true: false;
	}
	public boolean isOR() {
		return this.type == Type.OR ? true: false;
	}

	public List<Feature> getOptionalChildren() {
		return getChildrenByType(Type.OPTIONAL);
	}

	public List<Feature> getXORChildren() {
		return getChildrenByType(Type.XOR);
	}

	public List<Feature> getORChildren() {
		return getChildrenByType(Type.OR);
	}
	
	public List<Feature> getMandatoryChildren() {
		return getChildrenByType(Type.MANDATORY);
	}
	
	public List<Feature> getChildrenByType(Type t){
		List<Feature> list = new ArrayList<Feature>();
		for (Leaf l : this.children) {
			Feature f = (Feature) l;
			if (f.getType() == t) {
				list.add(f);
			}
		}
		return list;
	}
}
