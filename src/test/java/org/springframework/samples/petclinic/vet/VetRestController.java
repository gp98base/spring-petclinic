package org.springframework.samples.petclinic.vet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vets") // Base path for all vet-related API endpoints
public class VetRestController {
	private final VetRepository vetRepository;

	@Autowired
	public VetRestController(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@GetMapping
	public ResponseEntity<List<Vet>> getAllVets() {
		Vets vets = new Vets();
		vets.getVetList().addAll(vetRepository.findAll());
		return ResponseEntity.ok().body(vets.getVetList());
	}

}
