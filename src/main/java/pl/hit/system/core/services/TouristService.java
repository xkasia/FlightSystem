package pl.hit.system.core.services;

import pl.hit.system.data.repositories.TouristRepository;

public class TouristService {

    private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }
}
