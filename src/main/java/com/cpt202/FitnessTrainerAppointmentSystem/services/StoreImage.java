package com.cpt202.FitnessTrainerAppointmentSystem.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class StoreImage {
    private final Path rootLocation = Paths.get("src\\main\\resources\\static");
    public String store(MultipartFile file){
        try {
            Files.createDirectories(rootLocation);
            Path destinationFile = rootLocation.resolve(
                Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();
            file.transferTo(destinationFile);
            return destinationFile.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }
}