package com.swork.core.project.service.internal.impl;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.core.project.service.internal.service.ProjectService;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component(
        scope = ServiceScope.PROTOTYPE,
        service = ProjectService.class
)
public class ProjectServiceImpl implements ProjectService {
    private static final String AVERAGE_WORKS = "averageWorks";
    private static final String PROPORTION_DATE = "proportionDate";

    @Override
    public void updateProgress(long projectId) {
        ProjectEntry projectEntry = localService.fetchProjectEntry(projectId);

        if (Validator.isNull(projectEntry)) {
            return;
        }

        List<WorkEntry> workEntries = workEntryLocalService.findByProjectId(projectId);

        if (projectEntry.getProgressType().equalsIgnoreCase(AVERAGE_WORKS)) {
            long progress = workEntries
                    .stream()
                    .reduce(
                            GetterUtil.DEFAULT_LONG,
                            (prevProgress, workEntry) -> prevProgress + workEntry.getProgress() / workEntries.size(),
                            Long::sum);

            localService.updateProgress(projectId, progress);
            return;
        }

        if (projectEntry.getProgressType().equalsIgnoreCase(PROPORTION_DATE)) {

            long totalProportion = workEntries.stream().reduce(
                    GetterUtil.DEFAULT_LONG,
                    (prevTotal, workEntry) -> prevTotal + getDayDiff(workEntry.getStartDate(), workEntry.getEndDate()) * 100,
                    Long::sum
            );

            long progress = workEntries
                    .stream()
                    .reduce(
                            GetterUtil.DEFAULT_LONG,
                            (prevProgress, workEntry) -> {
                                long dayDiff = getDayDiff(workEntry.getStartDate(), workEntry.getEndDate());
                                return prevProgress + (dayDiff * workEntry.getProgress()) / totalProportion;
                            },
                            Long::sum);

            localService.updateProgress(projectId, progress);
        }
    }

    private long getDayDiff(Date startDate, Date endDate) {
        long diffInMillis = Math.abs(endDate.getTime() - startDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    @Reference
    private ProjectEntryLocalService localService;

    @Reference
    private WorkEntryLocalService workEntryLocalService;
}
