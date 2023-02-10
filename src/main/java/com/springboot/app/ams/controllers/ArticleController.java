package com.springboot.app.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.app.ams.entity.Article;
import com.springboot.app.ams.entity.Provider;
import com.springboot.app.ams.repository.ArticleRepository;
import com.springboot.app.ams.repository.ProviderRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/article/")
public class ArticleController {
	 private final ArticleRepository articleRepository ;
	 private final ProviderRepository providerRepository ;
	 
	 @Autowired
	 public ArticleController (ArticleRepository articleRepository , ProviderRepository providerRepository) {
		 this.articleRepository=articleRepository ;
		 this.providerRepository=providerRepository;
	 }
	 @GetMapping("list")
	 
	 public String ListProvider(Model model) {
		 model.addAttribute("articles",articleRepository.findAll());
		 return "article/ListArticle";
	 }
	 
	 @GetMapping("add")
	 
	 public String ShowArticleForm(Article article, Model model) {
			model.addAttribute("providers", providerRepository.findAll());
	    	model.addAttribute("article", new Article());
	        return "article/AddArticle";


	 }
	 
	 @PostMapping("add")
	 
	    public String addArticle(@Valid Article article, BindingResult result, @RequestParam(name = "providerId", required = false) Long p) {
	    	
	    	Provider provider = providerRepository.findById(p)
	                .orElseThrow(()-> new IllegalArgumentException("Invalid provider Id:" + p));
	    	article.setProvider(provider);
	    	
	    	 articleRepository.save(article);
	    	 return "redirect:list";
	 }
	 
	 @GetMapping("delete/{id}")
	 public String DeleteArticle(@PathVariable("id") long id , Model model) {
		 Article article = articleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid id " + id));
		 articleRepository.delete(article);
		 return"redirect:../list";
	 }
	 
	 @GetMapping("edit/{id}")
	 public String ShowUpadeteArticle(@PathVariable("id") long id , Model model) {
	 Article article = articleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid id " + id));
	 model.addAttribute(article);
	 model.addAttribute("providers" , providerRepository.findAll());
	 model.addAttribute("idProvider", article.getProvider().getId());
	 return"article/UpdateArticle";
	 }
	 
	 @PostMapping("edit/{id}")
	 public String UpdateArticle(@PathVariable("id") long id, @Valid Article article, BindingResult result,
		        Model model, @RequestParam(name = "providerId", required = false) Long p)
	 		{ if (result.hasErrors()) {
	 			article.setId(id);
	 			return "article/updateArticle";
	 		}

	 		Provider provider = providerRepository.findById(p).orElseThrow(()-> new IllegalArgumentException("Invalid provider Id:" + p));
	 		article.setProvider(provider);

	 		articleRepository.save(article);
	 		model.addAttribute("articles", articleRepository.findAll());
	 		return "article/ListArticle";
	 		}

}

