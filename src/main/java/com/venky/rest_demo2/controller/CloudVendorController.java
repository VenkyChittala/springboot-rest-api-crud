package com.venky.rest_demo2.controller;

import com.venky.rest_demo2.model.CloudVendor;
import com.venky.rest_demo2.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CloudVendorController {
    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

//    @GetMapping("{vendorId}")
//    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
//        return cloudVendorService.getCloudVendor(vendorId);
//    }


    @GetMapping("/{vendorId}")
    public ResponseEntity<CloudVendor> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        CloudVendor vendor = cloudVendorService.getCloudVendor(vendorId);
        if (vendor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vendor);
    }

    @PostMapping("/")
    public ResponseEntity<String> createCloudVendor(@RequestBody CloudVendor cloudVendor) {
        String response = cloudVendorService.createCloudVendor(cloudVendor);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{vendorId}")
    public ResponseEntity<String> updateCloudVendor(@PathVariable("vendorId") String vendorId, @RequestBody CloudVendor cloudVendor) {
        cloudVendor.setVendorId(vendorId); // Ensure the ID is set correctly
        String response = cloudVendorService.updateCloudVendor(cloudVendor);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<String> deleteCloudVendor(@PathVariable("vendorId") String vendorId) {
        String response = cloudVendorService.deleteCloudVendor(vendorId);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Vendor deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<CloudVendor>> getAllCloudVendors() {
        List<CloudVendor> vendors = cloudVendorService.getAllCloudVendors();
        if (vendors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vendors);
    }

}