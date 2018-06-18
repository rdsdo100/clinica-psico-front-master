package br.com.rdsdo.psioco_back.controller;



import br.com.rdsdo.psioco_back.entity.Orientador;
import br.com.rdsdo.psioco_back.service.OrientadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api")
public class OrientadorController {

    @Autowired
    OrientadorService orientadorService;


    @RequestMapping(value = "/orientador", method = RequestMethod.POST)
    public Mono<Orientador> salvar(@RequestBody Orientador orientador){
        System.out.println("Deu certo!!!");
        Orientador orientador1 = orientadorService.salvar(orientador);
        return Mono.just(orientador1);
    }

    @RequestMapping(value = "/orientador" , method = RequestMethod.GET)
    public @ResponseBody Mono<List<Orientador>> listar(){
        List<Orientador> orientadores = orientadorService.listar();
        return Mono.just(orientadores);
    }

    /*@RequestMapping(value="/orientador", method = RequestMethod.POST)
    public Mono<Orientador> salvar(Orientador orientador) {
        orientadorService.salvar(orientador);
        return Mono.empty();
    }*/

    @RequestMapping(value="/orientador/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Mono<Orientador> excluir(@PathVariable("id") Long id) {
        Orientador nota = orientadorService.excluir(id);
        return Mono.just(nota);
    }

    @RequestMapping(value="/orientador/{id}", method = RequestMethod.GET)
    public @ResponseBody Mono<Orientador> get(@PathVariable("id") Long id) {
        Orientador nota = orientadorService.get(id);
        System.out.println("id: " + id);
        return Mono.just(nota);
    }
}
