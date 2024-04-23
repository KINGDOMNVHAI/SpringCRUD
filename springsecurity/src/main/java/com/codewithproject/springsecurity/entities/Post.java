package com.codewithproject.springsecurity.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) unable for string
    @Column(name = "id_post", nullable = false)
    private String idPost;

    @Column(name = "title_post_vi")
    private String titlePostVI;

    @Column(name = "title_post_en")
    private String titlePostEN;

    @Column(name = "url_post")
    private String urlPost;

    @Column(name = "present_post_vi")
    private String presentPostVI;

    @Column(name = "present_post_en")
    private String presentPostEN;

    @Column(name = "content_post_vi", columnDefinition = "text")
    private String contentPostVI;

    @Column(name = "content_post_en", columnDefinition = "text")
    private String contentPostEN;

    @Column(name = "thumbnail_post")
    private String thumbnailPost;

    @Column(name = "views", columnDefinition = "integer default 0")
    private Integer views;
}
