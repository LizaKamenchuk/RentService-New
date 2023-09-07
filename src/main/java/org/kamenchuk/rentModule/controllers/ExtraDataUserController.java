package org.kamenchuk.rentModule.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.kamenchuk.dto.extraUsersDataDTO.ExtraUserDataUpdateRequest;
import org.kamenchuk.rentModule.service.ExtraDataUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest_module/extraData")
@SecurityRequirement(name = "bearerToken")
public class ExtraDataUserController {
    private final ExtraDataUserService extraDataUserService;

    public ExtraDataUserController(ExtraDataUserService extraDataUserService) {
        this.extraDataUserService = extraDataUserService;
    }

    @GetMapping("/getById/{id}")
    public ExtraUserDataUpdateRequest getById(@PathVariable Long id)  {
        return extraDataUserService.getById(id);
    }

    @PatchMapping("/updateExtra")
    public ExtraUserDataUpdateRequest update(@RequestBody ExtraUserDataUpdateRequest request, @RequestParam Long idED){
        return extraDataUserService.update(request,idED);
    }

}
