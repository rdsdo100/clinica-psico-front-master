package br.com.rdsdo.psioco_back.service.impl;


import br.com.rdsdo.psioco_back.entity.Orientador;

import br.com.rdsdo.psioco_back.repository.OrientadorRepository;
import br.com.rdsdo.psioco_back.service.OrientadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrientadorServiceImpl implements OrientadorService {

    @Autowired
    OrientadorRepository orientadorRepository;


    @Override
    public Orientador salvar(Orientador orientador) {
        return orientadorRepository.save(orientador);
    }

    @Override
    public List<Orientador> listar() {
        return (List<Orientador>) orientadorRepository.findAll();
    }

    @Override
    public Orientador excluir(Long id) {
        Optional<Orientador> orientador = orientadorRepository.findById(id);
        orientadorRepository.deleteById(id);
        return orientador.get();
    }

    @Override
    public Orientador get(Long id) {
        Optional<Orientador> orientador = orientadorRepository.findById(id);
        return orientador.get();
    }
}
