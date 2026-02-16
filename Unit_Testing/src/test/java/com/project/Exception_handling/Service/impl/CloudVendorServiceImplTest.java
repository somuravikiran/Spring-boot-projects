package com.project.Exception_handling.Service.impl;

import com.project.Exception_handling.Repository.CloudVendorRepository;
import com.project.Exception_handling.Service.CloudVendorService;
import com.project.Exception_handling.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        cloudVendorService=new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor new CloudVendor("1","Amazon","USA","xxxxx");
    }

    @AfterEach
    void tearDown() {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class )
    }

    @Test
    void updateCloudVendor() {
    }

    @Test
    void deleteCloudVendor() {
    }

    @Test
    void getCloudVendorDetails() {
    }

    @Test
    void getAllCloudVendor() {
    }
}