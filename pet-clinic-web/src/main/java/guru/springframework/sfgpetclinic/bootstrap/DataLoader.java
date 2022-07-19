package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;

        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        cat = petTypeService.save(cat);

        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("Michael");
        o1.setLastName("Weston");
        o1.setAddress("add a1");
        o1.setCity("city1");
        o1.setTelephone("1111111");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setOwner(o1);
        mikesPet.setBirthday(LocalDate.now());
        mikesPet.setName("Rosco");

        o1.getPets().add(mikesPet);

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setId(2L);
        o2.setFirstName("Fiona");
        o2.setLastName("Glenanne");
        o2.setAddress("add a2");
        o2.setCity("city2");
        o2.setTelephone("22222222");

        Pet fionacat = new Pet();
        fionacat.setPetType(cat);
        fionacat.setOwner(o2);
        fionacat.setBirthday(LocalDate.now());
        fionacat.setName("CATTT");

        o1.getPets().add(fionacat);

        ownerService.save(o2);

        System.out.println("Loaded owners......");

        Vet v1 = new Vet();
        v1.setFirstName("Sam");
        v1.setLastName("Axe");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Jessie");
        v2.setLastName("Porter");

        vetService.save(v2);

        System.out.println("loaded Vets..........");

    }
}
