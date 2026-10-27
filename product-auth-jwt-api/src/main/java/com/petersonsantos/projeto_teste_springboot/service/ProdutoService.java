package com.petersonsantos.projeto_teste_springboot.service;

import com.petersonsantos.projeto_teste_springboot.exception.RecursoNãoEncontradoException;
import com.petersonsantos.projeto_teste_springboot.model.Produto;
import com.petersonsantos.projeto_teste_springboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProduto(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNãoEncontradoException("Produto com o ID " + id + " não encontrado." ));
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){

        if(!produtoRepository.existsById(id)){
            throw new RecursoNãoEncontradoException("Produto com o ID " + id + " não encontrado.");
        }
        produtoRepository.deleteById(id);
    }
}
