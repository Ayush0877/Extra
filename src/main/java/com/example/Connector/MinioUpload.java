package com.example.Connector;

import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class MinioUpload {
    public static void main(String[] args) {
        String minioEndpoint = "http://127.0.0.1:59777"; // Replace with your MinIO server endpoint
        String accessKey = "2NelhKaffFpPtYqAgcHd";
        String secretKey = "LAwftrB9JApVn7gn6txNjUs2Dd7zfBzKXPHx61ri";
        String bucketName = "ayush";
        String objectName = "demo"; // The object name in the MinIO bucket

        try {
            // Initialize the MinioClient with your credentials and endpoint
            MinioClient minioClient = new MinioClient(minioEndpoint, accessKey, secretKey);

            // Check if the bucket exists, create one if not
            boolean found = minioClient.bucketExists(bucketName);
            if (!found) {
                minioClient.makeBucket(bucketName);
                System.out.println("Bucket created successfully: " + bucketName);
            } else {
                System.out.println("Bucket already exists: " + bucketName);
            }

            // Upload the file to the bucket
            minioClient.putObject(bucketName, objectName, filePath);
            System.out.println("File uploaded successfully to MinIO: " + objectName);
        } catch (MinioException | IOException e) {
            e.printStackTrace();
        }
    }
}

