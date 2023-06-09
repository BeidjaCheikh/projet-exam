package com.mustaphaslimani;

import com.mustaphaslimani.stubs.RadarOuterClass;
import com.mustaphaslimani.stubs.RadarServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class Main {
    private static RadarServiceGrpc.RadarServiceBlockingStub stub;

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9096)
                .usePlaintext()
                .build();
        stub = RadarServiceGrpc.newBlockingStub(channel);
        Scanner sc = new Scanner(System.in);
        // Create new radar
        System.out.print("Enter radar max speed: ");
        Double maxSpeed = sc.nextDouble();
        System.out.print("Enter radar longitude: ");
        Double longitude = sc.nextDouble();
        System.out.print("Enter radar latitude : ");
        Double latitude = sc.nextDouble();
        Long radarId = createRadar(maxSpeed, longitude, latitude);
        System.out.print("Radar created with id: " + radarId);

        // Detect infraction
        int choice = 0;
        while(choice != 2) {
            System.out.println("1. Detect infraction");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle speed: ");
                    Double speed = sc.nextDouble();
                    System.out.print("Enter vehicle id: ");
                    Long vehicleId = sc.nextLong();
                    System.out.println("Detecting infraction...");
                    detectInfraction(radarId, vehicleId, speed);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static Long createRadar(Double maxSpeed, Double longitude, Double latitude) {
        return 4L;
    }

    private static void detectInfraction(Long radarId, Long vehicleId, Double speed) {
        RadarOuterClass.DetectRequest request = RadarOuterClass.DetectRequest.newBuilder()
                .setRadarId(radarId)
                .setVehicleId(vehicleId)
                .setSpeed(speed)
                .build();
        RadarOuterClass.Infraction infraction = stub.detectInfraction(request);
        System.out.println("Infraction detected-------------------------------- ");
        System.out.println(infraction);
        System.out.println("--------------------------------------------------- ");
    }
}