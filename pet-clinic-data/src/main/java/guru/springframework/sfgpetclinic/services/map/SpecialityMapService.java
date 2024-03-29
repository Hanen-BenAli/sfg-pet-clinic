package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Specialty, Long> implements SpecialityService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Specialty t) {
        super.delete(t);
    }

    @Override
    public Specialty save(Specialty speciality) {
        return super.save(speciality);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
