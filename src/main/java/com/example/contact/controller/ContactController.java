package com.example.contact.controller;

import com.example.contact.model.Contact;
import com.example.contact.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST Controller that handles contact form submissions and retrieval.
 *
 * Endpoints:
 *   POST /api/contact   — public, saves a new contact submission
 *   GET  /api/contacts  — ADMIN only, returns all contacts as JSON
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    /**
     * Receives form data as JSON, saves to MySQL, prints to console,
     * and returns a confirmation message.
     */
    @PostMapping("/contact")
    public ResponseEntity<Map<String, String>> handleContact(@RequestBody ContactRequest request) {

        // Save to database
        Contact contact = new Contact(request.getName(), request.getEmail(), request.getMessage());
        contactRepository.save(contact);

        // Print to console
        System.out.println("========================================");
        System.out.println("  New Contact Form Submission (saved)");
        System.out.println("========================================");
        System.out.println("  Name    : " + request.getName());
        System.out.println("  Email   : " + request.getEmail());
        System.out.println("  Message : " + request.getMessage());
        System.out.println("========================================");

        return ResponseEntity.ok(Map.of(
            "status", "success",
            "message", "Message received from " + request.getName() + "!"
        ));
    }

    /**
     * Returns all saved contacts as JSON.
     * Protected — only accessible by users with ADMIN role.
     */
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return ResponseEntity.ok(contacts);
    }
}
