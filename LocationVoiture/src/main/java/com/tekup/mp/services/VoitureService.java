package com.tekup.mp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.mp.models.Voiture;
import com.tekup.mp.repository.VoitureRepository;

@Service
public class VoitureService {

	@Autowired
	VoitureRepository voitureRepository;
	
	public void addVoiture(Voiture voiture) {
		Voiture v = voitureRepository.save(voiture);
	}
}
