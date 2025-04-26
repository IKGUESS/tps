package org.example;

import java.util.logging.Logger;

public class Calculator {
    // Création d'un logger pour la classe
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    // Méthode addition
    public int add(int a, int b) {
        return a + b;
    }

    // Méthode soustraction corrigée
    public int subtract(int a, int b) {
        if (b == 0) {
            // Il est préférable d'éviter de jeter une exception pour ce cas spécifique.
            logger.warning("Soustraction avec b = 0. Aucun changement nécessaire.");
        }
        return a - b;
    }

    // Remplacement de System.out.println par un Logger
    public void printCalculation(int result) {
        logger.info("Le résultat est : " + result);  // Utilisation du logger
    }

    // Méthode inutilisée supprimée pour garder le code propre
}
