package com.LeagueOfLegends.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.LeagueOfLegends.entity.Champion;
import com.LeagueOfLegends.entity.Player;

@Service
public class ChampionService {

	private List<Champion> champions = new ArrayList<>();
	private String response = new String();
	private HttpStatus status;

	public String addChampion(Champion sent) {
		response = "Ya existe ese campeon";
		status = HttpStatus.CONFLICT;

		Champion champion = new Champion(sent.getId(), sent.getName(), sent.getAttackDamage(), sent.getAbilityPower(),
				sent.getArmor(), sent.getMagicResist(), sent.getRange(), sent.getCriticalDamage(),
				sent.getCooldownReduction(), sent.getSpeedMovement());

		if (!champions.contains(champion)) {
			champions.add(champion);
			status = HttpStatus.CREATED;
			response = "Campeon creado correctamente";
		}
		return response;
	}

	public String getChampion(int id) {
		response = "Campeon no encontrado";
		status = HttpStatus.NOT_FOUND;

		for (Champion i : champions) {
			if (i.getId() == id) {
				response = i.toString();
				status = HttpStatus.OK;
			}
		}
		return response;
	}

	public String getAllChampions() {
		response = "No existen campeones";
		status = HttpStatus.NOT_FOUND;

		if (champions != null && !champions.isEmpty()) {
			response = champions.toString();
			status = HttpStatus.OK;
		}
		return response;
	}

	public String putChampion(Champion sent) {
		response = "Campeon no encontrado";
		status = HttpStatus.NOT_FOUND;

		for (Champion i : champions) {
			if (i.getId() == sent.getId()) {
				i.setAbilityPower(sent.getAbilityPower());
				i.setArmor(sent.getArmor());
				i.setAttackDamage(sent.getAttackDamage());
				i.setCooldownReduction(sent.getCooldownReduction());
				i.setCriticalDamage(sent.getCriticalDamage());
				i.setMagicResist(sent.getMagicResist());
				i.setRange(sent.getRange());
				i.setSpeedMovement(sent.getSpeedMovement());

				response = "Campeon actualizado correctamente";
				status = HttpStatus.OK;
			}
		}

		return response;
	}

	public String deleteChampion(Champion sent, List<Player> players) {
		response = "Campeon no encontrado";
		status = HttpStatus.NOT_FOUND;
		boolean encontradoChampion = false;
		
		Champion champion = new Champion();
		Integer idPlayer = null;
		
		if (champions != null && !champions.isEmpty()) {
			for (Champion i : champions) {
				if (i.getId() == sent.getId()) {
					champion = i;
					encontradoChampion = true;
				}
			}
		}
			
		if(players != null && !players.isEmpty()) {
			for (Player i : players) {
				if(i.getChampionsId() != null && !i.getChampionsId().isEmpty()) {
					for (Integer j : i.getChampionsId()) {
						if (j == sent.getId()) {
							idPlayer = j;
						}
					}
					i.getChampionsId().remove(idPlayer);
				}
			}
			
		}
		
		if(encontradoChampion == true) {
			champions.remove(champion);
			response = "Campeon borrado correctamente";
			status = HttpStatus.OK;
		}
		
		return response;

	}

	public List<Champion> getChampions() {
		return champions;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
