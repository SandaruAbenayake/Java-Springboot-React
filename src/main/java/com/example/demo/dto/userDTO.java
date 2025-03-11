package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //arguments nathuwa  plain constructors hadanawa
@AllArgsConstructor //Eka arguments ekk ekka constructor ekk hadala denawa hama property ekakatama adalawa
public class userDTO {
    private int id;
    private String name;
}
