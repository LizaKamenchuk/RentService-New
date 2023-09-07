package org.kamenchuk.rentModule.service;

import org.kamenchuk.dto.extraUsersDataDTO.ExtraUserDataUpdateRequest;
import org.kamenchuk.rentModule.feinClient.FeignExtraDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtraDataUserService {
    private final FeignExtraDataClient feignExtraDataClient;

    @Autowired
    public ExtraDataUserService(FeignExtraDataClient feignExtraDataClient) {
        this.feignExtraDataClient = feignExtraDataClient;
    }

    public ExtraUserDataUpdateRequest getById(Long id) {
        return feignExtraDataClient.getById(id);
    }

    public ExtraUserDataUpdateRequest update(ExtraUserDataUpdateRequest request, Long idED) {
        return feignExtraDataClient.update(request, idED);
    }
}
