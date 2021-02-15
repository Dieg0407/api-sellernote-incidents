package pe.external.sellercenter.domain.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "incidence")
public class IncidenceEntity {
    @Id
    @Column(name = "incidence_id", nullable = false)
    private Long incidenceId;

    @Column(name = "date")
    private LocalDateTime date;

    @Type(type = "text")
    @Column(name = "text")
    private String text;

    @Column(name = "active")
    private boolean active;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "orderid", length = 30)
    private String orderId;

    @Column(name = "accountname", length = 100)
    private String accountName;

    @Column(name = "author_id", length = 100)
    private String authorId;

    @Column(name = "author_fistname", length = 100)
    private String authorFirstName;

    @Column(name = "author_lastname", length = 100)
    private String authorLastName;

    @Column(name = "author_email", length = 100)
    private String authorEmail;

    @OneToMany(mappedBy = "incidence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IncidenceNoteEntity> comments = new ArrayList<>();
}
