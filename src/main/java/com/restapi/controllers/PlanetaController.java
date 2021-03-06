package com.restapi.controllers;

import com.restapi.models.Planeta;
import com.restapi.repositories.PlanetasRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Planeta> getPlanetaById(@PathVariable("id") ObjectId id) {
        //se encontrar retorna, senão retorna um erro de BAD REQUEST
        if(repository.existsBy_id(id)){
            return new ResponseEntity<>(repository.findBy_id(id),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //endpoint feito para pesquisar por nome
    @RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
    public ResponseEntity<Planeta> getPlanetaByNome(@PathVariable("nome") String nome ){
        //se encontrar retorna, senão retorna um erro de BAD REQUEST
        if(repository.existsByNome(nome)){
            return new ResponseEntity<>(repository.findByNome(nome),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Planeta> modifyPlanetaById(@PathVariable("id") ObjectId id, @Valid @RequestBody Planeta Planeta) {
        //Se existir ele altera e retorna ok, senão retorna bad request
        if(repository.existsBy_id(id)){
            Planeta.set_id(id);
            repository.save(Planeta);
            return new ResponseEntity<>(Planeta,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //usando ResponseEntity para ter um melhor controle do status enviado
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Planeta> createPlaneta(@Valid @RequestBody Planeta Planeta) {
        //verifica se já existe no db antes de começar a salvar, senão vai retornar um erro pro request
        String nomePlaneta = Planeta.getNome();
        if(repository.existsByNome(nomePlaneta)) {
            System.out.println("Erro ao salvar no BD");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Planeta.set_id(ObjectId.get());
        Planeta.setAparicoes(Planeta.getNome());
        repository.save(Planeta);
        return new ResponseEntity<>(Planeta,HttpStatus.OK);
    }

    //usando ResponseEntity para ter um melhor controle do status enviado
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Planeta> deletePlaneta(@PathVariable("id") ObjectId id) {
        //verifica se já existe no db antes de começar a deletar, senão vai retornar um erro pro request

        if(!repository.existsBy_id(id)) {
            System.out.println("Erro ao deletar no BD"+id.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //retorno o planeta deletado caso tenha sucesso
        Planeta planeta = repository.findBy_id(id);
        repository.delete(repository.findBy_id(id));
        return new ResponseEntity<>(planeta,HttpStatus.OK);
    }
}

