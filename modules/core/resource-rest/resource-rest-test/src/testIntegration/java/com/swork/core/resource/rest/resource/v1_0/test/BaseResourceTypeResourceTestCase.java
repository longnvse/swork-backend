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

import com.swork.core.resource.rest.client.dto.v1_0.ResourceType;
import com.swork.core.resource.rest.client.http.HttpInvoker;
import com.swork.core.resource.rest.client.pagination.Page;
import com.swork.core.resource.rest.client.pagination.Pagination;
import com.swork.core.resource.rest.client.resource.v1_0.ResourceTypeResource;
import com.swork.core.resource.rest.client.serdes.v1_0.ResourceTypeSerDes;

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
public abstract class BaseResourceTypeResourceTestCase {

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

		_resourceTypeResource.setContextCompany(testCompany);

		ResourceTypeResource.Builder builder = ResourceTypeResource.builder();

		resourceTypeResource = builder.authentication(
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

		ResourceType resourceType1 = randomResourceType();

		String json = objectMapper.writeValueAsString(resourceType1);

		ResourceType resourceType2 = ResourceTypeSerDes.toDTO(json);

		Assert.assertTrue(equals(resourceType1, resourceType2));
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

		ResourceType resourceType = randomResourceType();

		String json1 = objectMapper.writeValueAsString(resourceType);
		String json2 = ResourceTypeSerDes.toJSON(resourceType);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		ResourceType resourceType = randomResourceType();

		resourceType.setCreator(regex);
		resourceType.setExternalReferenceCode(regex);
		resourceType.setName(regex);
		resourceType.setUnit(regex);

		String json = ResourceTypeSerDes.toJSON(resourceType);

		Assert.assertFalse(json.contains(regex));

		resourceType = ResourceTypeSerDes.toDTO(json);

		Assert.assertEquals(regex, resourceType.getCreator());
		Assert.assertEquals(regex, resourceType.getExternalReferenceCode());
		Assert.assertEquals(regex, resourceType.getName());
		Assert.assertEquals(regex, resourceType.getUnit());
	}

