package space.portfolio.service.impl;

import org.springframework.stereotype.Service;

import space.portfolio.service.NameService;

@Service
public class NameServiceImpl implements NameService{

	@Override
	public String convertName(String name) {
		if (name != null && name.contains("-")) {
			name.toUpperCase();
			String[] fullName = name.split("-");
			return fullName[0] + " " + fullName[1];
		}
		return name.toUpperCase();
	}
}
