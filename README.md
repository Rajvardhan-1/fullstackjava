# Full-Stack Contact Form — Spring Boot + HTML

A minimal full-stack demo: a styled landing page with a contact form
that sends data to a Java Spring Boot REST API.

---

## Project Structure

```
springboot-project/
├── frontend/
│   └── index.html              ← Landing page + contact form
├── pom.xml                     ← Maven build file
└── src/main/java/com/example/contact/
    ├── ContactFormApplication.java   ← Spring Boot entry point
    └── controller/
        ├── ContactRequest.java       ← DTO (maps JSON → Java object)
        └── ContactController.java    ← POST /api/contact handler
```

---

## Prerequisites

| Tool | Version |
|------|---------|
| Java | 17 or higher |
| Maven | 3.8+ |

---

## Run the Backend

```bash
# From the springboot-project/ directory:
mvn spring-boot:run
```

You should see:

```
Tomcat started on port(s): 8080
Started ContactFormApplication
```

---

## Open the Frontend

Simply open `frontend/index.html` in your browser
(double-click the file, or use Live Server in VS Code).

---

## Test the Flow

1. Fill in Name, Email, and Message in the form.
2. Click **Send Message**.
3. Watch your terminal — you'll see:

```
========================================
  New Contact Form Submission
========================================
  Name    : Ada Lovelace
  Email   : ada@example.com
  Message : Hello from the frontend!
========================================
```

---

## How it Works

```
Browser (index.html)
  │
  │  fetch('http://localhost:8080/api/contact', { method: 'POST', body: JSON })
  ▼
Spring Boot (ContactController.java)
  │  @PostMapping("/api/contact")
  │  @RequestBody ContactRequest
  │
  └─► System.out.println(...)   ← prints to your terminal
      return 200 OK
```

### Key Concepts

- **`@RestController`** — marks the class as a REST API handler; automatically serializes return values to JSON.
- **`@PostMapping`** — maps HTTP POST requests to a method.
- **`@RequestBody`** — tells Spring to deserialize the incoming JSON into a `ContactRequest` Java object.
- **`@CrossOrigin`** — allows the browser to call the API from a different origin (the HTML file).

---

## Next Steps (extend this project)

- [ ] Add a database (H2 → PostgreSQL) and save submissions with `JpaRepository`
- [ ] Add form validation with `@Valid` and Bean Validation annotations
- [ ] Return structured JSON responses instead of plain strings
- [ ] Add a Thymeleaf template to serve the HTML from Spring Boot itself
