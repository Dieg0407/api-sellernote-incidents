package pe.external.sellercenter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.external.sellercenter.domain.model.IncidenceDTO;
import pe.external.sellercenter.domain.service.IIncidenceService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/incidence/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class IncidenceController {

    @Autowired IIncidenceService service;

    @PostMapping("")
    public IncidenceDTO createOrUpdate(@Valid @RequestBody IncidenceDTO data) {
        return service.createOrUpdate(data);
    }

    @GetMapping("/{id}")
    public IncidenceDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
}
