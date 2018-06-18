package br.com.rdsdo.psioco_back.service;

import br.com.rdsdo.psioco_back.entity.Estagiario;

import java.util.List;

public interface EstagiarioService {
    public Estagiario salvar(Estagiario estagiario);
    public List<Estagiario> listar();
    public Estagiario excluir(Long id);
    public Estagiario get(Long id);
}
