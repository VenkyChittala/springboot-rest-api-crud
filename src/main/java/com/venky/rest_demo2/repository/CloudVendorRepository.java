package com.venky.rest_demo2.repository;

import com.venky.rest_demo2.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
}
