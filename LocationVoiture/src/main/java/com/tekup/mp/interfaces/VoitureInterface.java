package com.tekup.mp.interfaces;

import com.tekup.mp.models.Voiture;

public interface VoitureInterface {

	Iterable<Voiture> getAllVoitures();
	
	Voiture getVoitureById(Long id);
	
	Voiture saveVoiture(Voiture voiture);
	
}
