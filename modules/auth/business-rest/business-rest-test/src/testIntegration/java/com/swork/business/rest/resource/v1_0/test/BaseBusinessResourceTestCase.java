package com.swork.business.rest.resource.v1_0.test;

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

import com.swork.business.rest.client.dto.v1_0.Business;
import com.swork.business.rest.client.http.HttpInvoker;
import com.swork.business.rest.client.pagination.Page;
import com.swork.business.rest.client.pagination.Pagination;
import com.swork.business.rest.client.resource.v1_0.BusinessResource;
import com.swork.business.rest.client.serdes.v1_0.BusinessSerDes;

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
public abstract class BaseBusinessResourceTestCase {

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

		_businessResource.setContextCompany(testCompany);

		BusinessResource.Builder builder = BusinessResource.builder();

		businessResource = builder.authentication(
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

		Business business1 = randomBusiness();

		String json = objectMapper.writeValueAsString(business1);

		Business business2 = BusinessSerDes.toDTO(json);

		Assert.assertTrue(equals(business1, business2));
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

		Business business = randomBusiness();

		String json1 = objectMapper.writeValueAsString(business);
		String json2 = BusinessSerDes.toJSON(business);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Business business = randomBusiness();

		business.setBusinessAddress(regex);
		business.setCustomerName(regex);
		business.setEmail(regex);
		business.setExternalReferenceCode(regex);
		business.setFieldOperations(regex);
		business.setLogoId(regex);
		business.setName(regex);
		business.setPhoneNumber(regex);

		String json = BusinessSerDes.toJSON(business);

		Assert.assertFalse(json.contains(regex));

		business = BusinessSerDes.toDTO(json);

		Assert.assertEquals(regex, business.getBusinessAddress());
		Assert.assertEquals(regex, business.getCustomerName());
		Assert.assertEquals(regex, business.getEmail());
		Assert.assertEquals(regex, business.getExternalReferenceCode());
		Assert.assertEquals(regex, business.getFieldOperations());
		Assert.assertEquals(regex, business.getLogoId());
		Assert.assertEquals(regex, business.getName());
		Assert.assertEquals(regex, business.getPhoneNumber());
	}

	@Test
	public void testGetbusinessPage() throws Exception {
		Page<Business> page = businessResource.getbusinessPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Business business1 = testGetbusinessPage_addBusiness(randomBusiness());

		Business business2 = testGetbusinessPage_addBusiness(randomBusiness());

		page = businessResource.getbusinessPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(business1, (List<Business>)page.getItems());
		assertContains(business2, (List<Business>)page.getItems());
		assertValid(page);

		businessResource.deleteBusiness(business1.getId());

		businessResource.deleteBusiness(business2.getId());
	}

	@Test
	public void testGetbusinessPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Business business1 = randomBusiness();

		business1 = testGetbusinessPage_addBusiness(business1);

		for (EntityField entityField : entityFields) {
			Page<Business> page = businessResource.getbusinessPage(
				null, getFilterString(entityField, "between", business1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(business1),
				(List<Business>)page.getItems());
		}
	}

	@Test
	public void testGetbusinessPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Business business1 = testGetbusinessPage_addBusiness(randomBusiness());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Business business2 = testGetbusinessPage_addBusiness(randomBusiness());

		for (EntityField entityField : entityFields) {
			Page<Business> page = businessResource.getbusinessPage(
				null, getFilterString(entityField, "eq", business1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(business1),
				(List<Business>)page.getItems());
		}
	}

	@Test
	public void testGetbusinessPageWithPagination() throws Exception {
		Page<Business> totalPage = businessResource.getbusinessPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Business business1 = testGetbusinessPage_addBusiness(randomBusiness());

		Business business2 = testGetbusinessPage_addBusiness(randomBusiness());

		Business business3 = testGetbusinessPage_addBusiness(randomBusiness());

		Page<Business> page1 = businessResource.getbusinessPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Business> businesses1 = (List<Business>)page1.getItems();

		Assert.assertEquals(
			businesses1.toString(), totalCount + 2, businesses1.size());

		Page<Business> page2 = businessResource.getbusinessPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Business> businesses2 = (List<Business>)page2.getItems();

		Assert.assertEquals(businesses2.toString(), 1, businesses2.size());

		Page<Business> page3 = businessResource.getbusinessPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(business1, (List<Business>)page3.getItems());
		assertContains(business2, (List<Business>)page3.getItems());
		assertContains(business3, (List<Business>)page3.getItems());
	}

