package emergencybrake;

import java.util.ArrayList;


/**
 *
 */
public class VehicleV2V implements Follower extends Head{
    static final float FOLLOWER_DISTANCE_LIMIT = 200;
    static final float COMMUNICATION_DISTANCE_LIMIT = 300;
    private ArrayList<VehicleV2V> surroundingVehicles = new ArrayList<>();
    private int id;
    private float distance;

    /**
     * Default constructor
     */
    public VehicleV2V(int id, float distance) {
        this.id = id;
        this.distance = distance;
    }

    /**
     * Return the distance of the vehicle from the reference (the obstacle at 0 meter).
     *
     * @return the distance, in meters
     */
    public float getDistance() {
        return distance;
    }

    /**
     * Trigger an emergency brake for the current vehicle. The vehicle should alert the followers.
     */
    public void emergencyBrake() {
        System.out.println("Vehicle " + this.id + ": emergency braking! Sending signal to followers");
    }

    /**
     * Add a given vehicle to the surrounding vehicles list so they are in the communication radius
     *
     * @param other: the other vehicle
     */
    public void addSurroundingVehicle(VehicleV2V other) {
        surroundingVehicles.add(other);
    }

    /**
     * Check if the current vehicle is ahead of another vehicle
     *
     * @param other the other vehicle
     * @return True if the vehicle is ahead (distance less than 200m)
     */
    public boolean isAhead(VehicleV2V other) {
        return ((other.distance - this.distance) > 0 && (other.distance - this.distance) < FOLLOWER_DISTANCE_LIMIT);
    }

    /**
     * Look for the heading vehicles (ahead with a distance less than 200m) among the surrounding vehicles.
     */
    public void lookForHeads() {
        for (VehicleV2V v : surroundingVehicles) {
            for (VehicleV2V others : surroundingVehicles) {
                if (others != v) {
                    if (Math.abs(surroundingVehicles.getDistance() - v.getDistance()) < VehicleV2V.COMMUNICATION_DISTANCE_LIMIT) {
                        v.registerFollower(others)
                    }
                }
            }
        }
    }
    public void notifyEmergencyBrake{
        System.out.println("vehicule " +this.id + ": notified of an emergency break ahead");
    }
    pubic abstract void registerFollower(f follower){
        surroundingVehicles.add(follower);
    }
    pubic abstract void unregisterFollower(f follower){
        surroundingVehicles.remove(follower);
    }
    pubic abstract void notifyAllFollower(){
        for (Follower c : surroundingVehicles) {
            c.emergencyBrake();
            c.notifyEmergencyBrake();
        }
    }
}
