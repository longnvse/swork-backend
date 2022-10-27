package com.swork.account.rest.internal.resource.v1_0;

import com.swork.account.rest.resource.v1_0.AccountPermisionResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Long Hip
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/account-permision.properties",
	scope = ServiceScope.PROTOTYPE, service = AccountPermisionResource.class
)
public class AccountPermisionResourceImpl
	extends BaseAccountPermisionResourceImpl {
}