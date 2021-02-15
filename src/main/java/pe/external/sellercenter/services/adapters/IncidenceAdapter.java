package pe.external.sellercenter.services.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.external.sellercenter.domain.entity.IncidenceEntity;
import pe.external.sellercenter.domain.model.AuthorDTO;
import pe.external.sellercenter.domain.model.IncidenceDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class IncidenceAdapter {
    @Autowired IncidenceNoteAdapter childAdapter;

    public IncidenceEntity fromDTO(IncidenceDTO data) {
        final var ret = new IncidenceEntity();

        ret.setAccountName(data.getAccountName());
        ret.setActive(data.getActive());
        ret.setDate(data.getDate());
        ret.setIncidenceId(data.getId());
        ret.setOrderId(data.getOrderId());
        ret.setText(data.getText());
        ret.setType(data.getType());

        if (data.getAuthor() != null) {
            final var author = data.getAuthor();
            ret.setAuthorEmail(author.getEmail());
            ret.setAuthorId(author.getId());
            ret.setAuthorFirstName(author.getFirstName());
            ret.setAuthorLastName(author.getLastName());
        }

        return ret;
    }

    public IncidenceDTO fromEntity(IncidenceEntity data) {
        final var ret = new IncidenceDTO();

        ret.setAccountName(data.getAccountName());
        ret.setActive(data.isActive());
        ret.setDate(data.getDate());
        ret.setId(data.getIncidenceId());
        ret.setOrderId(data.getOrderId());
        ret.setText(data.getText());
        ret.setType(data.getType());

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
        if (data.getComments() == null) {
            data.setComments(new ArrayList<>());
        }
        final var comments = data.getComments()
                .stream()
                .map(i -> childAdapter.fromEntity(i))
                .collect(Collectors.toList());
        ret.setComments(comments);

        return ret;
    }
}
