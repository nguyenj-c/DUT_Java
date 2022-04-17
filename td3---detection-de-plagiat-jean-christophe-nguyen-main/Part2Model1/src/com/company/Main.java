package com.company;

public class Main {

    public static void main(String[] args) {
	ComparaisonEtudiant comparatorParId = new ComparaisonParId();
	ComparaisonEtudiant comparatorParNom = new ComparaisonParNom();

	Promotion myPromotion = new Promotion();
	myPromotion.addEtudiant(new Etudiant("Nguyen","Jean Christophe",4));
	myPromotion.addEtudiant(new Etudiant("Ancelin","Floflo",2));
	myPromotion.addEtudiant(new Etudiant("Amar","Camélia",3));
	myPromotion.addEtudiant(new Etudiant("Duval","Lucas",1));
	myPromotion.addEtudiant(new Etudiant("Nguyen","Kevin",5));
	myPromotion.sort(comparatorParId);
	System.out.println(myPromotion);
    }
}
