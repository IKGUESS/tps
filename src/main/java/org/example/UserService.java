package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private List<String> users = new ArrayList<>();

    // Ajout d'une validation des entrées
    public void addUser(String user) {
        if (user == null || user.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty.");
        }
        users.add(user);
    }

    // Remplacer le retour null par un Optional pour une gestion plus sûre
    public Optional<String> findUser(String user) {
        for (String u : users) {
            if (u.equals(user)) {
                return Optional.of(u);
            }
        }
        return Optional.empty(); // Retourne un Optional vide plutôt que null
    }

    // Remplacer les messages en dur par des constantes ou un mécanisme de gestion de messages
    public String deleteUser(String user) {
        if (users.contains(user)) {
            users.remove(user);
            return getMessage("user.deleted");
        }
        return getMessage("user.not.found");
    }

    // Utilisation d'une méthode pour obtenir les messages (par exemple, depuis un fichier de propriétés)
    private String getMessage(String key) {
        // Implémentation simple (un fichier de propriétés peut être utilisé pour un projet réel)
        switch (key) {
            case "user.deleted":
                return "User deleted successfully.";
            case "user.not.found":
                return "User not found.";
            default:
                return "Unknown message key.";
        }
    }
}
