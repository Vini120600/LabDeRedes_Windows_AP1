package org.comeia.project.converter;

import static java.util.Optional.ofNullable;

import java.util.Objects;

import org.comeia.project.domain.Server;
import org.comeia.project.dto.ServerDTO;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ServerConverter implements Converter<Server, ServerDTO> {

	@Override
	public ServerDTO from(Server entity) {
		
		if(Objects.isNull(entity)) {
			return null;
		}
		
		ServerDTO dto = new ServerDTO();
		
		ofNullable(entity.getId())
			.ifPresent(dto::setId);
		
		ofNullable(entity.getName())
			.ifPresent(dto::setName);
		
		ofNullable(entity.getType())
			.ifPresent(dto::setType);
		
		ofNullable(entity.getAddress())
		.ifPresent(dto::setAddress);
		
		ofNullable(entity.getPort())
		.ifPresent(dto::setPort);
		
		return dto;
	}
	
	@Override
	public Server to(ServerDTO dto, Server entity) {
		
		if(Objects.isNull(dto)) {
			return null;
		}

		if(Objects.isNull(entity)) {
			entity = new Server();
		}
		
		ofNullable(dto.getName())
			.ifPresent(entity::setName);
		
		ofNullable(dto.getType())
			.ifPresent(entity::setType);
		
		ofNullable(dto.getAddress())
		.ifPresent(entity::setAddress);
		
		ofNullable(dto.getPort())
		.ifPresent(entity::setPort);
		
		return entity;
	}
}
