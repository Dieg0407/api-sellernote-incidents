package pe.external.sellercenter.domain.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "incident_note")
public class IncidenceNoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sequence")
    private Long sequence;

    @Column(name = "date")
    private LocalDateTime date;

    @Type(type = "text")
    @Column(name = "text")
    private String text;

    @Column(name = "author_id", length = 100)
    private String authorId;

    @Column(name = "author_fistname", length = 100)
    private String authorFirstName;

    @Column(name = "author_lastname", length = 100)
    private String authorLastName;

    @Column(name = "author_email", length = 100)
    private String authorEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incidence_id", referencedColumnName = "incidence_id", nullable = false)
    private IncidenceEntity incidence;
}
