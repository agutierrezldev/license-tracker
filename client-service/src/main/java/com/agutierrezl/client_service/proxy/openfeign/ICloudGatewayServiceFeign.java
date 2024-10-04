package com.agutierrezl.client_service.proxy.openfeign;

import com.agutierrezl.client_service.model.response.CustomerDTO;
import com.agutierrezl.client_service.model.response.DocumentDTO;
import com.agutierrezl.client_service.model.response.LicenseDTO;
import com.agutierrezl.client_service.model.response.SubCategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "cloud-gateway")
public interface ICloudGatewayServiceFeign {

    @GetMapping("/api/document-service/documents")
    List<DocumentDTO> getAllDocuments();

    @GetMapping("/api/document-service/documents/{id}")
    DocumentDTO getByIdDocument(@PathVariable("id") String id);

    @PostMapping("/api/document-service/documents")
    DocumentDTO saveDocument(DocumentDTO documentDTO);

    @GetMapping("/api/document-service/documents/disabled/{id}")
    DocumentDTO disabledByIdDocument(@PathVariable("id") String id);


    /* Customer : Begin */
    @GetMapping("/api/customer-service/customers")
    List<CustomerDTO> getAllCustomers();

    @GetMapping("/api/customer-service/customers/{id}")
    CustomerDTO getByIdCustomer(@PathVariable("id") String id);
    /* Customer : End */

    /* Category : Begin */
    @GetMapping("/api/category-service/subcategories/{id}")
    SubCategoryDTO getByIdSubCategory(@PathVariable("id") String id);
    /* Category : Begin */

    /* License : Begin */
    @GetMapping("/api/license-service/licenses/{id}")
    LicenseDTO getByIdLicense(@PathVariable("id") String id);

    @PostMapping("/api/license-service/licenses")
    LicenseDTO saveLicense(LicenseDTO licenseDTO);
    /* License : Begin */


}
