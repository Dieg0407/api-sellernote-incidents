package pe.external.sellercenter.domain.service;

import pe.external.sellercenter.domain.model.IncidenceDTO;

public interface IIncidenceService {
    IncidenceDTO createOrUpdate(IncidenceDTO data);
    IncidenceDTO findById(Long id);
}
