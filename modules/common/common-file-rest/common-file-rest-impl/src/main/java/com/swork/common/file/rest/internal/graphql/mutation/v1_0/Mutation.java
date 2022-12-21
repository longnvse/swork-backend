package com.swork.common.file.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.multipart.MultipartBody;

import com.swork.common.file.rest.resource.v1_0.FileManagerResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setFileManagerResourceComponentServiceObjects(
		ComponentServiceObjects<FileManagerResource>
			fileManagerResourceComponentServiceObjects) {

		_fileManagerResourceComponentServiceObjects =
			fileManagerResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLName(
		description = "null",
		value = "postFileProjectIdPhaseIdWorkIdMultipartBody"
	)
	public boolean createFile(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("phaseId") Long phaseId,
			@GraphQLName("workId") Long workId,
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_fileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileManagerResource -> fileManagerResource.postFile(
				projectId, phaseId, workId, multipartBody));

		return true;
	}

	@GraphQLField
	public boolean deleteFileManagers(@GraphQLName("fileIds") Long[] fileIds)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_fileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileManagerResource -> fileManagerResource.deleteFileManagers(
				fileIds));

		return true;
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			FileManagerResource fileManagerResource)
		throws Exception {

		fileManagerResource.setContextAcceptLanguage(_acceptLanguage);
		fileManagerResource.setContextCompany(_company);
		fileManagerResource.setContextHttpServletRequest(_httpServletRequest);
		fileManagerResource.setContextHttpServletResponse(_httpServletResponse);
		fileManagerResource.setContextUriInfo(_uriInfo);
		fileManagerResource.setContextUser(_user);
		fileManagerResource.setGroupLocalService(_groupLocalService);
		fileManagerResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<FileManagerResource>
		_fileManagerResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}