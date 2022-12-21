package com.swork.notification.service.internal.search.listener.notification;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.webserver.WebServerServletTokenUtil;
import com.swork.notification.service.model.NotificationEntry;
import org.osgi.service.component.annotations.Component;

import java.text.SimpleDateFormat;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class NotificationEntryModelListener extends BaseModelListener<NotificationEntry> {
    private final String POST_URL = "https://gfc.dogoo.vn/notification";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    @Override
    public void onAfterCreate(NotificationEntry model) throws ModelListenerException {
//        if(model.getType().equals("notification")) {
//            List<NotificationPushEntry> notificationPushEntries;
//
//            if (model.getCategory().equals("work") || model.getCategory().equals("processwork") ||
//            model.getCategory().equals("workflow") || model.getCategory().equals("application") ||
//            model.getCategory().equals("decision") || model.getCategory().equals("contract")) {
//                notificationPushEntries =
//                        _notificationPushEntryLocalService.getNotificationPushEntriesByAccountId(
//                                model.getReceiverId()
//                        );
//            } else {
//                notificationPushEntries =
//                        _notificationPushEntryLocalService.getNotificationPushEntriesByAccountIdAndType(
//                                model.getReceiverId(), "web"
//                        );
//            }
//
//            List<String> deviceTokens = new ArrayList<>();
//
//            notificationPushEntries.stream().forEach(notificationPushEntry -> {
//                deviceTokens.add(notificationPushEntry.getDeviceToken());
//            });
//
//            JSONArray jsonArray = JSONFactoryUtil.createJSONArray(deviceTokens);
//            JSONObject jsonInputString = JSONFactoryUtil.createJSONObject();
//
//            jsonInputString.put("notificationId", model.getNotificationId());
//            jsonInputString.put("externalReferenceCode", model.getExternalReferenceCode());
//            jsonInputString.put("status", model.getStatus());
//            jsonInputString.put("statusDate", simpleDateFormat.format(model.getStatusDate()));
//            jsonInputString.put("count", model.getCount());
//            jsonInputString.put(SearchFields.PATH_NAME, model.getPathName());
//            jsonInputString.put("category", model.getCategory());
//            jsonInputString.put("type", model.getType());
//            jsonInputString.put("name", model.getName());
//            jsonInputString.put("description", model.getDescription());
//            jsonInputString.put("createDate", simpleDateFormat.format(model.getCreateDate()));
//            jsonInputString.put("doEntryId", model.getDoEntryId());
//            jsonInputString.put("taskAssignmetnInstanceId", model.getTaskInstanceId());
//            jsonInputString.put("receiverId", model.getReceiverId());
//            jsonInputString.put("senderId", model.getCreatorId());
//            jsonInputString.put("senderName", getAccountName(model.getCreatorId()));
//            jsonInputString.put("receiverName", getAccountName(model.getReceiverId()));
//            jsonInputString.put("senderAvatar", _getLogoURL(getAvatarId(model.getCreatorId())));
//            jsonInputString.put("urlNotify", getNavigateUrl(
//                    model.getCategory(),
//                    model.getTaskInstanceId(),
//                    model.getDoEntryId(),
//                    model.getName(),model.getPathName()
//            ));
//            jsonInputString.put("deviceTokens", jsonArray);
//
//            try {
//                URL url = new URL(POST_URL);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("POST");
//                connection.setRequestProperty("Content-Type", "application/json");
//
//                connection.setDoOutput(true);
//                OutputStream os = connection.getOutputStream();
//                os.write(jsonInputString.toString().getBytes("utf-8"));
//                os.flush();
//                os.close();
//
//                int responseCode = connection.getResponseCode();
//
//                if (responseCode == HttpURLConnection.HTTP_OK) {
//                    BufferedReader in = new BufferedReader(new InputStreamReader(
//                            connection.getInputStream()));
//                    String inputLine;
//                    StringBuffer response = new StringBuffer();
//
//                    while ((inputLine = in.readLine()) != null) {
//                        response.append(inputLine);
//                    }
//                    in.close();
//
//                    if (!response.equals("")) {
//                        String[] failedTokens = response.toString().trim().split(" ");
//
//                        for (String failedToken : failedTokens) {
//                            NotificationPushEntry notificationPushEntry =
//                                    _notificationPushEntryLocalService.
//                                            getNotificationPushEntryByDeviceTokenAndAccountId(
//                                                    failedToken,
//                                                    model.getReceiverId());
//
//                            if (Validator.isNotNull(notificationPushEntry)) {
//                                _notificationPushEntryLocalService.deleteNotificationPushEntry(notificationPushEntry);
//                            }
//                        }
//                    }
//                } else {
//                    System.out.println("POST request not worked");
//                }
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }


    private String _getLogoURL(long logoId) {

        return com.liferay.petra.string.StringBundler.concat(
                "/image/organization_logo?img_id=", logoId, "&t=",
                WebServerServletTokenUtil.getToken(logoId));
    }


    private String getNavigateUrl(String category, long taskAssignmetnInstanceId, long doEntryId, String name, String pathName) {
        String url;
        switch (category) {
            case "workflow":
                url = "/user/my-work-flow/work-process/all/view/" + taskAssignmetnInstanceId;
                break;
            case "processwork":
                url = "/workplace/work/work-process/all/view/" + taskAssignmetnInstanceId;
                break;
            case "work":
                url = "/workplace/work/normal/task-view/" + doEntryId;
                break;
            case "application":
                url = applicationView(name, doEntryId);
                break;
            case "decision":
                url = decisionView(name, doEntryId);
                break;
            case "assessment":
                url = "/hrm/personnel/competency-assessment/assessment-employee/detail/" + doEntryId;
                break;
            case "contract":
                url = "/hrm/personnel/labor-contract/detail/" + doEntryId;
                break;
            case "article":
                url = "/setting/cms/article/update/" + doEntryId;
                break;
            case "cmsarticle":
                url = "/cms/article/" + doEntryId;
                break;
            case "kpi":
                url = "/hrm/evaluation/kpi/period/detail/" + doEntryId;
                break;
            case "sequencework":
                return pathName;

            default:
                url = "/cms";
                break;
        }

        return url;
    }

    private String applicationView(String name, long idEntry) {
        String url;
        switch (name) {
            case "ApplicationAbsenceEntry":
                url = "/hrm/application/administrative/absence/view/" + idEntry;
                break;
            case "ApplicationFlexibleEntry":
                url = "/hrm/application/administrative/flexible/view/" + idEntry;
                break;
            case "ApplicationInoutEntry":
                url = "/hrm/application/administrative/inout/view/" + idEntry;
                break;
            case "ApplicationLeaveEntry":
                url = "/hrm/application/administrative/leave/view/" + idEntry;
                break;
            case "ApplicationMissionEntry":
                url = "/hrm/application/administrative/missions/view/" + idEntry;
                break;
            case "ApplicationOvertimeEntry":
                url = "/hrm/application/administrative/overtime/view/" + idEntry;
                break;
            case "ApplicationResignEntry":
                url = "/hrm/application/administrative/resign/view/" + idEntry;
                break;
            case "ApplicationShiftEntry":
                url = "/hrm/application/administrative/shift%20registration/view/" + idEntry;
                break;
            case "ApplicationShiftChangeEntry":
                url = "/hrm/application/administrative/shift%20swap/view/" + idEntry;
                break;
            case "ApplicationShiftMoreEntry":
                url = "/hrm/application/administrative/shift%20more/view/" + idEntry;
                break;
            case "ApplicationLateEntry":
                url = "/hrm/application/administrative/late/view/" + idEntry;
                break;
            default:
                url = "/cms";
                break;
        }

        return url;
    }

    private String decisionView(String name, long idEntry) {
        String url;
        switch (name) {
            case "DecisionAdmissionEntry":
                url = "/hrm/personnel/decision/admission/" + idEntry;
                break;
            case "DecisionAppointmentEntry":
                url = "/hrm/personnel/decision/appointment/" + idEntry;
                break;
            case "DecisionContractEntry":
                url = "/hrm/personnel/decision/contract/" + idEntry;
                break;
            case "DecisionDisciplineEntry":
                url = "/hrm/personnel/decision/discipline/" + idEntry;
                break;
            case "DecisionDismissalEntry":
                url = "/hrm/personnel/decision/dismissal/" + idEntry;
                break;
            case "DecisionRewardEntry":
                url = "/hrm/personnel/decision/reward/" + idEntry;
                break;
            case "DecisionSalaryEntry":
                url = "/hrm/personnel/decision/salary/" + idEntry;
                break;
            case "DecisionTransferEntry":
                url = "/hrm/personnel/decision/transfer/" + idEntry;
                break;
            default:
                url = "/cms";
                break;
        }

        return url;
    }

//    @Reference
//    private NotificationPushEntryLocalService _notificationPushEntryLocalService;

}