	@Test
	public void testGetbusinessPageWithSortDateTime() throws Exception {
		testGetbusinessPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, business1, business2) -> {
				BeanUtils.setProperty(
					business1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetbusinessPageWithSortInteger() throws Exception {
		testGetbusinessPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, business1, business2) -> {
				BeanUtils.setProperty(business1, entityField.getName(), 0);
				BeanUtils.setProperty(business2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetbusinessPageWithSortString() throws Exception {
		testGetbusinessPageWithSort(
			EntityField.Type.STRING,
			(entityField, business1, business2) -> {
				Class<?> clazz = business1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						business1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						business2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						business1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						business2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						business1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						business2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetbusinessPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Business, Business, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Business business1 = randomBusiness();
		Business business2 = randomBusiness();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, business1, business2);
		}

		business1 = testGetbusinessPage_addBusiness(business1);

		business2 = testGetbusinessPage_addBusiness(business2);

		for (EntityField entityField : entityFields) {
			Page<Business> ascPage = businessResource.getbusinessPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(business1, business2),
				(List<Business>)ascPage.getItems());

			Page<Business> descPage = businessResource.getbusinessPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(business2, business1),
				(List<Business>)descPage.getItems());
		}
	}

	protected Business testGetbusinessPage_addBusiness(Business business)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostBusiness() throws Exception {
		Business randomBusiness = randomBusiness();

		Business postBusiness = testPostBusiness_addBusiness(randomBusiness);

		assertEquals(randomBusiness, postBusiness);
		assertValid(postBusiness);
	}

	protected Business testPostBusiness_addBusiness(Business business)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteBusiness() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Business business = testDeleteBusiness_addBusiness();

		assertHttpResponseStatusCode(
			204, businessResource.deleteBusinessHttpResponse(business.getId()));

		assertHttpResponseStatusCode(
			404, businessResource.getBusinessHttpResponse(business.getId()));

		assertHttpResponseStatusCode(
			404, businessResource.getBusinessHttpResponse(0L));
	}

	protected Business testDeleteBusiness_addBusiness() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteBusiness() throws Exception {
		Business business = testGraphQLBusiness_addBusiness();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteBusiness",
						new HashMap<String, Object>() {
							{
								put("businessId", business.getId());
							}
						})),
				"JSONObject/data", "Object/deleteBusiness"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"business",
					new HashMap<String, Object>() {
						{
							put("businessId", business.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetBusiness() throws Exception {
		Business postBusiness = testGetBusiness_addBusiness();

		Business getBusiness = businessResource.getBusiness(
			postBusiness.getId());

		assertEquals(postBusiness, getBusiness);
		assertValid(getBusiness);
	}

	protected Business testGetBusiness_addBusiness() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetBusiness() throws Exception {
		Business business = testGraphQLBusiness_addBusiness();

		Assert.assertTrue(
			equals(
				business,
				BusinessSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"business",
								new HashMap<String, Object>() {
									{
										put("businessId", business.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/business"))));
	}

	@Test
	public void testGraphQLGetBusinessNotFound() throws Exception {
		Long irrelevantBusinessId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"business",
						new HashMap<String, Object>() {
							{
								put("businessId", irrelevantBusinessId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutBusiness() throws Exception {
		Business postBusiness = testPutBusiness_addBusiness();

		Business randomBusiness = randomBusiness();

		Business putBusiness = businessResource.putBusiness(
			postBusiness.getId(), randomBusiness);

		assertEquals(randomBusiness, putBusiness);
		assertValid(putBusiness);

		Business getBusiness = businessResource.getBusiness(
			putBusiness.getId());

		assertEquals(randomBusiness, getBusiness);
		assertValid(getBusiness);
	}

	protected Business testPutBusiness_addBusiness() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testApprovalBusiness() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Business business = testApprovalBusiness_addBusiness();

		assertHttpResponseStatusCode(
			204,
			businessResource.approvalBusinessHttpResponse(
				business.getId(), null));

		assertHttpResponseStatusCode(
			404, businessResource.approvalBusinessHttpResponse(0L, null));
	}

	protected Business testApprovalBusiness_addBusiness() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Business testGraphQLBusiness_addBusiness() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		Business business, List<Business> businesses) {

		boolean contains = false;

		for (Business item : businesses) {
			if (equals(business, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			businesses + " does not contain " + business, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Business business1, Business business2) {
		Assert.assertTrue(
			business1 + " does not equal " + business2,
			equals(business1, business2));
	}

	protected void assertEquals(
		List<Business> businesses1, List<Business> businesses2) {

		Assert.assertEquals(businesses1.size(), businesses2.size());

		for (int i = 0; i < businesses1.size(); i++) {
			Business business1 = businesses1.get(i);
			Business business2 = businesses2.get(i);

			assertEquals(business1, business2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Business> businesses1, List<Business> businesses2) {

		Assert.assertEquals(businesses1.size(), businesses2.size());

		for (Business business1 : businesses1) {
			boolean contains = false;

			for (Business business2 : businesses2) {
				if (equals(business1, business2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				businesses2 + " does not contain " + business1, contains);
		}
	}

	protected void assertValid(Business business) throws Exception {
		boolean valid = true;

		if (business.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("businessAddress", additionalAssertFieldName)) {
				if (business.getBusinessAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("customerName", additionalAssertFieldName)) {
				if (business.getCustomerName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (business.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (business.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fieldOperations", additionalAssertFieldName)) {
				if (business.getFieldOperations() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("logoId", additionalAssertFieldName)) {
				if (business.getLogoId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (business.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phoneNumber", additionalAssertFieldName)) {
				if (business.getPhoneNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (business.getStatus() == null) {
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

	protected void assertValid(Page<Business> page) {
		boolean valid = false;

		java.util.Collection<Business> businesses = page.getItems();

		int size = businesses.size();

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
					com.swork.business.rest.dto.v1_0.Business.class)) {

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

	protected boolean equals(Business business1, Business business2) {
		if (business1 == business2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("businessAddress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						business1.getBusinessAddress(),
						business2.getBusinessAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("customerName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						business1.getCustomerName(),
						business2.getCustomerName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						business1.getEmail(), business2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						business1.getExternalReferenceCode(),
						business2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fieldOperations", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						business1.getFieldOperations(),
						business2.getFieldOperations())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(business1.getId(), business2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("logoId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						business1.getLogoId(), business2.getLogoId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						business1.getName(), business2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phoneNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						business1.getPhoneNumber(),
						business2.getPhoneNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						business1.getStatus(), business2.getStatus())) {

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

		if (!(_businessResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_businessResource;

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
		EntityField entityField, String operator, Business business) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("businessAddress")) {
			sb.append("'");
			sb.append(String.valueOf(business.getBusinessAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("customerName")) {
			sb.append("'");
			sb.append(String.valueOf(business.getCustomerName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(business.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(business.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fieldOperations")) {
			sb.append("'");
			sb.append(String.valueOf(business.getFieldOperations()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("logoId")) {
			sb.append("'");
			sb.append(String.valueOf(business.getLogoId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(business.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("phoneNumber")) {
			sb.append("'");
			sb.append(String.valueOf(business.getPhoneNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
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

	protected Business randomBusiness() throws Exception {
		return new Business() {
			{
				businessAddress = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				customerName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fieldOperations = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				logoId = StringUtil.toLowerCase(RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				phoneNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected Business randomIrrelevantBusiness() throws Exception {
		Business randomIrrelevantBusiness = randomBusiness();

		return randomIrrelevantBusiness;
	}

	protected Business randomPatchBusiness() throws Exception {
		return randomBusiness();
	}

	protected BusinessResource businessResource;
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
		LogFactoryUtil.getLog(BaseBusinessResourceTestCase.class);

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
	private com.swork.business.rest.resource.v1_0.BusinessResource
		_businessResource;

}