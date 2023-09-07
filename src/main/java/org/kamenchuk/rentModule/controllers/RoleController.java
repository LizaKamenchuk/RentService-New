package org.kamenchuk.rentModule.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.kamenchuk.dto.roleDTO.RoleResponse;
import org.kamenchuk.rentModule.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent_module/role")
@SecurityRequirement(name = "bearerToken")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @DeleteMapping("/admin/deleteRole/{id}")
    public void deleteRole(@PathVariable Integer id){
        roleService.deleteRole(id);
    }

    @PostMapping("/admin/createRole/{role}")
    public RoleResponse createRole(@PathVariable String role) {
        return roleService.createRole(role);
    }
}
