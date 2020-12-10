package com.example.demo.service;

import com.example.demo.domain.Space;
import com.example.demo.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    SpaceRepository spaceRepository;

    @Override
    public Space getSpace(Long id) throws Exception {
        return spaceRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    @Override
    public List<Space> getAllSpacesForHost(Long hostId) {
        return spaceRepository.findByHostId(hostId);
    }

    @Override
    public Space createSpace(Space space) {
        return spaceRepository.saveAndFlush(space);
    }

    @Override
    public Space updateSpace(Long id, Space space) throws Exception {
        Space updatedSpace = getSpace(id);
        Optional.ofNullable(space.getHostId()).ifPresent(updatedSpace::setHostId);
        Optional.ofNullable(space.getMaxGuestLimit()).ifPresent(updatedSpace::setMaxGuestLimit);
        Optional.ofNullable(space.getType()).ifPresent(updatedSpace::setType);
        Optional.ofNullable(space.getName()).ifPresent(updatedSpace::setName);
        Optional.ofNullable(space.getDescription()).ifPresent(updatedSpace::setDescription);
        Optional.ofNullable(space.getAmenities()).ifPresent(updatedSpace::setAmenities);
        Optional.ofNullable(space.getAddressLine1()).ifPresent(updatedSpace::setAddressLine1);
        Optional.ofNullable(space.getAddressLine2()).ifPresent(updatedSpace::setAddressLine2);
        Optional.ofNullable(space.getCity()).ifPresent(updatedSpace::setCity);
        Optional.ofNullable(space.getZipCode()).ifPresent(updatedSpace::setZipCode);
        Optional.ofNullable(space.getCountry()).ifPresent(updatedSpace::setCountry);
        return spaceRepository.saveAndFlush(updatedSpace);
    }

    @Override
    public void deleteSpace(Long id) {
        spaceRepository.deleteById(id);
    }
}
