package org.comeia.project.converter;

import static java.util.Optional.ofNullable;

import java.util.Objects;

import org.comeia.project.domain.Document;
import org.comeia.project.dto.DocumentDTO;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DocumentConverter implements Converter<Document, DocumentDTO> {


	@Override
	public DocumentDTO from(Document entity) {
		
		if(Objects.isNull(entity)) {
			return null;
		}
		
		DocumentDTO dto = new DocumentDTO();
		
		ofNullable(entity.getId())
			.ifPresent(dto::setId);
		
		ofNullable(entity.getName())
			.ifPresent(dto::setName);
		
		ofNullable(entity.getType())
			.ifPresent(dto::setType);
		
		ofNullable(entity.getAuthor())
		.ifPresent(dto::setAuthor);
		
		return dto;
	}
	
	@Override
	public Document to(DocumentDTO dto, Document entity) {
		
		if(Objects.isNull(dto)) {
			return null;
		}

		if(Objects.isNull(entity)) {
			entity = new Document();
		}
		
		ofNullable(dto.getName())
			.ifPresent(entity::setName);
		
		ofNullable(dto.getType())
			.ifPresent(entity::setType);
		
		ofNullable(dto.getAuthor())
		.ifPresent(entity::setAuthor);
		
		return entity;
	}
	
}
