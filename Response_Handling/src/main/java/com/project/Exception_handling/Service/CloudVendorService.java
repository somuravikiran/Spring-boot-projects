package com.project.Exception_handling.Service;

import com.project.Exception_handling.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String vendorId);
    public CloudVendor getCloudVendorDetails(String vendorId);
    public List<CloudVendor> getAllCloudVendor();
}
