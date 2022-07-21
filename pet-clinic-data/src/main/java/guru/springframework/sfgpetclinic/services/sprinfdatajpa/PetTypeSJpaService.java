package guru.springframework.sfgpetclinic.services.sprinfdatajpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepostory;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSJpaService implements PetTypeService {
    private final PetTypeRepostory petTypeRepostory;

    public PetTypeSJpaService(PetTypeRepostory petTypeRepostory) {
        this.petTypeRepostory = petTypeRepostory;
    }


    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepostory.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepostory.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepostory.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepostory.delete(petType);
    }

    @Override
    public void deleteById(Long id) {

        petTypeRepostory.deleteById(id);
    }
}
