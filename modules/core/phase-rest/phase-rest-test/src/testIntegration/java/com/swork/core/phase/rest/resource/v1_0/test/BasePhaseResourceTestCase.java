package com.swork.core.phase.rest.resource.v1_0.test;

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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import com.swork.core.phase.rest.client.dto.v1_0.Phase;
import com.swork.core.phase.rest.client.http.HttpInvoker;
import com.swork.core.phase.rest.client.pagination.Page;
import com.swork.core.phase.rest.client.pagination.Pagination;
import com.swork.core.phase.rest.client.resource.v1_0.PhaseResource;
import com.swork.core.phase.rest.client.serdes.v1_0.PhaseSerDes;

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
public abstract class BasePhaseResourceTestCase {

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

		_phaseResource.setContextCompany(testCompany);

		PhaseResource.Builder builder = PhaseResource.builder();

		phaseResource = builder.authentication(
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

		Phase phase1 = randomPhase();

		String json = objectMapper.writeValueAsString(phase1);

		Phase phase2 = PhaseSerDes.toDTO(json);

		Assert.assertTrue(equals(phase1, phase2));
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

		Phase phase = randomPhase();

		String json1 = objectMapper.writeValueAsString(phase);
		String json2 = PhaseSerDes.toJSON(phase);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Phase phase = randomPhase();

		phase.setDescription(regex);
		phase.setExternalReferenceCode(regex);
		phase.setName(regex);
		phase.setProjectName(regex);

		String json = PhaseSerDes.toJSON(phase);

		Assert.assertFalse(json.contains(regex));

		phase = PhaseSerDes.toDTO(json);

		Assert.assertEquals(regex, phase.getDescription());
		Assert.assertEquals(regex, phase.getExternalReferenceCode());
		Assert.assertEquals(regex, phase.getName());
		Assert.assertEquals(regex, phase.getProjectName());
	}

	@Test
	public void testPostPhase() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Phase phase = testPostPhase_addPhase();

		assertHttpResponseStatusCode(
			204, phaseResource.postPhaseHttpResponse(phase));

