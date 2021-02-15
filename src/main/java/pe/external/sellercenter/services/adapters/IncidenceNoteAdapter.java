package pe.external.sellercenter.services.adapters;

import org.springframework.stereotype.Component;
import pe.external.sellercenter.domain.entity.IncidenceEntity;
import pe.external.sellercenter.domain.entity.IncidenceNoteEntity;
import pe.external.sellercenter.domain.model.AuthorDTO;
import pe.external.sellercenter.domain.model.IncidenceNoteDTO;

@Component
public class IncidenceNoteAdapter {
    public IncidenceNoteEntity fromDTO(IncidenceNoteDTO data, IncidenceEntity ref) {
        final var ret = new IncidenceNoteEntity();

        ret.setIncidence(ref);
        ret.setDate(data.getDate());
        ret.setText(data.getText());
        if (data.getAuthor() != null) {
            final var author = data.getAuthor();
            ret.setAuthorEmail(author.getEmail());
            ret.setAuthorId(author.getId());
            ret.setAuthorFirstName(author.getFirstName());
            ret.setAuthorLastName(author.getLastName());
        }

        return ret;
    }
    public IncidenceNoteDTO fromEntity(IncidenceNoteEntity data) {
        final var ret = new IncidenceNoteDTO();

        ret.setDate(data.getDate());
        ret.setText(data.getText());

        if (data.getAuthorEmail() != null ||
                data.getAuthorId() != null ||
                data.getAuthorFirstName() != null ||
                data.getAuthorLastName() != null
        ) {
            final var author = new AuthorDTO();
            author.setEmail(data.getAuthorEmail());
            author.setFirstName(data.getAuthorFirstName());
            author.setLastName(data.getAuthorLastName());
            author.setId(data.getAuthorId());

            ret.setAuthor(author);
        }

        return ret;
    }
}
