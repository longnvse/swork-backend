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

import com.swork.core.resource.rest.client.dto.v1_0.Team;
import com.swork.core.resource.rest.client.http.HttpInvoker;
import com.swork.core.resource.rest.client.pagination.Page;
import com.swork.core.resource.rest.client.pagination.Pagination;
import com.swork.core.resource.rest.client.resource.v1_0.TeamResource;
import com.swork.core.resource.rest.client.serdes.v1_0.TeamSerDes;

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
public abstract class BaseTeamResourceTestCase {

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

		_teamResource.setContextCompany(testCompany);

		TeamResource.Builder builder = TeamResource.builder();

		teamResource = builder.authentication(
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

		Team team1 = randomTeam();

		String json = objectMapper.writeValueAsString(team1);

		Team team2 = TeamSerDes.toDTO(json);

		Assert.assertTrue(equals(team1, team2));
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

		Team team = randomTeam();

		String json1 = objectMapper.writeValueAsString(team);
		String json2 = TeamSerDes.toJSON(team);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Team team = randomTeam();

		team.setCreator(regex);
		team.setDescription(regex);
		team.setExternalReferenceCode(regex);
		team.setName(regex);
		team.setPhaseName(regex);
		team.setProjectName(regex);

		String json = TeamSerDes.toJSON(team);

		Assert.assertFalse(json.contains(regex));

		team = TeamSerDes.toDTO(json);

		Assert.assertEquals(regex, team.getCreator());
		Assert.assertEquals(regex, team.getDescription());
		Assert.assertEquals(regex, team.getExternalReferenceCode());
		Assert.assertEquals(regex, team.getName());
		Assert.assertEquals(regex, team.getPhaseName());
		Assert.assertEquals(regex, team.getProjectName());
	}

