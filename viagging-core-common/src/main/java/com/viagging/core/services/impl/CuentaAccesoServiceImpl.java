package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.CuentaAccesoDAO;
import com.viagging.core.model.CuentaAcceso;
import com.viagging.core.services.CuentaAccesoService;

@Service
public class CuentaAccesoServiceImpl implements  CuentaAccesoService  {

	@Autowired
	private CuentaAccesoDAO cuentaAccesoDAO;

	@Override
	public CuentaAcceso createCuentaAcceso(CuentaAcceso cuentaAcceso) {
		return cuentaAccesoDAO.createCuentaAcceso(cuentaAcceso);
    }

}