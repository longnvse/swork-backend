package com.swork.core.work.rest.resource.v1_0.test;

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

import com.swork.core.work.rest.client.dto.v1_0.Work;
import com.swork.core.work.rest.client.http.HttpInvoker;
import com.swork.core.work.rest.client.pagination.Page;
import com.swork.core.work.rest.client.pagination.Pagination;
import com.swork.core.work.rest.client.resource.v1_0.WorkResource;
import com.swork.core.work.rest.client.serdes.v1_0.WorkSerDes;

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
 * @author longnv
 * @generated
 */
@Generated("")
public abstract class BaseWorkResourceTestCase {

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

		_workResource.setContextCompany(testCompany);

		WorkResource.Builder builder = WorkResource.builder();

		workResource = builder.authentication(
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

		Work work1 = randomWork();

		String json = objectMapper.writeValueAsString(work1);

		Work work2 = WorkSerDes.toDTO(json);

		Assert.assertTrue(equals(work1, work2));
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

		Work work = randomWork();

		String json1 = objectMapper.writeValueAsString(work);
		String json2 = WorkSerDes.toJSON(work);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Work work = randomWork();

		work.setDescription(regex);
		work.setDescriptionProgress(regex);
		work.setExternalReferenceCode(regex);
		work.setName(regex);
		work.setParentName(regex);
		work.setPhaseName(regex);
		work.setProjectName(regex);
		work.setUnit(regex);

		String json = WorkSerDes.toJSON(work);

		Assert.assertFalse(json.contains(regex));

		work = WorkSerDes.toDTO(json);

		Assert.assertEquals(regex, work.getDescription());
		Assert.assertEquals(regex, work.getDescriptionProgress());
		Assert.assertEquals(regex, work.getExternalReferenceCode());
		Assert.assertEquals(regex, work.getName());
		Assert.assertEquals(regex, work.getParentName());
		Assert.assertEquals(regex, work.getPhaseName());
		Assert.assertEquals(regex, work.getProjectName());
		Assert.assertEquals(regex, work.getUnit());
	}

