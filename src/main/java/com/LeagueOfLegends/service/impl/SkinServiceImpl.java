package com.LeagueOfLegends.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.LeagueOfLegends.model.entity.Skin;

@Service
public class SkinServiceImpl {
	private List<Skin> skins = new ArrayList<>();
	private String response = new String();
	private HttpStatus status;

//	public String addSkin(Skin sent,Champion champion) {
//		response = "Ya existe esa skin";
//		status = HttpStatus.CONFLICT;
//
//		Skin skin = new Skin(sent.getName(), sent.getSplashArt(), sent.getColor(), sent.getTexture(),
//				sent.getPriceRiotPoints(), sent.getPriceOrangeEssence(), champion);
//
//		if (!skins.contains(skin)) {
//			if (addSkinToChampion(skin, champions)) {
//				skins.add(skin);
//				status = HttpStatus.CREATED;
//				response = "Skin creada correctamente";
//			} else {
//				status = HttpStatus.CONFLICT;
//				response = "No se pudo crear la skin porque no existe el champion";
//			}
//		}
//
//		return response;
//	}
//
//	private boolean addSkinToChampion(Skin skin, List<Champion> champions) {
//		boolean resul = false;
//
//		for (Champion i : champions) {
//			if (i.getId() == skin.getIDchampion()) {
//				i.getSkins().add(skin);
//				resul = true;
//			}
//		}
//		return resul;
//	}
//
//	public String getSkin(int id) {
//		response = "Skin no encontrada";
//		status = HttpStatus.NOT_FOUND;
//
//		for (Skin i : skins) {
//			if (i.getId() == id) {
//				response = i.toString();
//				status = HttpStatus.OK;
//			}
//		}
//
//		return response;
//	}
//
//	public String getAllSkins() {
//		response = "No existen skins";
//		status = HttpStatus.NOT_FOUND;
//
//		if (skins != null && !skins.isEmpty()) {
//			response = skins.toString();
//			status = HttpStatus.OK;
//		}
//		return response;
//	}
//
//	public String putSkin(Skin sent) {
//		response = "Skin no encontrada";
//		status = HttpStatus.NOT_FOUND;
//
//		for (Skin i : skins) {
//			if (i.getId() == sent.getId()) {
//				i.setPriceOrangeEssence(sent.getPriceOrangeEssence());
//				i.setPriceRiotPoints(sent.getPriceRiotPoints());
//
//				response = "Skin actualizada correctamente";
//				status = HttpStatus.OK;
//			}
//		}
//
//		return response;
//	}
//
//	public String deleteSkin(Skin sent) {
//		response = "Skin no encontrada";
//		status = HttpStatus.NOT_FOUND;
//
//		Skin skin = new Skin();
//
//		for (Skin i : skins) {
//			if (i.getId() == sent.getId()) {
//				skin = i;
//				response = "Skin borrada correctamente";
//				status = HttpStatus.OK;
//			}
//		}
//
//		skins.remove(skin);
//		return response;
//	}

	public HttpStatus getStatus() {
		return status;
	}

}
