package com.springboot.app.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.app.ams.entity.Provider;
import com.springboot.app.ams.repository.ProviderRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/provider/")
public class ProviderController {
 private final ProviderRepository providerRepository ;
 
 @Autowired
 public ProviderController (ProviderRepository providerRepository) {
	 this.providerRepository=providerRepository ;
 }
 @GetMapping("list")
 
 public String ListProvider(Model model) {
	 model.addAttribute("providers",providerRepository.findAll());
	 return "provider/ListProvider";
 }
 
 @GetMapping("add")
 
 public String ShowProviderForm (Model model) {
	 Provider provider = new Provider();
	 model.addAttribute("provider",provider);
	 return "/provider/AddProvider";
 }
 
 @PostMapping("add")
 
 public String AddProvider(@Valid Provider provider , BindingResult result , Model model) {
	 if (result.hasErrors()) {
		 return "provider/AddProvider";
	 }
	 providerRepository.save(provider);
	 return "redirect:list";
 }
 @GetMapping("delete/{id}")
 
 public String DeleteProvider(@PathVariable("id") long id , Model model) {
	 Provider provider = providerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid provider id" + id));
	 System.out.println("suite de programme ...");
	 providerRepository.delete(provider);
	 return "redirect:../list";
	 
 }
  
 
@GetMapping("edit/{id}")
 
 public String ShowProviderForm(@PathVariable("id") long id , Model model) {
	 Provider provider = providerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid provider id" + id));
	 model.addAttribute("provider", provider);
	 return "provider/UpdateProvider";
 }

@PostMapping("update")

public String UpdateProvider(@Valid Provider provider ,BindingResult result, Model model) {
   providerRepository.save(provider);
   return "redirect:list";
}
}
