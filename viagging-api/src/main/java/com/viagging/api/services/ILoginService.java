package com.viagging.api.services;

import com.viagging.core.model.Usuario;

public interface ILoginService {

	Usuario getUserDetails(String login, String password);
	
}
