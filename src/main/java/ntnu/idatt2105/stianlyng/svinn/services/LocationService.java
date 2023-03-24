package ntnu.idatt2105.stianlyng.svinn.services;

    
import ntnu.idatt2105.stianlyng.svinn.entities.Location;
import ntnu.idatt2105.stianlyng.svinn.repositories.LocationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }
    
    
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
    
    public void deleteLocation(Integer locationId) {
        locationRepository.deleteById(locationId);
    }
    
    public Location updateLocation(Integer locationId, Location updatedLocation) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        location.setName(updatedLocation.getName());
        location.setLatitude(updatedLocation.getLatitude());
        location.setLongtitude(updatedLocation.getLongtitude());
        return locationRepository.save(location);
    }
    
}