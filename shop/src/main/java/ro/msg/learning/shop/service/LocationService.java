
package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.repository.ILocationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService implements ILocationService {
    private final ILocationRepository locationRepository;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }
    public void saveLocation(Location location){
        locationRepository.save(location);
    }
    public void deleteAll() {
        locationRepository.deleteAll();
    }
}