package com.swork.core.project.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.swork.core.project.rest.internal.graphql.mutation.v1_0.Mutation;
import com.swork.core.project.rest.internal.graphql.query.v1_0.Query;
import com.swork.core.project.rest.resource.v1_0.ChartResource;
import com.swork.core.project.rest.resource.v1_0.ProjectResource;

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
		Mutation.setProjectResourceComponentServiceObjects(
			_projectResourceComponentServiceObjects);

		Query.setChartResourceComponentServiceObjects(
			_chartResourceComponentServiceObjects);
		Query.setProjectResourceComponentServiceObjects(
			_projectResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/swork/project-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ProjectResource>
		_projectResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ChartResource>
		_chartResourceComponentServiceObjects;

}