package fr.fms.Boardle.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Setter @ToString
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @ManyToOne(optional = true)
    private Tag tag;

    public Task(String title, String description, LocalDate date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Task(String title, String description, LocalDate date, Tag tag) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.tag = tag;
    }
}
