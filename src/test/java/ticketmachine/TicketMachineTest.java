package ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Classe de test pour la classe TicketMachine.
 * Contient des tests unitaires pour vérifier le comportement de la machine à tickets.
 */
class TicketMachineTest {
    private static final int PRICE = 50; // Prix d'un ticket en centimes
    private TicketMachine machine; // Instance de la machine à tickets utilisée pour les tests

    /**
     * Initialise une nouvelle instance de TicketMachine avant chaque test.
     */
    @BeforeEach
    public void setUp() {
        machine = new TicketMachine(PRICE);
    }

    /**
     * Vérifie que le prix est correctement initialisé lors de la création de la machine.
     */
    @Test
    void testPriceIsCorrectlyInitialized() {
        assertEquals(PRICE, machine.getPrice(), "Le prix initial devrait être de 50 centimes");
    }

    /**
     * Vérifie que l'insertion d'argent met correctement à jour la balance.
     */
    @Test
    void testInsertMoneyChangesBalance() {
        machine.insertMoney(10);
        machine.insertMoney(20);
        assertEquals(30, machine.getBalance(), "La balance n'est pas correctement mise à jour");
    }

    /**
     * Vérifie qu'un ticket ne peut pas être imprimé si le montant inséré est insuffisant.
     */
    @Test
    void testNoPrintIfNoMoney() {
        machine.insertMoney(PRICE-1);
        assertFalse(machine.printTicket(), "Le ticket ne doit PAS être imprimé si pas assez d'argent");
    }

    /**
     * Vérifie qu'un ticket est imprimé si le montant inséré est suffisant.
     */
    @Test
    void testPrintIfEnoughMoney() {
        machine.insertMoney(PRICE);
        assertTrue(machine.printTicket(), "Le ticket DOIT être imprimé si le montant est suffisant");
    }

    /**
     * Vérifie que la balance diminue correctement après l'impression d'un ticket.
     */
    @Test
    void testBalanceDecreasesAfterPrinting() {
        machine.insertMoney(PRICE);
        machine.printTicket();
        assertEquals(0, machine.getBalance(), "La balance n'a pas été débitée");
    }

    /**
     * Vérifie que le total collecté augmente correctement après l'impression d'un ticket.
     */
    @Test
    void testTotalIncreasesAfterPrinting() {
        machine.insertMoney(PRICE);
        assertEquals(0, machine.getTotal(), "Le total ne doit pas changer tant que le ticket n'est pas imprimé");
        machine.printTicket();
        assertEquals(PRICE, machine.getTotal(), "Le total collecté doit inclure le prix du ticket vendu");
    }

    /**
     * Vérifie que la méthode refund retourne le bon montant inséré.
     */
    @Test
    void testRefundReturnsCorrectBalance() {
        machine.insertMoney(30);
        assertEquals(30, machine.refund(), "La méthode refund n'a pas retourné le bon montant");
    }

    /**
     * Vérifie que la balance est remise à zéro après un remboursement.
     */
    @Test
    void testRefundResetsBalance() {
        machine.insertMoney(30);
        machine.refund();
        assertEquals(0, machine.getBalance(), "La balance n'a pas été remise à zéro après remboursement");
    }

    /**
     * Vérifie qu'il est impossible d'insérer un montant négatif.
     * Une exception IllegalArgumentException doit être levée.
     */
    @Test
    void testCannotInsertNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            machine.insertMoney(-10);
        }, "Insérer un montant négatif devrait lever une exception");
    }

    /**
     * Vérifie qu'il est impossible de créer une machine avec un prix de ticket négatif.
     * Une exception IllegalArgumentException doit être levée.
     */
    @Test
    void testCannotCreateMachineWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TicketMachine(-10);
        }, "Créer une machine avec un prix négatif devrait lever une exception");
    }
}
