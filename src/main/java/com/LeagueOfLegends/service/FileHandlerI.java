package com.LeagueOfLegends.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileHandlerI<T> {

	public T addDocument(String id, MultipartFile mpf);
}
