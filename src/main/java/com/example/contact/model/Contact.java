package com.example.contact.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * JPA Entity mapped to the "contacts" table in MySQL.
 */
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    // ── Lifecycle callback ──────────────────────────────────────
    @PrePersist
    protected void onCreate() {
        this.submittedAt = LocalDateTime.now();
    }

    // ── Constructors ────────────────────────────────────────────
    public Contact() {}

    public Contact(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    // ── Getters & Setters ───────────────────────────────────────
    public Long getId()                     { return id; }
    public void setId(Long id)              { this.id = id; }

    public String getName()                 { return name; }
    public void setName(String name)        { this.name = name; }

    public String getEmail()                { return email; }
    public void setEmail(String email)      { this.email = email; }

    public String getMessage()              { return message; }
    public void setMessage(String message)  { this.message = message; }

    public LocalDateTime getSubmittedAt()             { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
}
