package br.com.carlosalberto.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.carlosalberto.cadpessoas.model.Pessoa;
import br.com.carlosalberto.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController{

    @Autowired
    PessoaRepository pessoaRepo;

    PessoaController(PessoaRepository pessoaRepo){
        this.pessoaRepo = pessoaRepo;
    }

    @GetMapping
    public String index() {
        return "index.html";
    }
    
    @GetMapping("/listarPessoas")
    public ModelAndView listarPessoas(){
        List<Pessoa> lista = pessoaRepo.findAll();

        ModelAndView mav = new ModelAndView("listaPessoas");

        mav.addObject("pessoas", lista);

        return mav;
    }
    @GetMapping("/remover/{id}")
    public ModelAndView removerPessoa(@PathVariable("id") long id){
        Pessoa aRemover = pessoaRepo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

        pessoaRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarPessoas");
    }
}