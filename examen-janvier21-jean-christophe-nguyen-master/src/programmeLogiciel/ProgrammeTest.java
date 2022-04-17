package programmeLogiciel;

public class ProgrammeTest {
	public static void main(String[] args) {
		System.out.println("TEST 1 : succès du IF : doit afficher bravo :");
		Instruction prog = new IF("toto", new AppelAfficher("bravo !"));
		prog.exec();

		/* ne doit rien afficher (condition fausse) : */
		System.out.println("\nTEST 2 : échec du IF : ne doit rien afficher :");
		prog = new IF("TATA", new AppelAfficher("essaye encore..."));
		prog.exec();

		System.out.println("\nTEST 3 : séquence d'instructions dans le corps du IF :");
		SequenceInstructions corpsIf = new SequenceInstructions();
		prog = new IF("toto", corpsIf);
		corpsIf.ajouterInstruction(new AppelAfficher("1ère instruction dans corps"));
		corpsIf.ajouterInstruction(new AppelAfficher("2ème instruction dans corps"));
		prog.exec();
	}
}
