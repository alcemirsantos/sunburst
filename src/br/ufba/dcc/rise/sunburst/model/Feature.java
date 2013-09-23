package br.ufba.dcc.rise.sunburst.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufba.dcc.rise.sunburst.model.enums.Type;

public class Feature {

	private String name;
	private Feature father;
	private List<Feature> children; // TODO transform the Feature.class into a FeatureGroup.class  
	private Type type;
	
	public Feature(){
		this("");
	}

	public Feature(String name) {
		this.name = name;
		this.children = new ArrayList<Feature>();
	}

	public Boolean hasChildren() {
		return !this.children.isEmpty();
	}

	public String getName(){
		return this.name;
	}
	
	public List<Feature> getChildren() {
		return this.children;
	}

	public Feature getFather(){
		return this.father;
	}

	private void setFather(Feature father) {
		this.father = father;
	}

	public int getFamilySize() {
		int num = 0;
		if (this.children.isEmpty()) {
			return num;
		}else{
			num = this.children.size();
			for (Feature f : this.children) {
				num += f.getFamilySize();
			}
		}
		return num;
	}

	@Override
	public String toString(){
		return "f_"+this.name;
	}

	/**
	 * adds a mandatory feature.
	 * @param f
	 */
	public void addChild(Feature f) {
		addChild(f, Type.MANDATORY);
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
		for (Feature f : this.children) {
			if (f.getType() == t) {
				list.add(f);
			}
		}
		return list;
	}
}
