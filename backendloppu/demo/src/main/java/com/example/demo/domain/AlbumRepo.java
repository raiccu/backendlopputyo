package com.example.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AlbumRepo extends CrudRepository<Album, Long> {
    List<Album> findByArtist(@Param("artist") String artist);
}
