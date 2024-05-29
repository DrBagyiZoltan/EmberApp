package com.zq2g8e.ember.controller;

import com.zq2g8e.ember.entity.EmberEntity;
import com.zq2g8e.ember.repository.EmberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class EmberController {

    @Autowired
    private EmberRepository emberRepository;

    @GetMapping("/emberek")
    public String getAllEmber(Model model) {
        List<EmberEntity> emberek = emberRepository.findAll();
        model.addAttribute("emberek", emberek);
        return "list";
    }

    @GetMapping("introduction/{id}")
    public String introduction(@PathVariable long id, RedirectAttributes redirectAttributes) {
        EmberEntity ember = emberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ember nem talalhato"));
        redirectAttributes.addAttribute(id);
        return "redirect:/introduction";
    }

    @GetMapping("/introduction")
    public String getUpdatePage(@RequestParam("long") Long id, Model model) {
        EmberEntity ember = emberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ember nem talalhato"));
        model.addAttribute("ember", ember);
        return "introduction";
    }
}

