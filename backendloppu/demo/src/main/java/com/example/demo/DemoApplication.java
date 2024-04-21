package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Album;
import com.example.demo.domain.AlbumRepo;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner BookCommandLineRunner(AlbumRepo albumRepo, CategoryRepo categoryRepo) {
		return (args) -> {
			Category category1 = new Category("Rap");
			categoryRepo.save(category1);
			Category category2 = new Category("Punk");
			categoryRepo.save(category2);
			Category category3 = new Category("Rock");
			categoryRepo.save(category3);

			Album a = new Album("Mm.. Food", "MF DOOM's album from year 2004", "MF DOOM", "Rhymesayers", 2004, 45, category1);
			Album b = new Album("Operation: Doomsday", "MF DOOM's album from year 1999", "MF DOOM", "Fondle 'em", 1999, 50, category1);

			albumRepo.save(b);
			albumRepo.save(a);

		};
}
}
