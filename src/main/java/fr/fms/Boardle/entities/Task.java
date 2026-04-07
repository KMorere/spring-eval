package fr.fms.Boardle.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    private boolean completed;

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

    /**
     * Calculate the amount of days left for a task.
     * @return The amount of days left or how long ago the date was passed.
     */
    public int dateCountdown() {
        return (int)ChronoUnit.DAYS.between(LocalDate.now(), this.getDate());
    }

    /**
     * Display the amount of days left for a task.
     * @return The amount of days left or how long ago the date was passed.
     */
    public String formatDate() {
        String text = "";
        int days = this.dateCountdown();

        if (days == 0)
            text = "Today";
        else
            text = (days >= 0) ? ""+days : Math.abs(days)+" days ago";

        return text;
    }
}
