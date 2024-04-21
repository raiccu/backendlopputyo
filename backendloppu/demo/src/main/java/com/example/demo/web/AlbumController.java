package com.example.demo.web;

import org.springframework.ui.Model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Album;
import com.example.demo.domain.AlbumRepo;
import com.example.demo.domain.CategoryRepo;

import io.micrometer.common.lang.NonNull;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepo albumRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/albumlist")
    public String showBookList(Model model) {
        Iterable<Album> albums = albumRepo.findAll();
        model.addAttribute("albums", albums);
        return "albumlist";
    }

    @GetMapping("/addalbum")
    public String addAlbumForm(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("categories", categoryRepo.findAll());
        return "addalbum";
    }

    @PostMapping("/addalbum")
    public String addAlbum(@ModelAttribute Album newAlbum){
        albumRepo.save(newAlbum);
        return "redirect:/albumlist";
    }

    @GetMapping("/deletealbum/{id}")
    public String deleteAlbum(@PathVariable @NonNull Long id) {
        albumRepo.deleteById(id);
        return "redirect:/albumlist";
    }

    @GetMapping("/editalbum/{id}")
    public String editAlbum(@PathVariable Long id, Model model){
        Optional<Album> optionalAlbum = albumRepo.findById(id);
        if(optionalAlbum.isPresent()){
            model.addAttribute("album", optionalAlbum.get());
            model.addAttribute("categories", categoryRepo.findAll());
            return "editalbum";
        }  else {
            return "redirect:/albumlist";
        }
    }

    @PostMapping("/updatealbum")
    public String updateAlbum(@ModelAttribute Album updatedAlbum) {
        albumRepo.save(updatedAlbum);
        return "redirect:/albumlist";
    }
    
    
}
