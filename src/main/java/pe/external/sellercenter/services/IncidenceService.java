package pe.external.sellercenter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.external.sellercenter.domain.entity.IncidenceEntity;
import pe.external.sellercenter.domain.exceptions.AppException;
import pe.external.sellercenter.domain.model.IncidenceDTO;
import pe.external.sellercenter.domain.repository.IIncidenceRepository;
import pe.external.sellercenter.domain.service.IIncidenceService;
import pe.external.sellercenter.services.adapters.IncidenceAdapter;
import pe.external.sellercenter.services.adapters.IncidenceNoteAdapter;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class IncidenceService implements IIncidenceService {
    @Autowired IncidenceAdapter incidenceAdapter;
    @Autowired IncidenceNoteAdapter noteAdapter;
    @Autowired IIncidenceRepository incidenceRepository;


    @Override
    @Transactional
    public IncidenceDTO createOrUpdate(IncidenceDTO data) {
        if (data.getComments() == null) {
            data.setComments(new ArrayList<>());
        }

        final var incidenceOpt = incidenceRepository.findById(data.getId());
        var entityRef = incidenceOpt.orElse(null);

        if (incidenceOpt.isEmpty()) {
            entityRef = incidenceAdapter.fromDTO(data);
            incidenceRepository.save(entityRef);
        }

        final var entity = entityRef;
        final var comments = data.getComments()
                .stream()
                .map(i -> noteAdapter.fromDTO(i, entity))
                .collect(Collectors.toList());

        entity.getComments().addAll(comments);
        incidenceRepository.save(entity);

        return incidenceAdapter.fromEntity(entity);
    }

    @Override
    public IncidenceDTO findById(Long id) {
        final var incidence = incidenceRepository.findById(id)
                .orElseThrow(() -> new AppException("Incidence with id "+ id + " doesn't exist", 404));
        return incidenceAdapter.fromEntity(incidence);
    }
}
