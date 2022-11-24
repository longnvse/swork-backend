package com.swork.core.resource.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.swork.core.resource.rest.internal.graphql.mutation.v1_0.Mutation;
import com.swork.core.resource.rest.internal.graphql.query.v1_0.Query;
import com.swork.core.resource.rest.resource.v1_0.ResourceResource;
import com.swork.core.resource.rest.resource.v1_0.ResourceTypeResource;
import com.swork.core.resource.rest.resource.v1_0.TeamResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Long Hip
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setResourceResourceComponentServiceObjects(
			_resourceResourceComponentServiceObjects);
		Mutation.setResourceTypeResourceComponentServiceObjects(
			_resourceTypeResourceComponentServiceObjects);
		Mutation.setTeamResourceComponentServiceObjects(
			_teamResourceComponentServiceObjects);

		Query.setResourceResourceComponentServiceObjects(
			_resourceResourceComponentServiceObjects);
		Query.setResourceTypeResourceComponentServiceObjects(
			_resourceTypeResourceComponentServiceObjects);
		Query.setTeamResourceComponentServiceObjects(
			_teamResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/swork/resource-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ResourceResource>
		_resourceResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ResourceTypeResource>
		_resourceTypeResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TeamResource>
		_teamResourceComponentServiceObjects;

}