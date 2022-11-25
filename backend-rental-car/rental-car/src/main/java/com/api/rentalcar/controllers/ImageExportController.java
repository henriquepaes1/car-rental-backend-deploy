package com.api.rentalcar.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@CrossOrigin
@RestController
public class ImageExportController {

    @RequestMapping(value = "/images", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(@RequestParam String fileName, HttpServletResponse response) throws IOException {
        /* var imgFile = new ClassPathResource("/home/izaque/Documents/images/" + fileName); */
        File file = new File("/home/izaque/Documents/images/" + fileName);
        InputStream targetStream = new FileInputStream(file);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(targetStream, response.getOutputStream());
    }
}
