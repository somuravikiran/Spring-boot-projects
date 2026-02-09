package com.project.Exception_handling.controller;

import com.project.Exception_handling.Service.CloudVendorService;
import com.project.Exception_handling.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CouldVendorController {

    CloudVendorService cloudVendorServiceImpl;

    public CouldVendorController(CloudVendorService cloudVendorServiceImpl) {
        this.cloudVendorServiceImpl = cloudVendorServiceImpl;
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorServiceImpl.getAllCloudVendor();
    }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return cloudVendorServiceImpl.getCloudVendorDetails(vendorId);
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorServiceImpl.createCloudVendor(cloudVendor);
        return "cloud vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorServiceImpl.updateCloudVendor(cloudVendor);
        return "cloud vendor updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("VendorId") String vendorId){
        cloudVendorServiceImpl.deleteCloudVendor(vendorId);
        return "cloud vendor deleted successfully";
    }
}
