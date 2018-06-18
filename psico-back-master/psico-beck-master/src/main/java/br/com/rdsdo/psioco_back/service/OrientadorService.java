package br.com.rdsdo.psioco_back.service;

import br.com.rdsdo.psioco_back.entity.Orientador;

import java.util.List;

public interface OrientadorService {
    public Orientador salvar(Orientador orientador);
    public List<Orientador> listar();
    public Orientador excluir(Long id);
    public Orientador get(Long id);
}
