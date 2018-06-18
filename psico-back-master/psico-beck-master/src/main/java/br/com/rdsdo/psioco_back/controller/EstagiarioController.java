package br.com.rdsdo.psioco_back.controller;

import br.com.rdsdo.psioco_back.entity.Estagiario;
import br.com.rdsdo.psioco_back.service.EstagiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api")
public class EstagiarioController {


    @Autowired
    EstagiarioService estagiarioService;


    @RequestMapping(value = "/estagiario", method = RequestMethod.POST)
    public Mono<Estagiario> salvar(@RequestBody Estagiario estagiario){
        System.out.println("Deu certo!!!");
        Estagiario estagiario1 = estagiarioService.salvar(estagiario);
        return Mono.just(estagiario1);
    }

    @RequestMapping(value = "/estagiario" , method = RequestMethod.GET)
    public @ResponseBody Mono<List<Estagiario>> listar(){
        List<Estagiario> estagiarios = estagiarioService.listar();
        return Mono.just(estagiarios);
    }

    /*@RequestMapping(value="/estagiario", method = RequestMethod.POST)
    public Mono<Estagiario> salvarEstagiario(Estagiario estagiario) {
        estagiarioService.salvar(estagiario);
        return Mono.empty();
    }*/

    @RequestMapping(value="/estagiario/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Mono<Estagiario> excluir(@PathVariable("id") Long id) {
        Estagiario nota = estagiarioService.excluir(id);
        return Mono.just(nota);
    }

    @RequestMapping(value="/estagiario/{id}", method = RequestMethod.GET)
    public @ResponseBody Mono<Estagiario> get(@PathVariable("id") Long id) {
        Estagiario nota = estagiarioService.get(id);
        System.out.println("id: " + id);
        return Mono.just(nota);
    }

}
