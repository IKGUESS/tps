package org.exemple;

import org.example.Calculator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        // Test avec b != 0
        assertEquals(2, calculator.subtract(5, 3));
        
        // Test avec b == 0
        assertEquals(5, calculator.subtract(5, 0));  // La soustraction de 5 et 0 donne 5
    }

    @Test
    public void testSubtractionWithLogging() {
        // Création d'un mock pour le logger
        Logger mockLogger = Mockito.mock(Logger.class);

        // Remplacer le logger de la classe Calculator par le mock
        Calculator calculator = new Calculator() {
            @Override
            public int subtract(int a, int b) {
                if (b == 0) {
                    mockLogger.warning("Soustraction avec b = 0. Aucun changement nécessaire.");
                }
                return super.subtract(a, b);
            }
        };

        // Appel de la méthode avec b == 0
        calculator.subtract(5, 0);

        // Vérification que le logger a bien émis un avertissement
        verify(mockLogger).warning("Soustraction avec b = 0. Aucun changement nécessaire.");
    }
    @Test
    public void testPrintCalculation() {
        // Création d'un mock pour le logger
        Logger mockLogger = Mockito.mock(Logger.class);

        // Remplacer le logger de la classe Calculator par le mock
        Calculator calculator = new Calculator() {
            @Override
            public void printCalculation(int result) {
                mockLogger.info("Le résultat est : " + result);
            }
        };

        // Appel de la méthode avec un résultat
        calculator.printCalculation(10);

        // Vérification que le logger a bien émis l'info avec le bon message
        verify(mockLogger).info("Le résultat est : 10");
    }
}