		assertHttpResponseStatusCode(
			404, phaseResource.postPhaseHttpResponse(phase));
	}

	protected Phase testPostPhase_addPhase() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetPhasesPage() throws Exception {
		Long projectId = testGetPhasesPage_getProjectId();
		Long irrelevantProjectId = testGetPhasesPage_getIrrelevantProjectId();

		Page<Phase> page = phaseResource.getPhasesPage(
			projectId, RandomTestUtil.nextDate(), RandomTestUtil.nextDate(),
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantProjectId != null) {
			Phase irrelevantPhase = testGetPhasesPage_addPhase(
				irrelevantProjectId, randomIrrelevantPhase());

			page = phaseResource.getPhasesPage(
				irrelevantProjectId, null, null, null, null,
				Pagination.of(1, 2), null);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantPhase), (List<Phase>)page.getItems());
			assertValid(page);
		}

		Phase phase1 = testGetPhasesPage_addPhase(projectId, randomPhase());

		Phase phase2 = testGetPhasesPage_addPhase(projectId, randomPhase());

		page = phaseResource.getPhasesPage(
			projectId, null, null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(phase1, phase2), (List<Phase>)page.getItems());
		assertValid(page);

		phaseResource.deletePhase(phase1.getId());

		phaseResource.deletePhase(phase2.getId());
	}

	@Test
	public void testGetPhasesPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Long projectId = testGetPhasesPage_getProjectId();

		Phase phase1 = randomPhase();

		phase1 = testGetPhasesPage_addPhase(projectId, phase1);

		for (EntityField entityField : entityFields) {
			Page<Phase> page = phaseResource.getPhasesPage(
				projectId, null, null, null,
				getFilterString(entityField, "between", phase1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(phase1),
				(List<Phase>)page.getItems());
		}
	}

	@Test
	public void testGetPhasesPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Long projectId = testGetPhasesPage_getProjectId();

		Phase phase1 = testGetPhasesPage_addPhase(projectId, randomPhase());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Phase phase2 = testGetPhasesPage_addPhase(projectId, randomPhase());

		for (EntityField entityField : entityFields) {
			Page<Phase> page = phaseResource.getPhasesPage(
				projectId, null, null, null,
				getFilterString(entityField, "eq", phase1), Pagination.of(1, 2),
				null);

			assertEquals(
				Collections.singletonList(phase1),
				(List<Phase>)page.getItems());
		}
	}

	@Test
	public void testGetPhasesPageWithPagination() throws Exception {
		Long projectId = testGetPhasesPage_getProjectId();

		Phase phase1 = testGetPhasesPage_addPhase(projectId, randomPhase());

		Phase phase2 = testGetPhasesPage_addPhase(projectId, randomPhase());

		Phase phase3 = testGetPhasesPage_addPhase(projectId, randomPhase());

		Page<Phase> page1 = phaseResource.getPhasesPage(
			projectId, null, null, null, null, Pagination.of(1, 2), null);

		List<Phase> phases1 = (List<Phase>)page1.getItems();

		Assert.assertEquals(phases1.toString(), 2, phases1.size());

		Page<Phase> page2 = phaseResource.getPhasesPage(
			projectId, null, null, null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Phase> phases2 = (List<Phase>)page2.getItems();

		Assert.assertEquals(phases2.toString(), 1, phases2.size());

		Page<Phase> page3 = phaseResource.getPhasesPage(
			projectId, null, null, null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(phase1, phase2, phase3),
			(List<Phase>)page3.getItems());
	}

	@Test
	public void testGetPhasesPageWithSortDateTime() throws Exception {
		testGetPhasesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, phase1, phase2) -> {
				BeanUtils.setProperty(
					phase1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetPhasesPageWithSortInteger() throws Exception {
		testGetPhasesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, phase1, phase2) -> {
				BeanUtils.setProperty(phase1, entityField.getName(), 0);
				BeanUtils.setProperty(phase2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetPhasesPageWithSortString() throws Exception {
		testGetPhasesPageWithSort(
			EntityField.Type.STRING,
			(entityField, phase1, phase2) -> {
				Class<?> clazz = phase1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						phase1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						phase2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						phase1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						phase2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						phase1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						phase2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetPhasesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Phase, Phase, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Long projectId = testGetPhasesPage_getProjectId();

		Phase phase1 = randomPhase();
		Phase phase2 = randomPhase();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, phase1, phase2);
		}

		phase1 = testGetPhasesPage_addPhase(projectId, phase1);

		phase2 = testGetPhasesPage_addPhase(projectId, phase2);

		for (EntityField entityField : entityFields) {
			Page<Phase> ascPage = phaseResource.getPhasesPage(
				projectId, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(phase1, phase2), (List<Phase>)ascPage.getItems());

			Page<Phase> descPage = phaseResource.getPhasesPage(
				projectId, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(phase2, phase1),
				(List<Phase>)descPage.getItems());
		}
	}

	protected Phase testGetPhasesPage_addPhase(Long projectId, Phase phase)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetPhasesPage_getProjectId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetPhasesPage_getIrrelevantProjectId() throws Exception {
		return null;
	}

	@Test
	public void testGraphQLGetPhasesPage() throws Exception {
		Long projectId = testGetPhasesPage_getProjectId();

		GraphQLField graphQLField = new GraphQLField(
			"phases",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);

					put("projectId", projectId);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject phasesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/phases");

		Assert.assertEquals(0, phasesJSONObject.get("totalCount"));

		Phase phase1 = testGraphQLPhase_addPhase();
		Phase phase2 = testGraphQLPhase_addPhase();

		phasesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/phases");

		Assert.assertEquals(2, phasesJSONObject.getLong("totalCount"));

		assertEqualsIgnoringOrder(
			Arrays.asList(phase1, phase2),
			Arrays.asList(
				PhaseSerDes.toDTOs(phasesJSONObject.getString("items"))));
	}

	@Test
	public void testDeletePhase() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Phase phase = testDeletePhase_addPhase();

		assertHttpResponseStatusCode(
			204, phaseResource.deletePhaseHttpResponse(phase.getId()));

		assertHttpResponseStatusCode(
			404, phaseResource.getPhaseHttpResponse(phase.getId()));

		assertHttpResponseStatusCode(
			404, phaseResource.getPhaseHttpResponse(0L));
	}

	protected Phase testDeletePhase_addPhase() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeletePhase() throws Exception {
		Phase phase = testGraphQLPhase_addPhase();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deletePhase",
						new HashMap<String, Object>() {
							{
								put("phaseId", phase.getId());
							}
						})),
				"JSONObject/data", "Object/deletePhase"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"phase",
					new HashMap<String, Object>() {
						{
							put("phaseId", phase.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetPhase() throws Exception {
		Phase postPhase = testGetPhase_addPhase();

		Phase getPhase = phaseResource.getPhase(postPhase.getId());

		assertEquals(postPhase, getPhase);
		assertValid(getPhase);
	}

	protected Phase testGetPhase_addPhase() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetPhase() throws Exception {
		Phase phase = testGraphQLPhase_addPhase();

		Assert.assertTrue(
			equals(
				phase,
				PhaseSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"phase",
								new HashMap<String, Object>() {
									{
										put("phaseId", phase.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/phase"))));
	}

	@Test
	public void testGraphQLGetPhaseNotFound() throws Exception {
		Long irrelevantPhaseId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"phase",
						new HashMap<String, Object>() {
							{
								put("phaseId", irrelevantPhaseId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutPhase() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Phase phase = testPutPhase_addPhase();

		assertHttpResponseStatusCode(
			204, phaseResource.putPhaseHttpResponse(phase.getId(), phase));

		assertHttpResponseStatusCode(
			404, phaseResource.putPhaseHttpResponse(0L, phase));
	}

	protected Phase testPutPhase_addPhase() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateDate() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Phase phase = testUpdateDate_addPhase();

		assertHttpResponseStatusCode(
			204,
			phaseResource.updateDateHttpResponse(phase.getId(), null, null));

		assertHttpResponseStatusCode(
			404, phaseResource.updateDateHttpResponse(0L, null, null));
	}

	protected Phase testUpdateDate_addPhase() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Phase testGraphQLPhase_addPhase() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Phase phase, List<Phase> phases) {
		boolean contains = false;

		for (Phase item : phases) {
			if (equals(phase, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(phases + " does not contain " + phase, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Phase phase1, Phase phase2) {
		Assert.assertTrue(
			phase1 + " does not equal " + phase2, equals(phase1, phase2));
	}

	protected void assertEquals(List<Phase> phases1, List<Phase> phases2) {
		Assert.assertEquals(phases1.size(), phases2.size());

		for (int i = 0; i < phases1.size(); i++) {
			Phase phase1 = phases1.get(i);
			Phase phase2 = phases2.get(i);

			assertEquals(phase1, phase2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Phase> phases1, List<Phase> phases2) {

		Assert.assertEquals(phases1.size(), phases2.size());

		for (Phase phase1 : phases1) {
			boolean contains = false;

			for (Phase phase2 : phases2) {
				if (equals(phase1, phase2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				phases2 + " does not contain " + phase1, contains);
		}
	}

	protected void assertValid(Phase phase) throws Exception {
		boolean valid = true;

		if (phase.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (phase.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("endDate", additionalAssertFieldName)) {
				if (phase.getEndDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (phase.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("manages", additionalAssertFieldName)) {
				if (phase.getManages() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (phase.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phaseManages", additionalAssertFieldName)) {
				if (phase.getPhaseManages() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("progress", additionalAssertFieldName)) {
				if (phase.getProgress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (phase.getProjectId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectName", additionalAssertFieldName)) {
				if (phase.getProjectName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (phase.getStartDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (phase.getStatus() == null) {
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

	protected void assertValid(Page<Phase> page) {
		boolean valid = false;

		java.util.Collection<Phase> phases = page.getItems();

		int size = phases.size();

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
					com.swork.core.phase.rest.dto.v1_0.Phase.class)) {

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

	protected boolean equals(Phase phase1, Phase phase2) {
		if (phase1 == phase2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						phase1.getDescription(), phase2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("endDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						phase1.getEndDate(), phase2.getEndDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						phase1.getExternalReferenceCode(),
						phase2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(phase1.getId(), phase2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("manages", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						phase1.getManages(), phase2.getManages())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(phase1.getName(), phase2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("phaseManages", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						phase1.getPhaseManages(), phase2.getPhaseManages())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("progress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						phase1.getProgress(), phase2.getProgress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						phase1.getProjectId(), phase2.getProjectId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						phase1.getProjectName(), phase2.getProjectName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						phase1.getStartDate(), phase2.getStartDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						phase1.getStatus(), phase2.getStatus())) {

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

		if (!(_phaseResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_phaseResource;

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
		EntityField entityField, String operator, Phase phase) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(phase.getDescription()));
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
						DateUtils.addSeconds(phase.getEndDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(phase.getEndDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(phase.getEndDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(phase.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
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
			sb.append(String.valueOf(phase.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("phaseManages")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("progress")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("projectId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("projectName")) {
			sb.append("'");
			sb.append(String.valueOf(phase.getProjectName()));
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
						DateUtils.addSeconds(phase.getStartDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(phase.getStartDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(phase.getStartDate()));
			}

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

	protected Phase randomPhase() throws Exception {
		return new Phase() {
			{
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				endDate = RandomTestUtil.nextDate();
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				progress = RandomTestUtil.randomLong();
				projectId = RandomTestUtil.randomLong();
				projectName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				startDate = RandomTestUtil.nextDate();
			}
		};
	}

	protected Phase randomIrrelevantPhase() throws Exception {
		Phase randomIrrelevantPhase = randomPhase();

		return randomIrrelevantPhase;
	}

	protected Phase randomPatchPhase() throws Exception {
		return randomPhase();
	}

	protected PhaseResource phaseResource;
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
		LogFactoryUtil.getLog(BasePhaseResourceTestCase.class);

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
	private com.swork.core.phase.rest.resource.v1_0.PhaseResource
		_phaseResource;

}