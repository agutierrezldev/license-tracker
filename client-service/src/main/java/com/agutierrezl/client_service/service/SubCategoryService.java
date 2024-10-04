package com.agutierrezl.client_service.service;

import com.agutierrezl.client_service.model.response.CustomerDTO;
import com.agutierrezl.client_service.model.response.CustomerResponseDTO;
import com.agutierrezl.client_service.model.response.DocumentDTO;
import com.agutierrezl.client_service.model.response.SubCategoryDTO;
import com.agutierrezl.client_service.proxy.openfeign.ICloudGatewayServiceFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final ICloudGatewayServiceFeign serviceFeign;

    public SubCategoryDTO getById(String id){
        return serviceFeign.getByIdSubCategory(id);
    }


//    public DocumentDTO save(DocumentDTO documentDTO) {
//        return documentServiceFeign.save(documentDTO);
//    }
//
//    public DocumentDTO disabledById(String id) {
//        return documentServiceFeign.disabledById(id);
//    }


}
