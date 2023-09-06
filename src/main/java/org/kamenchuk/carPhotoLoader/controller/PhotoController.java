package org.kamenchuk.carPhotoLoader.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.kamenchuk.carPhotoLoader.feignClient.FeignCarPhotoClient;
import org.kamenchuk.dto.carDTO.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/photo_module/photo")
@SecurityRequirement(name = "bearerToken")
public class PhotoController {

    private final FeignCarPhotoClient feignCarPhotoClient;

    @Autowired
    public PhotoController(FeignCarPhotoClient feignCarPhotoClient) {
        this.feignCarPhotoClient = feignCarPhotoClient;
    }

    @PostMapping(value = "/admin/addPhoto/{idCar}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public PhotoDto addPhoto(@PathVariable Integer idCar, @RequestParam MultipartFile file) throws IOException {
        PhotoDto fileDto = PhotoDto.builder()
                .idCar(idCar)
                .fileName(file.getOriginalFilename())
                .fileBytes(file.getBytes())
                .build();
        return feignCarPhotoClient.addPhoto(fileDto);
    }

    @DeleteMapping("/admin/delete/{idPhoto}")
    public void deletePhotoById(@PathVariable String idPhoto) {
        feignCarPhotoClient.deletePhotoById(idPhoto);
    }

}
