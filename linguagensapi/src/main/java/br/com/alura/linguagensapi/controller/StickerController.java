package br.com.alura.linguagensapi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.linguagensapi.service.StickerService;

@RestController
@RequestMapping("/stickers")
public class StickerController {

    @Autowired
    private StickerService service;

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody ResponseEntity<Object> getSticker(@PathVariable String id) throws IOException {
        String filename = service.generate(id);

        File file = new File(filename);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.setContentLength(file.length());
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return ResponseEntity.ok().headers(headers).body(resource);
    }

}
