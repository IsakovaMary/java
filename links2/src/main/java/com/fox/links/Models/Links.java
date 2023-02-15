package com.fox.links.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "links")
public class Links {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotEmpty
    private String  long_link;
    @NotEmpty

    @Column(name = "short_link")
    private String  shortLink;
    public Links() {
    }

    public Links(String long_link, String shortLink) {
        this.long_link = long_link;
        this.shortLink = shortLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLong_link() {
        return long_link;
    }

    public void setLong_link(String long_link) {
        this.long_link = long_link;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }
}
