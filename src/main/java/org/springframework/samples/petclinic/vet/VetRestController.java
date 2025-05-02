package org.springframework.samples.petclinic.vet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vets")
public class VetRestController {

	private final VetRepository vetRepository;
	@Autowired
	public VetRestController(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@GetMapping()
	public List<Vet> getAllVets() {
		List<Vet> vets = new ArrayList<>();
		if (vetRepository.findAll() instanceof List<Vet>){
			vets = (List<Vet>) vetRepository.findAll();
		}
		return vets;
	}
}