	@Test
	public void testGetTeamPages() throws Exception {
		Page<Team> page = teamResource.getTeamPages(
			null, null, null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Team team1 = testGetTeamPages_addTeam(randomTeam());

		Team team2 = testGetTeamPages_addTeam(randomTeam());

		page = teamResource.getTeamPages(
			null, null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(team1, (List<Team>)page.getItems());
		assertContains(team2, (List<Team>)page.getItems());
		assertValid(page);

		teamResource.deleteTeam(team1.getId());

		teamResource.deleteTeam(team2.getId());
	}

	@Test
	public void testGetTeamPagesWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Team team1 = randomTeam();

		team1 = testGetTeamPages_addTeam(team1);

		for (EntityField entityField : entityFields) {
			Page<Team> page = teamResource.getTeamPages(
				null, null, null,
				getFilterString(entityField, "between", team1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(team1), (List<Team>)page.getItems());
		}
	}

	@Test
	public void testGetTeamPagesWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Team team1 = testGetTeamPages_addTeam(randomTeam());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Team team2 = testGetTeamPages_addTeam(randomTeam());

		for (EntityField entityField : entityFields) {
			Page<Team> page = teamResource.getTeamPages(
				null, null, null, getFilterString(entityField, "eq", team1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(team1), (List<Team>)page.getItems());
		}
	}

	@Test
	public void testGetTeamPagesWithPagination() throws Exception {
		Page<Team> totalPage = teamResource.getTeamPages(
			null, null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Team team1 = testGetTeamPages_addTeam(randomTeam());

		Team team2 = testGetTeamPages_addTeam(randomTeam());

		Team team3 = testGetTeamPages_addTeam(randomTeam());

		Page<Team> page1 = teamResource.getTeamPages(
			null, null, null, null, Pagination.of(1, totalCount + 2), null);

		List<Team> teams1 = (List<Team>)page1.getItems();

		Assert.assertEquals(teams1.toString(), totalCount + 2, teams1.size());

		Page<Team> page2 = teamResource.getTeamPages(
			null, null, null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Team> teams2 = (List<Team>)page2.getItems();

		Assert.assertEquals(teams2.toString(), 1, teams2.size());

		Page<Team> page3 = teamResource.getTeamPages(
			null, null, null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(team1, (List<Team>)page3.getItems());
		assertContains(team2, (List<Team>)page3.getItems());
		assertContains(team3, (List<Team>)page3.getItems());
	}

	@Test
	public void testGetTeamPagesWithSortDateTime() throws Exception {
		testGetTeamPagesWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, team1, team2) -> {
				BeanUtils.setProperty(
					team1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetTeamPagesWithSortInteger() throws Exception {
		testGetTeamPagesWithSort(
			EntityField.Type.INTEGER,
			(entityField, team1, team2) -> {
				BeanUtils.setProperty(team1, entityField.getName(), 0);
				BeanUtils.setProperty(team2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetTeamPagesWithSortString() throws Exception {
		testGetTeamPagesWithSort(
			EntityField.Type.STRING,
			(entityField, team1, team2) -> {
				Class<?> clazz = team1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						team1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						team2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						team1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						team2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						team1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						team2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetTeamPagesWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Team, Team, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Team team1 = randomTeam();
		Team team2 = randomTeam();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, team1, team2);
		}

		team1 = testGetTeamPages_addTeam(team1);

		team2 = testGetTeamPages_addTeam(team2);

		for (EntityField entityField : entityFields) {
			Page<Team> ascPage = teamResource.getTeamPages(
				null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(team1, team2), (List<Team>)ascPage.getItems());

			Page<Team> descPage = teamResource.getTeamPages(
				null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(team2, team1), (List<Team>)descPage.getItems());
		}
	}

	protected Team testGetTeamPages_addTeam(Team team) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostTeam() throws Exception {
		Team randomTeam = randomTeam();

		Team postTeam = testPostTeam_addTeam(randomTeam);

		assertEquals(randomTeam, postTeam);
		assertValid(postTeam);
	}

	protected Team testPostTeam_addTeam(Team team) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteTeam() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Team team = testDeleteTeam_addTeam();

		assertHttpResponseStatusCode(
			204, teamResource.deleteTeamHttpResponse(team.getId()));

		assertHttpResponseStatusCode(
			404, teamResource.getTeamHttpResponse(team.getId()));

		assertHttpResponseStatusCode(404, teamResource.getTeamHttpResponse(0L));
	}

	protected Team testDeleteTeam_addTeam() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteTeam() throws Exception {
		Team team = testGraphQLTeam_addTeam();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteTeam",
						new HashMap<String, Object>() {
							{
								put("teamId", team.getId());
							}
						})),
				"JSONObject/data", "Object/deleteTeam"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"team",
					new HashMap<String, Object>() {
						{
							put("teamId", team.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetTeam() throws Exception {
		Team postTeam = testGetTeam_addTeam();

		Team getTeam = teamResource.getTeam(postTeam.getId());

		assertEquals(postTeam, getTeam);
		assertValid(getTeam);
	}

	protected Team testGetTeam_addTeam() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetTeam() throws Exception {
		Team team = testGraphQLTeam_addTeam();

		Assert.assertTrue(
			equals(
				team,
				TeamSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"team",
								new HashMap<String, Object>() {
									{
										put("teamId", team.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/team"))));
	}

	@Test
	public void testGraphQLGetTeamNotFound() throws Exception {
		Long irrelevantTeamId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"team",
						new HashMap<String, Object>() {
							{
								put("teamId", irrelevantTeamId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutTeam() throws Exception {
		Team postTeam = testPutTeam_addTeam();

		Team randomTeam = randomTeam();

		Team putTeam = teamResource.putTeam(postTeam.getId(), randomTeam);

		assertEquals(randomTeam, putTeam);
		assertValid(putTeam);

		Team getTeam = teamResource.getTeam(putTeam.getId());

		assertEquals(randomTeam, getTeam);
		assertValid(getTeam);
	}

	protected Team testPutTeam_addTeam() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Team testGraphQLTeam_addTeam() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Team team, List<Team> teams) {
		boolean contains = false;

		for (Team item : teams) {
			if (equals(team, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(teams + " does not contain " + team, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Team team1, Team team2) {
		Assert.assertTrue(
			team1 + " does not equal " + team2, equals(team1, team2));
	}

	protected void assertEquals(List<Team> teams1, List<Team> teams2) {
		Assert.assertEquals(teams1.size(), teams2.size());

		for (int i = 0; i < teams1.size(); i++) {
			Team team1 = teams1.get(i);
			Team team2 = teams2.get(i);

			assertEquals(team1, team2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Team> teams1, List<Team> teams2) {

		Assert.assertEquals(teams1.size(), teams2.size());

		for (Team team1 : teams1) {
			boolean contains = false;

			for (Team team2 : teams2) {
				if (equals(team1, team2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(teams2 + " does not contain " + team1, contains);
		}
	}

	protected void assertValid(Team team) throws Exception {
		boolean valid = true;

		if (team.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("admins", additionalAssertFieldName)) {
				if (team.getAdmins() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (team.getCreateDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (team.getCreator() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (team.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (team.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("isActive", additionalAssertFieldName)) {
				if (team.getIsActive() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("members", additionalAssertFieldName)) {
				if (team.getMembers() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("modifiedDate", additionalAssertFieldName)) {
				if (team.getModifiedDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (team.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phaseId", additionalAssertFieldName)) {
				if (team.getPhaseId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phaseName", additionalAssertFieldName)) {
				if (team.getPhaseName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (team.getProjectId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectName", additionalAssertFieldName)) {
				if (team.getProjectName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("quantityMember", additionalAssertFieldName)) {
				if (team.getQuantityMember() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("resources", additionalAssertFieldName)) {
				if (team.getResources() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("totalIncoming", additionalAssertFieldName)) {
				if (team.getTotalIncoming() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("totalSpending", additionalAssertFieldName)) {
				if (team.getTotalSpending() == null) {
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

	protected void assertValid(Page<Team> page) {
		boolean valid = false;

		java.util.Collection<Team> teams = page.getItems();

		int size = teams.size();

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
					com.swork.core.resource.rest.dto.v1_0.Team.class)) {

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

	protected boolean equals(Team team1, Team team2) {
		if (team1 == team2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("admins", additionalAssertFieldName)) {
				if (!Objects.deepEquals(team1.getAdmins(), team2.getAdmins())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getCreateDate(), team2.getCreateDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getCreator(), team2.getCreator())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getDescription(), team2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						team1.getExternalReferenceCode(),
						team2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(team1.getId(), team2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("isActive", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getIsActive(), team2.getIsActive())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("members", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getMembers(), team2.getMembers())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("modifiedDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getModifiedDate(), team2.getModifiedDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(team1.getName(), team2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("phaseId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getPhaseId(), team2.getPhaseId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phaseName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getPhaseName(), team2.getPhaseName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getProjectId(), team2.getProjectId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getProjectName(), team2.getProjectName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("quantityMember", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getQuantityMember(), team2.getQuantityMember())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("resources", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getResources(), team2.getResources())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("totalIncoming", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getTotalIncoming(), team2.getTotalIncoming())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("totalSpending", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						team1.getTotalSpending(), team2.getTotalSpending())) {

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

		if (!(_teamResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_teamResource;

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
		EntityField entityField, String operator, Team team) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("admins")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("createDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(team.getCreateDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(team.getCreateDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(team.getCreateDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("creator")) {
			sb.append("'");
			sb.append(String.valueOf(team.getCreator()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(team.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(team.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("isActive")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("members")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("modifiedDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(team.getModifiedDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(team.getModifiedDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(team.getModifiedDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(team.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("phaseId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("phaseName")) {
			sb.append("'");
			sb.append(String.valueOf(team.getPhaseName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("projectId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("projectName")) {
			sb.append("'");
			sb.append(String.valueOf(team.getProjectName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("quantityMember")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("resources")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("totalIncoming")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("totalSpending")) {
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

	protected Team randomTeam() throws Exception {
		return new Team() {
			{
				createDate = RandomTestUtil.nextDate();
				creator = StringUtil.toLowerCase(RandomTestUtil.randomString());
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				isActive = RandomTestUtil.randomBoolean();
				modifiedDate = RandomTestUtil.nextDate();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				phaseId = RandomTestUtil.randomLong();
				phaseName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				projectId = RandomTestUtil.randomLong();
				projectName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				quantityMember = RandomTestUtil.randomInt();
				totalIncoming = RandomTestUtil.randomLong();
				totalSpending = RandomTestUtil.randomLong();
			}
		};
	}

	protected Team randomIrrelevantTeam() throws Exception {
		Team randomIrrelevantTeam = randomTeam();

		return randomIrrelevantTeam;
	}

	protected Team randomPatchTeam() throws Exception {
		return randomTeam();
	}

	protected TeamResource teamResource;
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
		LogFactoryUtil.getLog(BaseTeamResourceTestCase.class);

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
	private com.swork.core.resource.rest.resource.v1_0.TeamResource
		_teamResource;

}