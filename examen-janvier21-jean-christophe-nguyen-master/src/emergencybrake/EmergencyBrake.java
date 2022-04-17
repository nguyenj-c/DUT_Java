package emergencybrake;

import java.util.ArrayList;

public class EmergencyBrake {

    public static void main(String[] args) {
        // Note: All these vehicles are V2V compliant. Non connected vehicles are simply ignored in this application.
        // An obstacle is at the right of the ASCII sketch.
        // The Vehicle n°5 is at a distance of 10 meters from this obstacle and will trigger an emergency brake.
        //
        // Distance:  800m     700m      600m      500m      400m      300m      200m      100m       0m
        //            <---------|---------|---------|---------|---------|---------|---------|---------]
        // Veh. dist:   750m                            430m       320m            160m           10m
        // Lane:       \ō͡≡o˞̶                            \ō͡≡o˞̶       \ō͡≡o˞̶            \ō͡≡o˞̶           \ō͡≡o˞̶  /!\[Obstacle]
        // Vehicle Id:  (1)                             (2)        (3)             (4)            (5)

        // Instantiate an highway with a single lane
        ArrayList<VehicleV2V> lane = new ArrayList<>();

        // Instantiate vehicles
        VehicleV2V v1 = new VehicleV2V(1, 750);
        lane.add(v1);

        VehicleV2V v2 = new VehicleV2V(2, 430);
        lane.add(v2);

        VehicleV2V v3 = new VehicleV2V(3, 320);
        lane.add(v3);

        VehicleV2V v4 = new VehicleV2V(4, 160);
        lane.add(v4);

        VehicleV2V v5 = new VehicleV2V(5, 10);
        lane.add(v5);

        // Each vehicle should detect surrounding vehicles (in a perimeter which is less than 300 meters)
        for (VehicleV2V v : lane) {
            for (VehicleV2V other : lane) {
                // Do not compare any vehicle with itself
                if (other != v) {
                    // Check if the other vehicle is in the communication perimeter
                    if (Math.abs(other.getDistance() - v.getDistance()) < VehicleV2V.COMMUNICATION_DISTANCE_LIMIT) {
                        // Add the other vehicle to the list of surrounding vehicles compared to the current one
                        v.addSurroundingVehicle(other);
                    }
                }
            }
        }


        // Now, each vehicle check if any other vehicle in its communication perimeter is close enough
        // (ie: less than 200 meters) to trigger emergency braking
        for (VehicleV2V v : lane) {
            v.lookForHeads();
        }

        // We suppose all vehicles move at the same speed on the same lane.
        // Suddenly, the vehicle v5 encounters an obstacles and triggers an emergency brake!
        // The following should happen automatically:
        // v4 is 150m behind v5 so it should trigger emergency brake
        // v3 is 310m behind v5 (too far) BUT 160m behind v4 (close enough) so it should trigger emergency brake as well.
        // v2 is 110m behind v3 so it should trigger emergency brake as well
        // v1 is 320m behind v2, too far away, so it should not trigger emergency brake.
        v5.emergencyBrake();

    }
}
