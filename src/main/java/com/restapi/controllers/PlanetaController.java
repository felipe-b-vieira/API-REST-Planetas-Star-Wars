package com.restapi.controllers;

import com.restapi.models.Planeta;
import com.restapi.repositories.PlanetasRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {
    @Autowired
    private PlanetasRepository repository;

    //API endpoints
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Planeta> getAllPlanetas() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Planeta getPlanetaById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPlanetaById(@PathVariable("id") ObjectId id, @Valid @RequestBody Planeta Planeta) {
        Planeta.set_id(id);
        repository.save(Planeta);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Planeta createPlaneta(@Valid @RequestBody Planeta Planeta) {
        Planeta.set_id(ObjectId.get());
        Planeta.setAparicoes(Planeta.getNome());
        repository.save(Planeta);
        return Planeta;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePlaneta(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}