	@Test
	public void testGetResourceTypePages() throws Exception {
		Page<ResourceType> page = resourceTypeResource.getResourceTypePages(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		ResourceType resourceType1 = testGetResourceTypePages_addResourceType(
			randomResourceType());

		ResourceType resourceType2 = testGetResourceTypePages_addResourceType(
			randomResourceType());

		page = resourceTypeResource.getResourceTypePages(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(resourceType1, (List<ResourceType>)page.getItems());
		assertContains(resourceType2, (List<ResourceType>)page.getItems());
		assertValid(page);

		resourceTypeResource.deleteResourceType(resourceType1.getId());

		resourceTypeResource.deleteResourceType(resourceType2.getId());
	}

	@Test
	public void testGetResourceTypePagesWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		ResourceType resourceType1 = randomResourceType();

		resourceType1 = testGetResourceTypePages_addResourceType(resourceType1);

		for (EntityField entityField : entityFields) {
			Page<ResourceType> page = resourceTypeResource.getResourceTypePages(
				null, getFilterString(entityField, "between", resourceType1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(resourceType1),
				(List<ResourceType>)page.getItems());
		}
	}

	@Test
	public void testGetResourceTypePagesWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		ResourceType resourceType1 = testGetResourceTypePages_addResourceType(
			randomResourceType());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		ResourceType resourceType2 = testGetResourceTypePages_addResourceType(
			randomResourceType());

		for (EntityField entityField : entityFields) {
			Page<ResourceType> page = resourceTypeResource.getResourceTypePages(
				null, getFilterString(entityField, "eq", resourceType1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(resourceType1),
				(List<ResourceType>)page.getItems());
		}
	}

	@Test
	public void testGetResourceTypePagesWithPagination() throws Exception {
		Page<ResourceType> totalPage =
			resourceTypeResource.getResourceTypePages(null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		ResourceType resourceType1 = testGetResourceTypePages_addResourceType(
			randomResourceType());

		ResourceType resourceType2 = testGetResourceTypePages_addResourceType(
			randomResourceType());

		ResourceType resourceType3 = testGetResourceTypePages_addResourceType(
			randomResourceType());

		Page<ResourceType> page1 = resourceTypeResource.getResourceTypePages(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<ResourceType> resourceTypes1 =
			(List<ResourceType>)page1.getItems();

		Assert.assertEquals(
			resourceTypes1.toString(), totalCount + 2, resourceTypes1.size());

		Page<ResourceType> page2 = resourceTypeResource.getResourceTypePages(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<ResourceType> resourceTypes2 =
			(List<ResourceType>)page2.getItems();

		Assert.assertEquals(
			resourceTypes2.toString(), 1, resourceTypes2.size());

		Page<ResourceType> page3 = resourceTypeResource.getResourceTypePages(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(resourceType1, (List<ResourceType>)page3.getItems());
		assertContains(resourceType2, (List<ResourceType>)page3.getItems());
		assertContains(resourceType3, (List<ResourceType>)page3.getItems());
	}

	@Test
	public void testGetResourceTypePagesWithSortDateTime() throws Exception {
		testGetResourceTypePagesWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, resourceType1, resourceType2) -> {
				BeanUtils.setProperty(
					resourceType1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetResourceTypePagesWithSortInteger() throws Exception {
		testGetResourceTypePagesWithSort(
			EntityField.Type.INTEGER,
			(entityField, resourceType1, resourceType2) -> {
				BeanUtils.setProperty(resourceType1, entityField.getName(), 0);
				BeanUtils.setProperty(resourceType2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetResourceTypePagesWithSortString() throws Exception {
		testGetResourceTypePagesWithSort(
			EntityField.Type.STRING,
			(entityField, resourceType1, resourceType2) -> {
				Class<?> clazz = resourceType1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						resourceType1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						resourceType2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						resourceType1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						resourceType2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						resourceType1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						resourceType2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetResourceTypePagesWithSort(
			EntityField.Type type,
			UnsafeTriConsumer
				<EntityField, ResourceType, ResourceType, Exception>
					unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		ResourceType resourceType1 = randomResourceType();
		ResourceType resourceType2 = randomResourceType();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, resourceType1, resourceType2);
		}

		resourceType1 = testGetResourceTypePages_addResourceType(resourceType1);

		resourceType2 = testGetResourceTypePages_addResourceType(resourceType2);

		for (EntityField entityField : entityFields) {
			Page<ResourceType> ascPage =
				resourceTypeResource.getResourceTypePages(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(resourceType1, resourceType2),
				(List<ResourceType>)ascPage.getItems());

			Page<ResourceType> descPage =
				resourceTypeResource.getResourceTypePages(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(resourceType2, resourceType1),
				(List<ResourceType>)descPage.getItems());
		}
	}

	protected ResourceType testGetResourceTypePages_addResourceType(
			ResourceType resourceType)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostResourceType() throws Exception {
		ResourceType randomResourceType = randomResourceType();

		ResourceType postResourceType = testPostResourceType_addResourceType(
			randomResourceType);

		assertEquals(randomResourceType, postResourceType);
		assertValid(postResourceType);
	}

	protected ResourceType testPostResourceType_addResourceType(
			ResourceType resourceType)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteResourceType() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		ResourceType resourceType = testDeleteResourceType_addResourceType();

		assertHttpResponseStatusCode(
			204,
			resourceTypeResource.deleteResourceTypeHttpResponse(
				resourceType.getId()));

		assertHttpResponseStatusCode(
			404,
			resourceTypeResource.getResourceTypeHttpResponse(
				resourceType.getId()));

		assertHttpResponseStatusCode(
			404,
			resourceTypeResource.getResourceTypeHttpResponse(
				resourceType.getId()));
	}

	protected ResourceType testDeleteResourceType_addResourceType()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteResourceType() throws Exception {
		ResourceType resourceType = testGraphQLResourceType_addResourceType();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteResourceType",
						new HashMap<String, Object>() {
							{
								put("id", resourceType.getId());
							}
						})),
				"JSONObject/data", "Object/deleteResourceType"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"resourceType",
					new HashMap<String, Object>() {
						{
							put("id", resourceType.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetResourceType() throws Exception {
		ResourceType postResourceType = testGetResourceType_addResourceType();

		ResourceType getResourceType = resourceTypeResource.getResourceType(
			postResourceType.getId());

		assertEquals(postResourceType, getResourceType);
		assertValid(getResourceType);
	}

	protected ResourceType testGetResourceType_addResourceType()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetResourceType() throws Exception {
		ResourceType resourceType = testGraphQLResourceType_addResourceType();

		Assert.assertTrue(
			equals(
				resourceType,
				ResourceTypeSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"resourceType",
								new HashMap<String, Object>() {
									{
										put("id", resourceType.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/resourceType"))));
	}

	@Test
	public void testGraphQLGetResourceTypeNotFound() throws Exception {
		Long irrelevantId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"resourceType",
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
	public void testPutResourceType() throws Exception {
		ResourceType postResourceType = testPutResourceType_addResourceType();

		ResourceType randomResourceType = randomResourceType();

		ResourceType putResourceType = resourceTypeResource.putResourceType(
			postResourceType.getId(), randomResourceType);

		assertEquals(randomResourceType, putResourceType);
		assertValid(putResourceType);

		ResourceType getResourceType = resourceTypeResource.getResourceType(
			putResourceType.getId());

		assertEquals(randomResourceType, getResourceType);
		assertValid(getResourceType);
	}

	protected ResourceType testPutResourceType_addResourceType()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetResourceTypesFromResources() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetTotalMoneyInProject() throws Exception {
		Assert.assertTrue(false);
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected ResourceType testGraphQLResourceType_addResourceType()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		ResourceType resourceType, List<ResourceType> resourceTypes) {

		boolean contains = false;

		for (ResourceType item : resourceTypes) {
			if (equals(resourceType, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			resourceTypes + " does not contain " + resourceType, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		ResourceType resourceType1, ResourceType resourceType2) {

		Assert.assertTrue(
			resourceType1 + " does not equal " + resourceType2,
			equals(resourceType1, resourceType2));
	}

	protected void assertEquals(
		List<ResourceType> resourceTypes1, List<ResourceType> resourceTypes2) {

		Assert.assertEquals(resourceTypes1.size(), resourceTypes2.size());

		for (int i = 0; i < resourceTypes1.size(); i++) {
			ResourceType resourceType1 = resourceTypes1.get(i);
			ResourceType resourceType2 = resourceTypes2.get(i);

			assertEquals(resourceType1, resourceType2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<ResourceType> resourceTypes1, List<ResourceType> resourceTypes2) {

		Assert.assertEquals(resourceTypes1.size(), resourceTypes2.size());

		for (ResourceType resourceType1 : resourceTypes1) {
			boolean contains = false;

			for (ResourceType resourceType2 : resourceTypes2) {
				if (equals(resourceType1, resourceType2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				resourceTypes2 + " does not contain " + resourceType1,
				contains);
		}
	}

	protected void assertValid(ResourceType resourceType) throws Exception {
		boolean valid = true;

		if (resourceType.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (resourceType.getCreator() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (resourceType.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (resourceType.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (resourceType.getParentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("resourceTypes", additionalAssertFieldName)) {
				if (resourceType.getResourceTypes() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (resourceType.getUnit() == null) {
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

	protected void assertValid(Page<ResourceType> page) {
		boolean valid = false;

		java.util.Collection<ResourceType> resourceTypes = page.getItems();

		int size = resourceTypes.size();

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
					com.swork.core.resource.rest.dto.v1_0.ResourceType.class)) {

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

	protected boolean equals(
		ResourceType resourceType1, ResourceType resourceType2) {

		if (resourceType1 == resourceType2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resourceType1.getCreator(),
						resourceType2.getCreator())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						resourceType1.getExternalReferenceCode(),
						resourceType2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resourceType1.getId(), resourceType2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resourceType1.getName(), resourceType2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resourceType1.getParentId(),
						resourceType2.getParentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("resourceTypes", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resourceType1.getResourceTypes(),
						resourceType2.getResourceTypes())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						resourceType1.getUnit(), resourceType2.getUnit())) {

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

		if (!(_resourceTypeResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_resourceTypeResource;

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
		EntityField entityField, String operator, ResourceType resourceType) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("creator")) {
			sb.append("'");
			sb.append(String.valueOf(resourceType.getCreator()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(resourceType.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(resourceType.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("parentId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("resourceTypes")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("unit")) {
			sb.append("'");
			sb.append(String.valueOf(resourceType.getUnit()));
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

	protected ResourceType randomResourceType() throws Exception {
		return new ResourceType() {
			{
				creator = StringUtil.toLowerCase(RandomTestUtil.randomString());
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				parentId = RandomTestUtil.randomLong();
				unit = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected ResourceType randomIrrelevantResourceType() throws Exception {
		ResourceType randomIrrelevantResourceType = randomResourceType();

		return randomIrrelevantResourceType;
	}

	protected ResourceType randomPatchResourceType() throws Exception {
		return randomResourceType();
	}

	protected ResourceTypeResource resourceTypeResource;
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
		LogFactoryUtil.getLog(BaseResourceTypeResourceTestCase.class);

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
	private com.swork.core.resource.rest.resource.v1_0.ResourceTypeResource
		_resourceTypeResource;

}