	@Test
	public void testGetWorksPage() throws Exception {
		Page<Work> page = workResource.getWorksPage(
			null, null, null, null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Work work1 = testGetWorksPage_addWork(randomWork());

		Work work2 = testGetWorksPage_addWork(randomWork());

		page = workResource.getWorksPage(
			null, null, null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(work1, (List<Work>)page.getItems());
		assertContains(work2, (List<Work>)page.getItems());
		assertValid(page);

		workResource.deleteWork(work1.getId());

		workResource.deleteWork(work2.getId());
	}

	@Test
	public void testGetWorksPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Work work1 = randomWork();

		work1 = testGetWorksPage_addWork(work1);

		for (EntityField entityField : entityFields) {
			Page<Work> page = workResource.getWorksPage(
				null, null, null, null,
				getFilterString(entityField, "between", work1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(work1), (List<Work>)page.getItems());
		}
	}

	@Test
	public void testGetWorksPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Work work1 = testGetWorksPage_addWork(randomWork());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Work work2 = testGetWorksPage_addWork(randomWork());

		for (EntityField entityField : entityFields) {
			Page<Work> page = workResource.getWorksPage(
				null, null, null, null,
				getFilterString(entityField, "eq", work1), Pagination.of(1, 2),
				null);

			assertEquals(
				Collections.singletonList(work1), (List<Work>)page.getItems());
		}
	}

	@Test
	public void testGetWorksPageWithPagination() throws Exception {
		Page<Work> totalPage = workResource.getWorksPage(
			null, null, null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Work work1 = testGetWorksPage_addWork(randomWork());

		Work work2 = testGetWorksPage_addWork(randomWork());

		Work work3 = testGetWorksPage_addWork(randomWork());

		Page<Work> page1 = workResource.getWorksPage(
			null, null, null, null, null, Pagination.of(1, totalCount + 2),
			null);

		List<Work> works1 = (List<Work>)page1.getItems();

		Assert.assertEquals(works1.toString(), totalCount + 2, works1.size());

		Page<Work> page2 = workResource.getWorksPage(
			null, null, null, null, null, Pagination.of(2, totalCount + 2),
			null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Work> works2 = (List<Work>)page2.getItems();

		Assert.assertEquals(works2.toString(), 1, works2.size());

		Page<Work> page3 = workResource.getWorksPage(
			null, null, null, null, null, Pagination.of(1, totalCount + 3),
			null);

		assertContains(work1, (List<Work>)page3.getItems());
		assertContains(work2, (List<Work>)page3.getItems());
		assertContains(work3, (List<Work>)page3.getItems());
	}

	@Test
	public void testGetWorksPageWithSortDateTime() throws Exception {
		testGetWorksPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, work1, work2) -> {
				BeanUtils.setProperty(
					work1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetWorksPageWithSortInteger() throws Exception {
		testGetWorksPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, work1, work2) -> {
				BeanUtils.setProperty(work1, entityField.getName(), 0);
				BeanUtils.setProperty(work2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetWorksPageWithSortString() throws Exception {
		testGetWorksPageWithSort(
			EntityField.Type.STRING,
			(entityField, work1, work2) -> {
				Class<?> clazz = work1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						work1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						work2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						work1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						work2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						work1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						work2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetWorksPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Work, Work, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Work work1 = randomWork();
		Work work2 = randomWork();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, work1, work2);
		}

		work1 = testGetWorksPage_addWork(work1);

		work2 = testGetWorksPage_addWork(work2);

		for (EntityField entityField : entityFields) {
			Page<Work> ascPage = workResource.getWorksPage(
				null, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(work1, work2), (List<Work>)ascPage.getItems());

			Page<Work> descPage = workResource.getWorksPage(
				null, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(work2, work1), (List<Work>)descPage.getItems());
		}
	}

	protected Work testGetWorksPage_addWork(Work work) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetWorksPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"works",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject worksJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/works");

		long totalCount = worksJSONObject.getLong("totalCount");

		Work work1 = testGraphQLWork_addWork();
		Work work2 = testGraphQLWork_addWork();

		worksJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/works");

		Assert.assertEquals(
			totalCount + 2, worksJSONObject.getLong("totalCount"));

		assertContains(
			work1,
			Arrays.asList(
				WorkSerDes.toDTOs(worksJSONObject.getString("items"))));
		assertContains(
			work2,
			Arrays.asList(
				WorkSerDes.toDTOs(worksJSONObject.getString("items"))));
	}

	@Test
	public void testPostWork() throws Exception {
		Work randomWork = randomWork();

		Work postWork = testPostWork_addWork(randomWork);

		assertEquals(randomWork, postWork);
		assertValid(postWork);
	}

	protected Work testPostWork_addWork(Work work) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteWork() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Work work = testDeleteWork_addWork();

		assertHttpResponseStatusCode(
			204, workResource.deleteWorkHttpResponse(work.getId()));

		assertHttpResponseStatusCode(
			404, workResource.getWorkHttpResponse(work.getId()));

		assertHttpResponseStatusCode(404, workResource.getWorkHttpResponse(0L));
	}

	protected Work testDeleteWork_addWork() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteWork() throws Exception {
		Work work = testGraphQLWork_addWork();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteWork",
						new HashMap<String, Object>() {
							{
								put("workId", work.getId());
							}
						})),
				"JSONObject/data", "Object/deleteWork"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"work",
					new HashMap<String, Object>() {
						{
							put("workId", work.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetWork() throws Exception {
		Work postWork = testGetWork_addWork();

		Work getWork = workResource.getWork(postWork.getId());

		assertEquals(postWork, getWork);
		assertValid(getWork);
	}

	protected Work testGetWork_addWork() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetWork() throws Exception {
		Work work = testGraphQLWork_addWork();

		Assert.assertTrue(
			equals(
				work,
				WorkSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"work",
								new HashMap<String, Object>() {
									{
										put("workId", work.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/work"))));
	}

	@Test
	public void testGraphQLGetWorkNotFound() throws Exception {
		Long irrelevantWorkId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"work",
						new HashMap<String, Object>() {
							{
								put("workId", irrelevantWorkId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutWork() throws Exception {
		Work postWork = testPutWork_addWork();

		Work randomWork = randomWork();

		Work putWork = workResource.putWork(postWork.getId(), randomWork);

		assertEquals(randomWork, putWork);
		assertValid(putWork);

		Work getWork = workResource.getWork(putWork.getId());

		assertEquals(randomWork, getWork);
		assertValid(getWork);
	}

	protected Work testPutWork_addWork() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutReportAmount() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Work work = testPutReportAmount_addWork();

		assertHttpResponseStatusCode(
			204, workResource.putReportAmountHttpResponse(work.getId(), null));

		assertHttpResponseStatusCode(
			404, workResource.putReportAmountHttpResponse(0L, null));
	}

	protected Work testPutReportAmount_addWork() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateStatus() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Work work = testUpdateStatus_addWork();

		assertHttpResponseStatusCode(
			204, workResource.updateStatusHttpResponse(work.getId(), null));

		assertHttpResponseStatusCode(
			404, workResource.updateStatusHttpResponse(0L, null));
	}

	protected Work testUpdateStatus_addWork() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Work testGraphQLWork_addWork() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Work work, List<Work> works) {
		boolean contains = false;

		for (Work item : works) {
			if (equals(work, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(works + " does not contain " + work, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Work work1, Work work2) {
		Assert.assertTrue(
			work1 + " does not equal " + work2, equals(work1, work2));
	}

	protected void assertEquals(List<Work> works1, List<Work> works2) {
		Assert.assertEquals(works1.size(), works2.size());

		for (int i = 0; i < works1.size(); i++) {
			Work work1 = works1.get(i);
			Work work2 = works2.get(i);

			assertEquals(work1, work2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Work> works1, List<Work> works2) {

		Assert.assertEquals(works1.size(), works2.size());

		for (Work work1 : works1) {
			boolean contains = false;

			for (Work work2 : works2) {
				if (equals(work1, work2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(works2 + " does not contain " + work1, contains);
		}
	}

	protected void assertValid(Work work) throws Exception {
		boolean valid = true;

		if (work.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actualEndDate", additionalAssertFieldName)) {
				if (work.getActualEndDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("actualStartDate", additionalAssertFieldName)) {
				if (work.getActualStartDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("complete", additionalAssertFieldName)) {
				if (work.getComplete() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (work.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"descriptionProgress", additionalAssertFieldName)) {

				if (work.getDescriptionProgress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("endDate", additionalAssertFieldName)) {
				if (work.getEndDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (work.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("handles", additionalAssertFieldName)) {
				if (work.getHandles() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("incompleteAmount", additionalAssertFieldName)) {
				if (work.getIncompleteAmount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("manages", additionalAssertFieldName)) {
				if (work.getManages() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (work.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (work.getParentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentName", additionalAssertFieldName)) {
				if (work.getParentName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentStatus", additionalAssertFieldName)) {
				if (work.getParentStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("participates", additionalAssertFieldName)) {
				if (work.getParticipates() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("percentage", additionalAssertFieldName)) {
				if (work.getPercentage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phaseId", additionalAssertFieldName)) {
				if (work.getPhaseId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phaseName", additionalAssertFieldName)) {
				if (work.getPhaseName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("progress", additionalAssertFieldName)) {
				if (work.getProgress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("progressType", additionalAssertFieldName)) {
				if (work.getProgressType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (work.getProjectId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectName", additionalAssertFieldName)) {
				if (work.getProjectName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (work.getStartDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (work.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (work.getUnit() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("works", additionalAssertFieldName)) {
				if (work.getWorks() == null) {
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

	protected void assertValid(Page<Work> page) {
		boolean valid = false;

		java.util.Collection<Work> works = page.getItems();

		int size = works.size();

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
					com.swork.core.work.rest.dto.v1_0.Work.class)) {

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

	protected boolean equals(Work work1, Work work2) {
		if (work1 == work2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actualEndDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getActualEndDate(), work2.getActualEndDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("actualStartDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getActualStartDate(),
						work2.getActualStartDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("complete", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getComplete(), work2.getComplete())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getDescription(), work2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"descriptionProgress", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						work1.getDescriptionProgress(),
						work2.getDescriptionProgress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("endDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getEndDate(), work2.getEndDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						work1.getExternalReferenceCode(),
						work2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("handles", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getHandles(), work2.getHandles())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(work1.getId(), work2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("incompleteAmount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getIncompleteAmount(),
						work2.getIncompleteAmount())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("manages", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getManages(), work2.getManages())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(work1.getName(), work2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getParentId(), work2.getParentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("parentName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getParentName(), work2.getParentName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("parentStatus", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getParentStatus(), work2.getParentStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("participates", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getParticipates(), work2.getParticipates())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("percentage", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getPercentage(), work2.getPercentage())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phaseId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getPhaseId(), work2.getPhaseId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phaseName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getPhaseName(), work2.getPhaseName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("progress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getProgress(), work2.getProgress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("progressType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getProgressType(), work2.getProgressType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getProjectId(), work2.getProjectId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getProjectName(), work2.getProjectName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						work1.getStartDate(), work2.getStartDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(work1.getStatus(), work2.getStatus())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (!Objects.deepEquals(work1.getUnit(), work2.getUnit())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("works", additionalAssertFieldName)) {
				if (!Objects.deepEquals(work1.getWorks(), work2.getWorks())) {
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

		if (!(_workResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_workResource;

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
		EntityField entityField, String operator, Work work) {

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
						DateUtils.addSeconds(work.getActualEndDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(work.getActualEndDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(work.getActualEndDate()));
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
						DateUtils.addSeconds(work.getActualStartDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(work.getActualStartDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(work.getActualStartDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("complete")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(work.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("descriptionProgress")) {
			sb.append("'");
			sb.append(String.valueOf(work.getDescriptionProgress()));
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
						DateUtils.addSeconds(work.getEndDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(work.getEndDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(work.getEndDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(work.getExternalReferenceCode()));
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

		if (entityFieldName.equals("incompleteAmount")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("manages")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(work.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("parentId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("parentName")) {
			sb.append("'");
			sb.append(String.valueOf(work.getParentName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("parentStatus")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("participates")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("percentage")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("phaseId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("phaseName")) {
			sb.append("'");
			sb.append(String.valueOf(work.getPhaseName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("progress")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("progressType")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("projectId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("projectName")) {
			sb.append("'");
			sb.append(String.valueOf(work.getProjectName()));
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
						DateUtils.addSeconds(work.getStartDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(work.getStartDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(work.getStartDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("unit")) {
			sb.append("'");
			sb.append(String.valueOf(work.getUnit()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("works")) {
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

	protected Work randomWork() throws Exception {
		return new Work() {
			{
				actualEndDate = RandomTestUtil.nextDate();
				actualStartDate = RandomTestUtil.nextDate();
				complete = RandomTestUtil.randomDouble();
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				descriptionProgress = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				endDate = RandomTestUtil.nextDate();
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				incompleteAmount = RandomTestUtil.randomDouble();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				parentId = RandomTestUtil.randomLong();
				parentName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				percentage = RandomTestUtil.randomDouble();
				phaseId = RandomTestUtil.randomLong();
				phaseName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				progress = RandomTestUtil.randomLong();
				projectId = RandomTestUtil.randomLong();
				projectName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				startDate = RandomTestUtil.nextDate();
				unit = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Work randomIrrelevantWork() throws Exception {
		Work randomIrrelevantWork = randomWork();

		return randomIrrelevantWork;
	}

	protected Work randomPatchWork() throws Exception {
		return randomWork();
	}

	protected WorkResource workResource;
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
		LogFactoryUtil.getLog(BaseWorkResourceTestCase.class);

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
	private com.swork.core.work.rest.resource.v1_0.WorkResource _workResource;

}