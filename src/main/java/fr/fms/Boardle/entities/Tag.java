package fr.fms.Boardle.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @Getter
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "tag")
    private Collection<Task> tasks;

    public Tag(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
