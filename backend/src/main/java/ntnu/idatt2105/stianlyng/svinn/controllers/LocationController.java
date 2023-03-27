package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.entities.Location;
import ntnu.idatt2105.stianlyng.svinn.services.LocationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing location-related requests.
 */
@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;
    
    /**
     * Creates a new location using the provided Location instance.
     *
     * @param location the Location instance to be created
     * @return ResponseEntity containing the created Location instance
     */
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location createdLocation = locationService.createLocation(location);
        return ResponseEntity.ok(createdLocation);
    }

    /**
     * Retrieves all locations.
     *
     * @return ResponseEntity containing a list of all Location instances
     */
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }
    
    /**
     * Deletes a location with the specified ID.
     *
     * @param locationId the ID of the location to be deleted
     * @return ResponseEntity with an empty body and a No Content (204) status code
     */
    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Integer locationId) { // todo; consider @RequestBody
        locationService.deleteLocation(locationId);
        return ResponseEntity.noContent().build();
    }
    
    /**
     * Updates a location with the specified ID using the provided Location instance.
     *
     * @param locationId the ID of the location to be updated
     * @param updatedLocation the Location instance containing the updated information
     * @return ResponseEntity containing the updated Location instance
     */
    @PutMapping("/{locationId}")
    public ResponseEntity<Location> updateLocation(@PathVariable Integer locationId, @RequestBody Location updatedLocation) {
        Location location = locationService.updateLocation(locationId, updatedLocation);
        return ResponseEntity.ok(location);
    }
}