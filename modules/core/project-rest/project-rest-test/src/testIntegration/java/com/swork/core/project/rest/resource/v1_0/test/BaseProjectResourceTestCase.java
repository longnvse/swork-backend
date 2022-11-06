package com.swork.core.project.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import com.swork.core.project.rest.client.dto.v1_0.Project;
import com.swork.core.project.rest.client.http.HttpInvoker;
import com.swork.core.project.rest.client.pagination.Page;
import com.swork.core.project.rest.client.pagination.Pagination;
import com.swork.core.project.rest.client.resource.v1_0.ProjectResource;
import com.swork.core.project.rest.client.serdes.v1_0.ProjectSerDes;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public abstract class BaseProjectResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_projectResource.setContextCompany(testCompany);

		ProjectResource.Builder builder = ProjectResource.builder();

		projectResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Project project1 = randomProject();

		String json = objectMapper.writeValueAsString(project1);

		Project project2 = ProjectSerDes.toDTO(json);

		Assert.assertTrue(equals(project1, project2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Project project = randomProject();

		String json1 = objectMapper.writeValueAsString(project);
		String json2 = ProjectSerDes.toJSON(project);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Project project = randomProject();

		project.setCode(regex);
		project.setDescription(regex);
		project.setExternalReferenceCode(regex);
		project.setName(regex);
		project.setProgressType(regex);
		project.setUnit(regex);

		String json = ProjectSerDes.toJSON(project);

		Assert.assertFalse(json.contains(regex));

		project = ProjectSerDes.toDTO(json);

		Assert.assertEquals(regex, project.getCode());
		Assert.assertEquals(regex, project.getDescription());
		Assert.assertEquals(regex, project.getExternalReferenceCode());
		Assert.assertEquals(regex, project.getName());
		Assert.assertEquals(regex, project.getProgressType());
		Assert.assertEquals(regex, project.getUnit());
	}

	@Test
	public void testGetProjectsPage() throws Exception {
		Page<Project> page = projectResource.getProjectsPage(
			RandomTestUtil.randomString(), null, null, Pagination.of(1, 10),
			null);

		long totalCount = page.getTotalCount();

		Project project1 = testGetProjectsPage_addProject(randomProject());

		Project project2 = testGetProjectsPage_addProject(randomProject());

		page = projectResource.getProjectsPage(
			null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(project1, (List<Project>)page.getItems());
		assertContains(project2, (List<Project>)page.getItems());
		assertValid(page);

		projectResource.deleteProject(project1.getId());

		projectResource.deleteProject(project2.getId());
	}

	@Test
	public void testGetProjectsPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = randomProject();

		project1 = testGetProjectsPage_addProject(project1);

		for (EntityField entityField : entityFields) {
			Page<Project> page = projectResource.getProjectsPage(
				null, null, getFilterString(entityField, "between", project1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(project1),
				(List<Project>)page.getItems());
		}
	}

	@Test
	public void testGetProjectsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = testGetProjectsPage_addProject(randomProject());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project2 = testGetProjectsPage_addProject(randomProject());

		for (EntityField entityField : entityFields) {
			Page<Project> page = projectResource.getProjectsPage(
				null, null, getFilterString(entityField, "eq", project1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(project1),
				(List<Project>)page.getItems());
		}
	}

	@Test
	public void testGetProjectsPageWithPagination() throws Exception {
		Page<Project> totalPage = projectResource.getProjectsPage(
			null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Project project1 = testGetProjectsPage_addProject(randomProject());

		Project project2 = testGetProjectsPage_addProject(randomProject());

		Project project3 = testGetProjectsPage_addProject(randomProject());

		Page<Project> page1 = projectResource.getProjectsPage(
			null, null, null, Pagination.of(1, totalCount + 2), null);

		List<Project> projects1 = (List<Project>)page1.getItems();

		Assert.assertEquals(
			projects1.toString(), totalCount + 2, projects1.size());

		Page<Project> page2 = projectResource.getProjectsPage(
			null, null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Project> projects2 = (List<Project>)page2.getItems();

		Assert.assertEquals(projects2.toString(), 1, projects2.size());

		Page<Project> page3 = projectResource.getProjectsPage(
			null, null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(project1, (List<Project>)page3.getItems());
		assertContains(project2, (List<Project>)page3.getItems());
		assertContains(project3, (List<Project>)page3.getItems());
	}

	@Test
	public void testGetProjectsPageWithSortDateTime() throws Exception {
		testGetProjectsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, project1, project2) -> {
				BeanUtils.setProperty(
					project1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetProjectsPageWithSortInteger() throws Exception {
		testGetProjectsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, project1, project2) -> {
				BeanUtils.setProperty(project1, entityField.getName(), 0);
				BeanUtils.setProperty(project2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetProjectsPageWithSortString() throws Exception {
		testGetProjectsPageWithSort(
			EntityField.Type.STRING,
			(entityField, project1, project2) -> {
				Class<?> clazz = project1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						project1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						project2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						project1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						project2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						project1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						project2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetProjectsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Project, Project, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = randomProject();
		Project project2 = randomProject();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, project1, project2);
		}

		project1 = testGetProjectsPage_addProject(project1);

		project2 = testGetProjectsPage_addProject(project2);

		for (EntityField entityField : entityFields) {
			Page<Project> ascPage = projectResource.getProjectsPage(
				null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(project1, project2),
				(List<Project>)ascPage.getItems());

			Page<Project> descPage = projectResource.getProjectsPage(
				null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(project2, project1),
				(List<Project>)descPage.getItems());
		}
	}

	protected Project testGetProjectsPage_addProject(Project project)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetProjectsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"projects",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject projectsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/projects");

		long totalCount = projectsJSONObject.getLong("totalCount");

		Project project1 = testGraphQLProject_addProject();
		Project project2 = testGraphQLProject_addProject();

		projectsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/projects");

		Assert.assertEquals(
			totalCount + 2, projectsJSONObject.getLong("totalCount"));

		assertContains(
			project1,
			Arrays.asList(
				ProjectSerDes.toDTOs(projectsJSONObject.getString("items"))));
		assertContains(
			project2,
			Arrays.asList(
				ProjectSerDes.toDTOs(projectsJSONObject.getString("items"))));
	}

	@Test
	public void testPostProject() throws Exception {
		Project randomProject = randomProject();

		Project postProject = testPostProject_addProject(randomProject);

		assertEquals(randomProject, postProject);
		assertValid(postProject);
	}

	protected Project testPostProject_addProject(Project project)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteProject() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project = testDeleteProject_addProject();

		assertHttpResponseStatusCode(
			204, projectResource.deleteProjectHttpResponse(project.getId()));

		assertHttpResponseStatusCode(
			404, projectResource.getProjectHttpResponse(project.getId()));

		assertHttpResponseStatusCode(
			404, projectResource.getProjectHttpResponse(0L));
	}

	protected Project testDeleteProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteProject() throws Exception {
		Project project = testGraphQLProject_addProject();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteProject",
						new HashMap<String, Object>() {
							{
								put("projectId", project.getId());
							}
						})),
				"JSONObject/data", "Object/deleteProject"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"project",
					new HashMap<String, Object>() {
						{
							put("projectId", project.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetProject() throws Exception {
		Project postProject = testGetProject_addProject();

		Project getProject = projectResource.getProject(postProject.getId());

		assertEquals(postProject, getProject);
		assertValid(getProject);
	}

	protected Project testGetProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetProject() throws Exception {
		Project project = testGraphQLProject_addProject();

		Assert.assertTrue(
			equals(
				project,
				ProjectSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"project",
								new HashMap<String, Object>() {
									{
										put("projectId", project.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/project"))));
	}

	@Test
	public void testGraphQLGetProjectNotFound() throws Exception {
		Long irrelevantProjectId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"project",
						new HashMap<String, Object>() {
							{
								put("projectId", irrelevantProjectId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutProject() throws Exception {
		Project postProject = testPutProject_addProject();

		Project randomProject = randomProject();

		Project putProject = projectResource.putProject(
			postProject.getId(), randomProject);

		assertEquals(randomProject, putProject);
		assertValid(putProject);

		Project getProject = projectResource.getProject(putProject.getId());

		assertEquals(randomProject, getProject);
		assertValid(getProject);
	}

	protected Project testPutProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testApprovalProject() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project = testApprovalProject_addProject();

		assertHttpResponseStatusCode(
			204,
			projectResource.approvalProjectHttpResponse(
				project.getId(), project));

		assertHttpResponseStatusCode(
			404, projectResource.approvalProjectHttpResponse(0L, project));
	}

	protected Project testApprovalProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateDescriptionProject() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project = testUpdateDescriptionProject_addProject();

		assertHttpResponseStatusCode(
			204,
			projectResource.updateDescriptionProjectHttpResponse(
				project.getId(), project));

		assertHttpResponseStatusCode(
			404,
			projectResource.updateDescriptionProjectHttpResponse(0L, project));
	}

	protected Project testUpdateDescriptionProject_addProject()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateDateProject() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project = testUpdateDateProject_addProject();

		assertHttpResponseStatusCode(
			204,
			projectResource.updateDateProjectHttpResponse(
				project.getId(), project));

		assertHttpResponseStatusCode(
			404, projectResource.updateDateProjectHttpResponse(0L, project));
	}

	protected Project testUpdateDateProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateActualDateProject() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project = testUpdateActualDateProject_addProject();

		assertHttpResponseStatusCode(
			204,
			projectResource.updateActualDateProjectHttpResponse(
				project.getId(), project));

		assertHttpResponseStatusCode(
			404,
			projectResource.updateActualDateProjectHttpResponse(0L, project));
	}

	protected Project testUpdateActualDateProject_addProject()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateMemberProject() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project = testUpdateMemberProject_addProject();

		assertHttpResponseStatusCode(
			204,
			projectResource.updateMemberProjectHttpResponse(
				project.getId(), project));

		assertHttpResponseStatusCode(
			404, projectResource.updateMemberProjectHttpResponse(0L, project));
	}

	protected Project testUpdateMemberProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Project testGraphQLProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Project project, List<Project> projects) {
		boolean contains = false;

		for (Project item : projects) {
			if (equals(project, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(projects + " does not contain " + project, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Project project1, Project project2) {
		Assert.assertTrue(
			project1 + " does not equal " + project2,
			equals(project1, project2));
	}

	protected void assertEquals(
		List<Project> projects1, List<Project> projects2) {

		Assert.assertEquals(projects1.size(), projects2.size());

		for (int i = 0; i < projects1.size(); i++) {
			Project project1 = projects1.get(i);
			Project project2 = projects2.get(i);

			assertEquals(project1, project2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Project> projects1, List<Project> projects2) {

		Assert.assertEquals(projects1.size(), projects2.size());

		for (Project project1 : projects1) {
			boolean contains = false;

			for (Project project2 : projects2) {
				if (equals(project1, project2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				projects2 + " does not contain " + project1, contains);
		}
	}

	protected void assertValid(Project project) throws Exception {
		boolean valid = true;

		if (project.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actualEndDate", additionalAssertFieldName)) {
				if (project.getActualEndDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("actualStartDate", additionalAssertFieldName)) {
				if (project.getActualStartDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("budget", additionalAssertFieldName)) {
				if (project.getBudget() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (project.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (project.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("endDate", additionalAssertFieldName)) {
				if (project.getEndDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (project.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("handles", additionalAssertFieldName)) {
				if (project.getHandles() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("manages", additionalAssertFieldName)) {
				if (project.getManages() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (project.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("participates", additionalAssertFieldName)) {
				if (project.getParticipates() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("progress", additionalAssertFieldName)) {
				if (project.getProgress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("progressType", additionalAssertFieldName)) {
				if (project.getProgressType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (project.getStartDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (project.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (project.getUnit() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Project> page) {
		boolean valid = false;

		java.util.Collection<Project> projects = page.getItems();

		int size = projects.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.swork.core.project.rest.dto.v1_0.Project.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Project project1, Project project2) {
		if (project1 == project2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actualEndDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getActualEndDate(),
						project2.getActualEndDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("actualStartDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getActualStartDate(),
						project2.getActualStartDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("budget", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getBudget(), project2.getBudget())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getCode(), project2.getCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getDescription(), project2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("endDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getEndDate(), project2.getEndDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						project1.getExternalReferenceCode(),
						project2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("handles", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getHandles(), project2.getHandles())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(project1.getId(), project2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("manages", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getManages(), project2.getManages())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getName(), project2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("participates", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getParticipates(),
						project2.getParticipates())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("progress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getProgress(), project2.getProgress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("progressType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getProgressType(),
						project2.getProgressType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getStartDate(), project2.getStartDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getStatus(), project2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getUnit(), project2.getUnit())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_projectResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_projectResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Project project) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("actualEndDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getActualEndDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getActualEndDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getActualEndDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("actualStartDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							project.getActualStartDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getActualStartDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getActualStartDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("budget")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("code")) {
			sb.append("'");
			sb.append(String.valueOf(project.getCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(project.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("endDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getEndDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getEndDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getEndDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(project.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("handles")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("manages")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(project.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("participates")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("progress")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("progressType")) {
			sb.append("'");
			sb.append(String.valueOf(project.getProgressType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("startDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getStartDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getStartDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getStartDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("unit")) {
			sb.append("'");
			sb.append(String.valueOf(project.getUnit()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Project randomProject() throws Exception {
		return new Project() {
			{
				actualEndDate = RandomTestUtil.nextDate();
				actualStartDate = RandomTestUtil.nextDate();
				budget = RandomTestUtil.randomLong();
				code = StringUtil.toLowerCase(RandomTestUtil.randomString());
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				endDate = RandomTestUtil.nextDate();
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				progress = RandomTestUtil.randomInt();
				progressType = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				startDate = RandomTestUtil.nextDate();
				unit = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Project randomIrrelevantProject() throws Exception {
		Project randomIrrelevantProject = randomProject();

		return randomIrrelevantProject;
	}

	protected Project randomPatchProject() throws Exception {
		return randomProject();
	}

	protected ProjectResource projectResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseProjectResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.swork.core.project.rest.resource.v1_0.ProjectResource
		_projectResource;

}