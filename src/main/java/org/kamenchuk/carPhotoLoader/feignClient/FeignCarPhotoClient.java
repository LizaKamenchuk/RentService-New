package org.kamenchuk.carPhotoLoader.feignClient;

import org.kamenchuk.dto.carDTO.PhotoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "carPhotoClient", url = "http://localhost:8082/photo")
public interface FeignCarPhotoClient {
    @PostMapping(value = "/addPhoto")
    PhotoDto addPhoto(@RequestBody PhotoDto file);

//    @GetMapping(value="/getPhotos/{idCar}",produces = "application/json")
//    List<PhotoResponse> getPhotos(@PathVariable Integer idCar);
    @DeleteMapping("/delete/{idPhoto}")
    void deletePhotoById(@PathVariable String idPhoto);
}
