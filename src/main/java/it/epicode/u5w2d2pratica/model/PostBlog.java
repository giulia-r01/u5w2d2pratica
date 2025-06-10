package it.epicode.u5w2d2pratica.model;

import lombok.Data;

@Data
public class PostBlog {
   private Long id;
   private String categoria;
   private String titolo;
   private String cover;
   private String contenuto;
   private int tempoDiLettura;
}
