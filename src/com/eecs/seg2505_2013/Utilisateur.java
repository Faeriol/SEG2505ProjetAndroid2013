package com.eecs.seg2505_2013;

//Needs moar question and reponse

public class Utilisateur {
	private String nom;
	private int reputation;
	private Domaine domaines[];
	private Question questions[];
	private Reponse reponses[];
	
	public Utilisateur(){
		domaines = new Domaine[10]; 
		questions = new Question[10];
		reponses = new Reponse[10];
	}
	
	public Utilisateur(String nom){
		this();
		this.nom = nom;
	}
	
	public Utilisateur(String nom, int reputation){
		this(nom);
		this.reputation = reputation;
	}
	
	//Access methods pour question
	
	public void addQuestion(Question question){this.<Question>addElement(question); }
	
	public void addQuestion(String text, String date,Enum etat){this.addQuestion(new Question(text,date,etat)); }
	
	public Question[] getQuestions(){ return this.<Question>getElements(); }
	
	public Question getQuestion(){ return this.<Question>getElement(); }
	
	public boolean hasQuestion(Question question){ return this.<Question>hasElement(question); }
	
	public int getIndexOfQuestion(Question question){  return this.<Question>getIndexOf(question); }
	
	public void removeQuestion(Question question){ this.<Question>removeElement(question); }
	
	//Access methods pour Reponse
	
	public void addReponse(Reponse reponse){this.<Reponse>addReponse(reponse); }
	
	public void addResponse(String text, String date, String qualite){ this.addReponse(new Response(text,date,qualite)); }
	
	public Reponse[] getReponses(){ return this.<Reponse>getElements(); }
	
	public Reponse getResponse(int index) throws IllegalArgumentException { return this.<Reponse>getElement(index); }
	
	public boolean hasReponse(Reponse reponse){ return this.<Reponse>hasElement(reponse); }
	
	public int getIndexOfReponse(Reponse reponse){ return this.<Reponse>getIndexOf(reponse); }
	
	public void removeReponse(Reponse reponse){ this.<Reponse>removeElement(reponse); }
	
	//Access methods pour Domaine
	
	public void addDomaine(Domaine domaine){ this.<Domaine>addElement(domaine); }
	
	public void addDomaine(String nom){this.addDomaine(new Domaine(nom)); }
	
	public String[] getDomaines(){
		Domaine[] temp = this.<Domaine>getElements();
		String[] ret = new String[temp.length];
		for(int i=0;i<temp.length && temp[i] != null;i++){
			ret[i] = temp[i].getNom();
		}
		return ret;
	}
	
	public String getDomaineName(int index) throws IllegalArgumentException { return this.<Domaine>getElement(index).getNom(); }
	
	public boolean hasDomaine(Domaine domaine){ return this.<Domaine>hasElement(domaine); }
	
	public int getIndexOfDomaine(Domaine domaine){ return this.<Domaine>getIndexOf(domaine); }
	
	public void removeDomaine(Domaine domaine){ this.<Domaine>removeElement(domaine); }
	
	//Access methods pour Nom
	
	public void setNom(String name){ this.nom = name; }
	
	public String getNom(){ return this.nom; }
	
	//Access methods pour Reputation
	
	public void setReputation(int reputation){ this.reputation = reputation; }	
	
	public int getReputation(){ return this.reputation; }
	
	public void addToReputation(int add){ reputation += add; }
	
	//Equals, for this we assume two users can't have the same case insensitive name, hence the simplistic comparison
	
	public boolean equals(Utilisateur user){ return this.getNom().equalsIgnoreCase(user.getNom());}
	
	//To string
	
	public String toString(){
		String ret  = "Nom: "+ this.getNom() + "\n";
		ret = ret + "Domaines: " + domaines[0].getNom();
		for(int i=1;i<domaines.length &&domaines[i] != null;i++){
			ret += ", " + domaines[i].getNom();
		}
		ret += "\n"; 
		ret = "Questions: ";
		for(int i=1;i<questions.length &&questions[i] != null;i++){
			ret += questions[i].getText() + "\n\n";
		}
		ret = "Reponse: ";
		for(int i=1;i<reponses.length &&reponses[i] != null;i++){
			ret += reponses[i].getText() + "\n\n";
		}
		
		return ret;
	}
	
