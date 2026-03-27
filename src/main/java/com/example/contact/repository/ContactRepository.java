package com.example.contact.repository;

import com.example.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for Contact entities.
 * Provides CRUD operations out of the box.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
