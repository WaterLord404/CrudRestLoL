package com.LeagueOfLegends.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.LeagueOfLegends.model.entity.Champion;
import com.LeagueOfLegends.model.repository.ChampionRepository;

@Service
public class ChampionService {

	private String response = new String();
	private HttpStatus status;

	@Autowired
	private ChampionRepository championRepository;

	public String addChampion(Champion sent) {
		response = "Ya existe el campeon";
		status = HttpStatus.CONFLICT;
		
		//si encuentra 2 campeones por el nombre no se añade
		if(championRepository.findChampionByName(sent.getName()).size() != 1) {
			
			Champion champion = new Champion(sent.getName(), sent.getAttackDamage(), sent.getAbilityPower(),
					sent.getArmor(), sent.getMagicResist(), sent.getRangeAttack(), sent.getCriticalDamage(),
					sent.getCooldownReduction(), sent.getSpeedMovement());

			championRepository.save(champion);

			status = HttpStatus.CREATED;
			response = "Campeon creado correctamente";
		}

		return response;
	}

	public List<Champion> getAllChampions() {
		status = HttpStatus.NOT_FOUND;
		List<Champion> champions = null;
		
		if (championRepository.findAll().spliterator().getExactSizeIfKnown() != 0) {
			champions = (List<Champion>) championRepository.findAll();
			status = HttpStatus.OK;
		}
		return champions;
	}
	
	public List<Champion> getAllChampionsOrderedByAttackDamageDesc() {
		status = HttpStatus.NOT_FOUND;
		List<Champion> champions = null;
		
		if (championRepository.findAll().spliterator().getExactSizeIfKnown() != 0) {
			champions = (List<Champion>) championRepository.findAllOrderedByAttackDamageDesc();
			status = HttpStatus.OK;
		}
		return champions;
	}

	public Champion getChampion(int id) {
		status = HttpStatus.NOT_FOUND;
		Champion champion = null;
		
		if (championRepository.findChampionById(id) != null) {
			champion = championRepository.findChampionById(id);
			status = HttpStatus.OK;
		}
		return champion;
	}

	public String putChampion(Champion sent) {
		response = "Campeon n	o encontrado";
		status = HttpStatus.NOT_FOUND;

		if (championRepository.findChampionById(sent.getId()) != null) {

			championRepository.findChampionById(sent.getId()).setAbilityPower(sent.getAbilityPower());
			championRepository.findChampionById(sent.getId()).setArmor(sent.getArmor());
			championRepository.findChampionById(sent.getId()).setAttackDamage(sent.getAttackDamage());
			championRepository.findChampionById(sent.getId()).setCooldownReduction(sent.getCooldownReduction());
			championRepository.findChampionById(sent.getId()).setCriticalDamage(sent.getCriticalDamage());
			championRepository.findChampionById(sent.getId()).setMagicResist(sent.getMagicResist());
			championRepository.findChampionById(sent.getId()).setRangeAttack(sent.getRangeAttack());
			championRepository.findChampionById(sent.getId()).setSpeedMovement(sent.getSpeedMovement());

			// Persist data
			championRepository.save(championRepository.findChampionById(sent.getId()));

			response = "Campeon actualizado correctamente";
			status = HttpStatus.OK;
		}
		return response;
	}

	public String deleteChampion(Champion sent) {
		response = "Campeon no encontrado";
		status = HttpStatus.NOT_FOUND;

		if (championRepository.findChampionById(sent.getId()) != null) {
			championRepository.delete(championRepository.findChampionById(sent.getId()));
			response = "Campeon borrado correctamente";
			status = HttpStatus.OK;
		}
		return response;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