	//Private Generic Methods
	
	private <E> void makeBiggerArray(){
		E tst;
		Object[] array;
		if(tst instanceof Domaine){
			array = domaines;
		}else if(tst  instanceof Question){
			array = questions;
		}else if(tst instanceof Reponse){
			array = reponses;
		}
		if(array != null){
			Object[] temp = new Object[array.length*2];
			for(int i =0;i<array.length;i++){
				temp[i] = array[i];
			}
			if(tst instanceof Domaine){
				domaines = (Domaine[]) temp;
			}else if(tst  instanceof Question){
				questions = (Question[]) temp;
			}else if(tst instanceof Reponse){
				array = (Reponse[]) reponses;
			}
			
			temp = null;
			return;
		}
	}
	
	private <E> void removeElement(E element){
		Object[] temp;
		if(element instanceof Domaine){
			temp = domaines;
		}else if(element  instanceof Question){
			temp = questions;
		}else if(element instanceof Reponse){
			temp = reponses;
		}
		if(temp != null){
			for(int i= this.<E>getIndexOf(element);i!=-1 && i<temp.length-1 && temp[i] !=null;i++){
				temp[i]= temp[i+1];
				temp[i+1] = null;
			}
			    temp[temp.length-1] = null;
		}
	}
	
	private <E> int getIndexOf(E element){
		Object[] temp;
		if(element instanceof Domaine){
			temp = domaines;
		}else if(element  instanceof Question){
			temp = questions;
		}else if(element instanceof Reponse){
			temp = reponses;
		}
		if(temp !=null){
			for(int i = 0;i<temp.length && temp[i] !=null;i++){
				if(element.equals(temp[i])){
					return i;
				}
			}
		}
		return -1;
		
	}
	
	private <E> boolean hasElement(E element){
		Object[] temp;
		if(element instanceof Domaine){
			temp = domaines;
		}else if(element instanceof Question){
			temp = questions;
		}else if(test instanceof Reponse){
			temp = reponses;
		}
		if(temp !=null){
		for(int i=0;temp[i]!=null &&i<temp.length;i++){
			if(element.equals(domaines[i])){
				return true;
			}
		}
		}
		
		return false;
	}
	
	private <E> E getElement(int index){
		E test;
		Object[] temp;
		if(test instanceof Domaine){
			temp = domaines;
		}else if(test  instanceof Question){
			temp = questions;
		}else if(test instanceof Reponse){
			temp = reponses;
		}
		if(temp != null){
			if(index>0 && index< temp.length-1){
				if(test instanceof Domaine){
					return (E)(new Domaine(domaines[index].getNom()));
				}else{
					return (E)temp[index].deepCopy();
				}
			}else{
				throw new IllegalArgumentException();
			}
		}
	}
	
	private <E>void addElement(E element){
		Object[] temp;
		if(element instanceof Domaine){
			temp = domaines;
		}else if(element instanceof Question){
			temp = questions;
		}else if(element instanceof Reponse){
			temp = reponses;
		}
		if(temp !=null){
			int i;
			for(i=0;i<temp.length;i++){
				if(temp[i] ==null){
					temp[i] = element;
					break;
				}
			}
			
			if(i == temp.length){
				this.<E>makeBiggerArray();
				temp[i] = element;
			}
			return;
		}
	}
	
	private <E> E[] getElements(){
		E test;
		Object[] temp;
		if(test instanceof Domaine){
			temp = domaines;
		}else if(test instanceof Question){
			temp = questions;
		}else if(test instanceof Reponse){
			temp = reponses;
		}
		if(temp !=null){
			if(test instanceof Domaine){
				for(int i=0;domaines[i]!=null &&i<domaines.length;i++){
					temp[i] = (E)new Domaine(domaines[i].getNom());
				}
			}else{
				for(int i=0;temp[i]!=null &&i<temp.length;i++){
					temp[i] = (E)temp[i].deepCopy();
				}
			}
			
			return (E[])temp;
		}
	}
	
}