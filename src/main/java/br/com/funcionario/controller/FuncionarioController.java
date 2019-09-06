package br.com.funcionario.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.funcionario.Funcionario;
import br.com.funcionario.service.FuncionarioService;


@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

	private static final String PAGES_NOVO_FUNCIONARIO = "pages/contato/novo_contato";

	private static final String PAGES_CONTATO_LISTAGEM = "pages/contato/contatos";

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public ModelAndView listar(@ModelAttribute("filtro") Funcionario funcionario) {
		ModelAndView mv = new ModelAndView(PAGES_CONTATO_LISTAGEM);

		mv.addObject("funcionarios", funcionarioService.filtroListagem(funcionario.getPessoa().getNome()));

		return mv;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/funcionarios");
		this.funcionarioService.remover(id);
		attributes.addFlashAttribute("removido", "Funcionario removido com sucesso!");
		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		final Funcionario funcionario = this.funcionarioService.buscarPorId(id);
		return novo(funcionario);
	}

	@GetMapping("/novo")
	public ModelAndView novo(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView(PAGES_NOVO_FUNCIONARIO);
		mv.addObject("funcionario", funcionario);
		return mv;
	}

	@PostMapping("/save")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result,
			RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/funcionarios");

		if (result.hasErrors()) {
			return novo(funcionario);
		}
		
    	Optional<Funcionario> funcionarioComemailExistente =  this.funcionarioService.salvarFuncionario(funcionario);
    	
    	if (!funcionarioComemailExistente.isPresent()) {
    		attributes.addFlashAttribute("mensagem", "Este email já existe");

		}
		attributes.addFlashAttribute("mensagem", "Funcionario salvo com sucesso");
		return mv;
	}
}
