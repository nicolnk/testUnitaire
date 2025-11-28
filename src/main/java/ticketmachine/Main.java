package ticketmachine;

public class Main {

	public static void main(String[] args) {
		TicketMachine machine = new TicketMachine(50);
		System.out.println("L'utilisateur insère 60 centimes");
		machine.insertMoney(60);
		System.out.println("L'utilisateur appuie sur 'Impression ticket'");
		machine.printTicket();
        System.out.println("Voici votre reçu");
        System.out.println("Voici le reste de votre montant : " + machine.getBalance() + " centimes");
        machine.refund();
	}
}
