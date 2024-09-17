package com.fox.links.Repo;

import com.fox.links.Models.Links;
import org.springframework.data.repository.CrudRepository;


public interface LinkRepository extends CrudRepository<Links, Long> {
   Links findByShortLink(String short_link);
}
