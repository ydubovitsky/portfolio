package space.portfolio.service.impl;

import org.springframework.stereotype.Service;

import space.portfolio.service.NameService;

@Service
public class NameServiceImpl implements NameService{

	@Override
	public String convertName(String name) {
		return name.toUpperCase();
	}
}
