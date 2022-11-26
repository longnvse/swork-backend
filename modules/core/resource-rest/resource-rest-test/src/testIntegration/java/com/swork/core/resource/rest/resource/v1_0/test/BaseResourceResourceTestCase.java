package com.swork.core.resource.rest.resource.v1_0.test;

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

import com.swork.core.resource.rest.client.dto.v1_0.Resource;
import com.swork.core.resource.rest.client.http.HttpInvoker;
import com.swork.core.resource.rest.client.pagination.Page;
import com.swork.core.resource.rest.client.pagination.Pagination;
import com.swork.core.resource.rest.client.resource.v1_0.ResourceResource;
import com.swork.core.resource.rest.client.serdes.v1_0.ResourceSerDes;

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
public abstract class BaseResourceResourceTestCase {

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

		_resourceResource.setContextCompany(testCompany);

		ResourceResource.Builder builder = ResourceResource.builder();

		resourceResource = builder.authentication(
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

		Resource resource1 = randomResource();

		String json = objectMapper.writeValueAsString(resource1);

		Resource resource2 = ResourceSerDes.toDTO(json);

		Assert.assertTrue(equals(resource1, resource2));
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

		Resource resource = randomResource();

		String json1 = objectMapper.writeValueAsString(resource);
		String json2 = ResourceSerDes.toJSON(resource);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Resource resource = randomResource();

		resource.setCreator(regex);
		resource.setExternalReferenceCode(regex);
		resource.setParentName(regex);
		resource.setResourceTypeName(regex);
		resource.setTeamName(regex);
		resource.setUnit(regex);

		String json = ResourceSerDes.toJSON(resource);

		Assert.assertFalse(json.contains(regex));

		resource = ResourceSerDes.toDTO(json);

		Assert.assertEquals(regex, resource.getCreator());
		Assert.assertEquals(regex, resource.getExternalReferenceCode());
		Assert.assertEquals(regex, resource.getParentName());
		Assert.assertEquals(regex, resource.getResourceTypeName());
		Assert.assertEquals(regex, resource.getTeamName());
		Assert.assertEquals(regex, resource.getUnit());
	}

