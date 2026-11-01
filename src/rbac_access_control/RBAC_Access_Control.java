/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rbac_access_control;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author TA
 */
public class RBAC_Access_Control {

    static Map<String, Set<String>> rolePermissions = new HashMap<>();
    static Map<String, String> userRoles = new LinkedHashMap<>();
    static Map<Integer, String> accounts = new LinkedHashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextAccountId = 3;

    public static void main(String[] args) {

        // Assign permissions to roles
        rolePermissions.put("Admin",
                Set.of("Create", "View", "Update", "Delete"));

        rolePermissions.put("Manager",
                Set.of("View", "Update"));

        rolePermissions.put("Customer",
                Set.of("View"));

        // Assign users to roles
        userRoles.put("Ali", "Admin");
        userRoles.put("Sara", "Manager");
        userRoles.put("Omar", "Customer");

        // Sample accounts
        accounts.put(1, "Account - Ahmad");
        accounts.put(2, "Account - Lina");

        System.out.println("=== RBAC Access Control System ===");

        while (true) {
            System.out.println("\nAvailable Users:");
            for (String user : userRoles.keySet()) {
                System.out.println(user + " - " + userRoles.get(user));
            }

            System.out.print("\nEnter username (or exit): ");
            String username = scanner.nextLine().trim();

            if (username.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                break;
            }

            if (!userRoles.containsKey(username)) {
                System.out.println("User not found!");
                continue;
            }

            String role = userRoles.get(username);
            System.out.println("Logged in as: " + username);
            System.out.println("Role: " + role);

            System.out.println("\n1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Update Account");
            System.out.println("4. Delete Account");

            System.out.print("Choose operation: ");
            String choice = scanner.nextLine().trim();

            String operation;

            switch (choice) {
                case "1":
                    operation = "Create";
                    break;
                case "2":
                    operation = "View";
                    break;
                case "3":
                    operation = "Update";
                    break;
                case "4":
                    operation = "Delete";
                    break;
                default:
                    System.out.println("Invalid operation!");
                    continue;
            }

            if (!hasPermission(username, operation)) {
                System.out.println("ACCESS DENIED!");
                System.out.println(role + " cannot " + operation + " accounts.");
                continue;
            }

            System.out.println("ACCESS GRANTED!");
            performOperation(operation);
        }

        scanner.close();
    }

    static boolean hasPermission(String username, String operation) {
        String role = userRoles.get(username);
        return role != null
                && rolePermissions.getOrDefault(role, Collections.emptySet())
                        .contains(operation);
    }

    static void performOperation(String operation) {
        switch (operation) {

            case "Create":
                System.out.print("Enter account name: ");
                String name = scanner.nextLine();
                accounts.put(nextAccountId, name);
                System.out.println("Account created with ID: " + nextAccountId);
                nextAccountId++;
                break;

            case "View":
                System.out.println("Accounts:");
                accounts.forEach((id, value)
                        -> System.out.println(id + ": " + value));
                break;

            case "Update":
                System.out.print("Enter account ID: ");
                Integer updateId = readId();
                if (updateId == null) {
                    break;
                }

                if (!accounts.containsKey(updateId)) {
                    System.out.println("Account not found!");
                    break;
                }

                System.out.print("Enter new account name: ");
                accounts.put(updateId, scanner.nextLine());
                System.out.println("Account updated successfully.");
                break;

            case "Delete":
                System.out.print("Enter account ID: ");
                Integer deleteId = readId();
                if (deleteId == null) {
                    break;
                }

                if (accounts.remove(deleteId) != null) {
                    System.out.println("Account deleted successfully.");
                } else {
                    System.out.println("Account not found!");
                }
                break;
        }
    }

    static Integer readId() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid account ID!");
            return null;
        }
    }
}
