package com.swork.auth.login.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.swork.auth.login.rest.internal.graphql.mutation.v1_0.Mutation;
import com.swork.auth.login.rest.internal.graphql.query.v1_0.Query;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Long Hip
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/login-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

}