	@Test
	public void testGetTotalMoneyInProject() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetResourcePages() throws Exception {
		Page<Resource> page = resourceResource.getResourcePages(
			null, null, null, null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Resource resource1 = testGetResourcePages_addResource(randomResource());

		Resource resource2 = testGetResourcePages_addResource(randomResource());

		page = resourceResource.getResourcePages(
			null, null, null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(resource1, (List<Resource>)page.getItems());
		assertContains(resource2, (List<Resource>)page.getItems());
		assertValid(page);

		resourceResource.deleteResource(resource1.getId());

		resourceResource.deleteResource(resource2.getId());
	}

	@Test
	public void testGetResourcePagesWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Resource resource1 = randomResource();

		resource1 = testGetResourcePages_addResource(resource1);

		for (EntityField entityField : entityFields) {
			Page<Resource> page = resourceResource.getResourcePages(
				null, null, null, null,
				getFilterString(entityField, "between", resource1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(resource1),
				(List<Resource>)page.getItems());
		}
	}

	@Test
	public void testGetResourcePagesWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Resource resource1 = testGetResourcePages_addResource(randomResource());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Resource resource2 = testGetResourcePages_addResource(randomResource());

		for (EntityField entityField : entityFields) {
			Page<Resource> page = resourceResource.getResourcePages(
				null, null, null, null,
				getFilterString(entityField, "eq", resource1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(resource1),
				(List<Resource>)page.getItems());
		}
	}

	@Test
	public void testGetResourcePagesWithPagination() throws Exception {
		Page<Resource> totalPage = resourceResource.getResourcePages(
			null, null, null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Resource resource1 = testGetResourcePages_addResource(randomResource());

		Resource resource2 = testGetResourcePages_addResource(randomResource());

		Resource resource3 = testGetResourcePages_addResource(randomResource());

		Page<Resource> page1 = resourceResource.getResourcePages(
			null, null, null, null, null, Pagination.of(1, totalCount + 2),
			null);

		List<Resource> resources1 = (List<Resource>)page1.getItems();

		Assert.assertEquals(
			resources1.toString(), totalCount + 2, resources1.size());

		Page<Resource> page2 = resourceResource.getResourcePages(
			null, null, null, null, null, Pagination.of(2, totalCount + 2),
			null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Resource> resources2 = (List<Resource>)page2.getItems();

		Assert.assertEquals(resources2.toString(), 1, resources2.size());

		Page<Resource> page3 = resourceResource.getResourcePages(
			null, null, null, null, null, Pagination.of(1, totalCount + 3),
			null);

		assertContains(resource1, (List<Resource>)page3.getItems());
		assertContains(resource2, (List<Resource>)page3.getItems());
		assertContains(resource3, (List<Resource>)page3.getItems());
	}

	@Test
	public void testGetResourcePagesWithSortDateTime() throws Exception {
		testGetResourcePagesWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, resource1, resource2) -> {
				BeanUtils.setProperty(
					resource1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetResourcePagesWithSortInteger() throws Exception {
		testGetResourcePagesWithSort(
			EntityField.Type.INTEGER,
			(entityField, resource1, resource2) -> {
				BeanUtils.setProperty(resource1, entityField.getName(), 0);
				BeanUtils.setProperty(resource2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetResourcePagesWithSortString() throws Exception {
		testGetResourcePagesWithSort(
			EntityField.Type.STRING,
			(entityField, resource1, resource2) -> {
				Class<?> clazz = resource1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						resource1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						resource2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						resource1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						resource2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						resource1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						resource2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetResourcePagesWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Resource, Resource, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Resource resource1 = randomResource();
		Resource resource2 = randomResource();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, resource1, resource2);
		}

		resource1 = testGetResourcePages_addResource(resource1);

		resource2 = testGetResourcePages_addResource(resource2);

		for (EntityField entityField : entityFields) {
			Page<Resource> ascPage = resourceResource.getResourcePages(
				null, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(resource1, resource2),
				(List<Resource>)ascPage.getItems());

			Page<Resource> descPage = resourceResource.getResourcePages(
				null, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(resource2, resource1),
				(List<Resource>)descPage.getItems());
		}
	}

	protected Resource testGetResourcePages_addResource(Resource resource)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostResource() throws Exception {
		Resource randomResource = randomResource();

		Resource postResource = testPostResource_addResource(randomResource);

		assertEquals(randomResource, postResource);
		assertValid(postResource);
	}

	protected Resource testPostResource_addResource(Resource resource)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteResource() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Resource resource = testDeleteResource_addResource();

		assertHttpResponseStatusCode(
			204, resourceResource.deleteResourceHttpResponse(resource.getId()));

		assertHttpResponseStatusCode(
			404, resourceResource.getResourceHttpResponse(resource.getId()));

		assertHttpResponseStatusCode(
			404, resourceResource.getResourceHttpResponse(resource.getId()));
	}

	protected Resource testDeleteResource_addResource() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteResource() throws Exception {
		Resource resource = testGraphQLResource_addResource();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteResource",
						new HashMap<String, Object>() {
							{
								put("id", resource.getId());
							}
						})),
				"JSONObject/data", "Object/deleteResource"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"resource",
					new HashMap<String, Object>() {
						{
							put("id", resource.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetResource() throws Exception {
		Resource postResource = testGetResource_addResource();

		Resource getResource = resourceResource.getResource(
			postResource.getId());

		assertEquals(postResource, getResource);
		assertValid(getResource);
	}

	protected Resource testGetResource_addResource() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetResource() throws Exception {
		Resource resource = testGraphQLResource_addResource();

		Assert.assertTrue(
			equals(
				resource,
				ResourceSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"resource",
								new HashMap<String, Object>() {
									{
										put("id", resource.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/resource"))));
	}

	@Test
	public void testGraphQLGetResourceNotFound() throws Exception {
		Long irrelevantId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"resource",
						new HashMap<String, Object>() {
							{
								put("id", irrelevantId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutResource() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Resource resource = testPutResource_addResource();

		assertHttpResponseStatusCode(
			204,
			resourceResource.putResourceHttpResponse(
				resource.getId(), resource));

		assertHttpResponseStatusCode(
			404,
			resourceResource.putResourceHttpResponse(
				resource.getId(), resource));
	}

	protected Resource testPutResource_addResource() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Resource testGraphQLResource_addResource() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Resource resource, List<Resource> resources) {
		boolean contains = false;

		for (Resource item : resources) {
			if (equals(resource, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			resources + " does not contain " + resource, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Resource resource1, Resource resource2) {
		Assert.assertTrue(
			resource1 + " does not equal " + resource2,
			equals(resource1, resource2));
	}

	protected void assertEquals(
		List<Resource> resources1, List<Resource> resources2) {

		Assert.assertEquals(resources1.size(), resources2.size());

		for (int i = 0; i < resources1.size(); i++) {
			Resource resource1 = resources1.get(i);
			Resource resource2 = resources2.get(i);

			assertEquals(resource1, resource2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Resource> resources1, List<Resource> resources2) {

		Assert.assertEquals(resources1.size(), resources2.size());

		for (Resource resource1 : resources1) {
			boolean contains = false;

			for (Resource resource2 : resources2) {
				if (equals(resource1, resource2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				resources2 + " does not contain " + resource1, contains);
		}
	}

	protected void assertValid(Resource resource) throws Exception {
		boolean valid = true;

		if (resource.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (resource.getCreator() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("creatorId", additionalAssertFieldName)) {
				if (resource.getCreatorId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dateResource", additionalAssertFieldName)) {
				if (resource.getDateResource() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (resource.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentName", additionalAssertFieldName)) {
				if (resource.getParentName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phaseId", additionalAssertFieldName)) {
				if (resource.getPhaseId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (resource.getProjectId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("quantity", additionalAssertFieldName)) {
				if (resource.getQuantity() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("resourceTypeName", additionalAssertFieldName)) {
				if (resource.getResourceTypeName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("teamId", additionalAssertFieldName)) {
				if (resource.getTeamId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("teamName", additionalAssertFieldName)) {
				if (resource.getTeamName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("totalAmount", additionalAssertFieldName)) {
				if (resource.getTotalAmount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (resource.getUnit() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("workId", additionalAssertFieldName)) {
				if (resource.getWorkId() == null) {
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

	protected void assertValid(Page<Resource> page) {
		boolean valid = false;

		java.util.Collection<Resource> resources = page.getItems();

		int size = resources.size();

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
					com.swork.core.resource.rest.dto.v1_0.Resource.class)) {

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

	protected boolean equals(Resource resource1, Resource resource2) {
		if (resource1 == resource2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getCreator(), resource2.getCreator())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("creatorId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getCreatorId(), resource2.getCreatorId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateResource", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getDateResource(),
						resource2.getDateResource())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						resource1.getExternalReferenceCode(),
						resource2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(resource1.getId(), resource2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("parentName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getParentName(), resource2.getParentName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phaseId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getPhaseId(), resource2.getPhaseId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getProjectId(), resource2.getProjectId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("quantity", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getQuantity(), resource2.getQuantity())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("resourceTypeName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getResourceTypeName(),
						resource2.getResourceTypeName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("teamId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getTeamId(), resource2.getTeamId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("teamName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getTeamName(), resource2.getTeamName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("totalAmount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getTotalAmount(),
						resource2.getTotalAmount())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getUnit(), resource2.getUnit())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("workId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resource1.getWorkId(), resource2.getWorkId())) {

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

		if (!(_resourceResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_resourceResource;

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
		EntityField entityField, String operator, Resource resource) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("creator")) {
			sb.append("'");
			sb.append(String.valueOf(resource.getCreator()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("creatorId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("dateResource")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(resource.getDateResource(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(resource.getDateResource(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(resource.getDateResource()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(resource.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("parentName")) {
			sb.append("'");
			sb.append(String.valueOf(resource.getParentName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("phaseId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("projectId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("quantity")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("resourceTypeName")) {
			sb.append("'");
			sb.append(String.valueOf(resource.getResourceTypeName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("teamId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("teamName")) {
			sb.append("'");
			sb.append(String.valueOf(resource.getTeamName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("totalAmount")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("unit")) {
			sb.append("'");
			sb.append(String.valueOf(resource.getUnit()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("workId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
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

	protected Resource randomResource() throws Exception {
		return new Resource() {
			{
				creator = StringUtil.toLowerCase(RandomTestUtil.randomString());
				creatorId = RandomTestUtil.randomLong();
				dateResource = RandomTestUtil.nextDate();
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				parentName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				phaseId = RandomTestUtil.randomLong();
				projectId = RandomTestUtil.randomLong();
				quantity = RandomTestUtil.randomDouble();
				resourceTypeName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				teamId = RandomTestUtil.randomLong();
				teamName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				totalAmount = RandomTestUtil.randomLong();
				unit = StringUtil.toLowerCase(RandomTestUtil.randomString());
				workId = RandomTestUtil.randomLong();
			}
		};
	}

	protected Resource randomIrrelevantResource() throws Exception {
		Resource randomIrrelevantResource = randomResource();

		return randomIrrelevantResource;
	}

	protected Resource randomPatchResource() throws Exception {
		return randomResource();
	}

	protected ResourceResource resourceResource;
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
		LogFactoryUtil.getLog(BaseResourceResourceTestCase.class);

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
	private com.swork.core.resource.rest.resource.v1_0.ResourceResource
		_resourceResource;

}