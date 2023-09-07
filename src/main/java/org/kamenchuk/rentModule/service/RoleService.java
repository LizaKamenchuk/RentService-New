package org.kamenchuk.rentModule.service;

import org.kamenchuk.dto.roleDTO.RoleResponse;
import org.kamenchuk.rentModule.feinClient.FeignRoleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final FeignRoleClient feignRoleClient;

    @Autowired
    public RoleService(FeignRoleClient feignRoleClient) {
        this.feignRoleClient = feignRoleClient;
    }

    public void deleteRole(Integer id) {
        feignRoleClient.deleteRole(id);
    }

    public RoleResponse createRole(String role) {
        return feignRoleClient.createRole(role);
    }
}
