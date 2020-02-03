package com.tekup.mp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.mp.interfaces.VoitureInterface;
import com.tekup.mp.models.Voiture;
import com.tekup.mp.repository.VoitureRepository;

@Service
public class VoitureService implements VoitureInterface{

	@Autowired
	private VoitureRepository voitureRepository;

	@Override
	public Iterable<Voiture> getAllVoitures() {
		return voitureRepository.findAll();
	}

	@Override
	public Voiture getVoitureById(Long id) {
		return voitureRepository.findById(id).orElse(null);
	}

	@Override
	public Voiture saveVoiture(Voiture voiture) {
		return voitureRepository.save(voiture);
	}
}
