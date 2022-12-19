package com.swork.core.phase.rest.test.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.swork.common.exception.model.SW_BadRequestException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.core.phase.rest.dto.v1_0.Phase;
import com.swork.core.phase.rest.internal.service.LanguageService;
import com.swork.core.phase.rest.internal.validator.PhaseValidator;
import com.swork.core.phase.rest.test.mockdata.PhaseEntryMockData;
import com.swork.core.phase.rest.test.mockdata.PhaseMockDataUtil;
import com.swork.core.phase.rest.test.mockdata.ProjectEntryMockData;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.model.PhaseEntryWrapper;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.model.ProjectEntryWrapper;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.osgi.service.component.annotations.Reference;

import java.text.ParseException;
import java.util.Date;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhaseValidatorTest {
    @Mock
    private LanguageService languageService;
    @Mock
    private ProjectEntryLocalService projectEntryLocalService;
    @Mock
    private PhaseEntryLocalService phaseEntryLocalService;
    @InjectMocks
    private PhaseValidator phaseValidator;
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void testValidatorForAddWhenNameTooLong() throws SW_BadRequestException, ParseException {
        Phase phase = PhaseMockDataUtil.buildPhase();
        phase.setName("The full documentation is available online here. But be aware that it is the full documentation, intended as a reference. For just learning to understand AutoGen, the introduction has a purpose section and a simple example. For handy reference, Source Forge has a Google link to help you search the documentation.\n" +
                "\n" +
                "A FAQ (Frequently Asked Questions) is available online.\n" +
                "\n" +
                "The AutoGen distribution now comes with a ``make package'' rule that will create a native binary package for Solaris and Linux platforms. I'd like to do the same for Debian, Fink and other platforms, too.\n" +
                "\n" +
                "AutoOpts 41.1, a semi-automated command line option parser, is included with AutoGen 5.18.6pre15. It automatically generates everything you need for option processing, including man pages and an \"invoking\" chapter for your texinfo document. There is a separate AutoOpts chapter in the AutoGen doc, complete with a quick-start section. Online, there is a command line option parser Feature Comparison.\n" +
                "\n" +
                "Be aware that this chapter is the complete reference doc for AutoOpts, so don't let it overwhelm you.\n" +
                "\n" +
                "AutoOpts incorporates a configuration file parser library. This functionality supports AutoOpts features and is also available separately through configFileLoad(3AutoOpts) and a selected subset of libopts exported functions.\n" +
                "\n" +
                "blocksort is a separately downloadable module that you can use as an example of how to integrate the libopts library component of AutoOpts in your project. The above referenced page also gives information on how to simply use AutoOpts.\n" +
                "\n" +
                "All that notwithstanding, some folks do not want to mess with dependencies on external libraries. There is now help for you, too: getopt(3C) and getopt_long(3GNU) can parse the AutoOpts options instead of the libopts library. It significantly reduces the set of available features, though.\n" +
                "\n" +
                "AutoFSM, a finite state machine generator, is included with AutoGen. It automatically generates easy-to-follow tables and a prototype implementation of a Finite State Machine.\n" +
                "\n" +
                "The snprintfv formatting library is included in the AutoGen distribution. It is a replacement for stdio formatting library. It is ");
        expected.expect(PortalException.class);
        phaseValidator.validatorForAdd(1L, phase);
    }

    @Test
    public void testValidatorForAddWhenDescriptionTooLong() throws SW_BadRequestException, ParseException {
        Phase phase = PhaseMockDataUtil.buildPhase();
        phase.setDescription("The full documentation is available online here. But be aware that it is the full documentation, intended as a reference. For just learning to understand AutoGen, the introduction has a purpose section and a simple example. For handy reference, Source Forge has a Google link to help you search the documentation.\n" +
                "\n" +
                "A FAQ (Frequently Asked Questions) is available online.\n" +
                "\n" +
                "The AutoGen distribution now comes with a ``make package'' rule that will create a native binary package for Solaris and Linux platforms. I'd like to do the same for Debian, Fink and other platforms, too.\n" +
                "\n" +
                "AutoOpts 41.1, a semi-automated command line option parser, is included with AutoGen 5.18.6pre15. It automatically generates everything you need for option processing, including man pages and an \"invoking\" chapter for your texinfo document. There is a separate AutoOpts chapter in the AutoGen doc, complete with a quick-start section. Online, there is a command line option parser Feature Comparison.\n" +
                "\n" +
                "Be aware that this chapter is the complete reference doc for AutoOpts, so don't let it overwhelm you.\n" +
                "\n" +
                "AutoOpts incorporates a configuration file parser library. This functionality supports AutoOpts features and is also available separately through configFileLoad(3AutoOpts) and a selected subset of libopts exported functions.\n" +
                "\n" +
                "blocksort is a separately downloadable module that you can use as an example of how to integrate the libopts library component of AutoOpts in your project. The above referenced page also gives information on how to simply use AutoOpts.\n" +
                "\n" +
                "All that notwithstanding, some folks do not want to mess with dependencies on external libraries. There is now help for you, too: getopt(3C) and getopt_long(3GNU) can parse the AutoOpts options instead of the libopts library. It significantly reduces the set of available features, though.\n" +
                "\n" +
                "AutoFSM, a finite state machine generator, is included with AutoGen. It automatically generates easy-to-follow tables and a prototype implementation of a Finite State Machine.\n" +
                "\n" +
                "The snprintfv formatting library is included in the AutoGen distribution. It is a replacement for stdio formatting library. It is ");
        expected.expect(PortalException.class);
        phaseValidator.validatorForAdd(1L, phase);
    }

    @Test
    public void testValidatorForAddWhenNameHasBeenUse() throws SW_BadRequestException, ParseException {
        PhaseEntry phaseEntry=new PhaseEntryWrapper(new PhaseEntryMockData());
        when(phaseEntryLocalService.getByPhaseName(anyLong(), anyLong(), anyString())).thenReturn(phaseEntry);
        Phase phase=PhaseMockDataUtil.buildPhase();
        expected.expect(PortalException.class);
        phaseValidator.validatorForAdd(1L, phase);
    }

    @Test
    public void testValidatorForAddWhenTimeOfPhaseOutOfProjectStartDate() throws SW_BadRequestException, ParseException {
        Phase phase =PhaseMockDataUtil.buildPhase();
        phase.setStartDate(new Date(2003,02,01));
        phase.setEndDate(new Date(2010,01,01));
        ProjectEntry projectEntry=new ProjectEntryWrapper(new ProjectEntryMockData());
        projectEntry.setStartDate(new Date(2005,02,03));
        projectEntry.setEndDate(new Date(2010,01,01));
        when(projectEntryLocalService.fetchProjectEntry(anyLong())).thenReturn(projectEntry);
        expected.expect(PortalException.class);
        phaseValidator.validatorForAdd(1L, phase);
    }

    @Test
    public void testValidatorForAddWhenTimeOfPhaseOutOfProjectEndDate() throws SW_BadRequestException, ParseException {
        Phase phase =PhaseMockDataUtil.buildPhase();
        phase.setStartDate(new Date(2003,02,01));
        phase.setEndDate(new Date(2011,01,01));
        ProjectEntry projectEntry=new ProjectEntryWrapper(new ProjectEntryMockData());
        projectEntry.setStartDate(new Date(2003,02,01));
        projectEntry.setEndDate(new Date(2010,01,01));
        when(projectEntryLocalService.fetchProjectEntry(anyLong())).thenReturn(projectEntry);
        expected.expect(PortalException.class);
        phaseValidator.validatorForAdd(1L, phase);
    }

    @Test
    public void testValidatorForAddWhenStartDateAfterEndDate() throws SW_BadRequestException, ParseException {
        Phase phase =PhaseMockDataUtil.buildPhase();
        phase.setStartDate(new Date(2003,02,01));
        phase.setEndDate(new Date(2001,01,01));
        expected.expect(PortalException.class);
        phaseValidator.validatorForAdd(1L, phase);
    }

    @Test
    public void testValidatorForUpdateWhenNameTooLong() throws SW_BadRequestException, ParseException {
        Phase phase = PhaseMockDataUtil.buildPhase();
        phase.setName("The full documentation is available online here. But be aware that it is the full documentation, intended as a reference. For just learning to understand AutoGen, the introduction has a purpose section and a simple example. For handy reference, Source Forge has a Google link to help you search the documentation.\n" +
                "\n" +
                "A FAQ (Frequently Asked Questions) is available online.\n" +
                "\n" +
                "The AutoGen distribution now comes with a ``make package'' rule that will create a native binary package for Solaris and Linux platforms. I'd like to do the same for Debian, Fink and other platforms, too.\n" +
                "\n" +
                "AutoOpts 41.1, a semi-automated command line option parser, is included with AutoGen 5.18.6pre15. It automatically generates everything you need for option processing, including man pages and an \"invoking\" chapter for your texinfo document. There is a separate AutoOpts chapter in the AutoGen doc, complete with a quick-start section. Online, there is a command line option parser Feature Comparison.\n" +
                "\n" +
                "Be aware that this chapter is the complete reference doc for AutoOpts, so don't let it overwhelm you.\n" +
                "\n" +
                "AutoOpts incorporates a configuration file parser library. This functionality supports AutoOpts features and is also available separately through configFileLoad(3AutoOpts) and a selected subset of libopts exported functions.\n" +
                "\n" +
                "blocksort is a separately downloadable module that you can use as an example of how to integrate the libopts library component of AutoOpts in your project. The above referenced page also gives information on how to simply use AutoOpts.\n" +
                "\n" +
                "All that notwithstanding, some folks do not want to mess with dependencies on external libraries. There is now help for you, too: getopt(3C) and getopt_long(3GNU) can parse the AutoOpts options instead of the libopts library. It significantly reduces the set of available features, though.\n" +
                "\n" +
                "AutoFSM, a finite state machine generator, is included with AutoGen. It automatically generates easy-to-follow tables and a prototype implementation of a Finite State Machine.\n" +
                "\n" +
                "The snprintfv formatting library is included in the AutoGen distribution. It is a replacement for stdio formatting library. It is ");
        expected.expect(PortalException.class);
        phaseValidator.validatorForUpdate(1L,1L, phase);
    }

    @Test
    public void testValidatorForUpdateWhenDescriptionTooLong() throws SW_BadRequestException, ParseException {
        Phase phase = PhaseMockDataUtil.buildPhase();
        phase.setDescription("The full documentation is available online here. But be aware that it is the full documentation, intended as a reference. For just learning to understand AutoGen, the introduction has a purpose section and a simple example. For handy reference, Source Forge has a Google link to help you search the documentation.\n" +
                "\n" +
                "A FAQ (Frequently Asked Questions) is available online.\n" +
                "\n" +
                "The AutoGen distribution now comes with a ``make package'' rule that will create a native binary package for Solaris and Linux platforms. I'd like to do the same for Debian, Fink and other platforms, too.\n" +
                "\n" +
                "AutoOpts 41.1, a semi-automated command line option parser, is included with AutoGen 5.18.6pre15. It automatically generates everything you need for option processing, including man pages and an \"invoking\" chapter for your texinfo document. There is a separate AutoOpts chapter in the AutoGen doc, complete with a quick-start section. Online, there is a command line option parser Feature Comparison.\n" +
                "\n" +
                "Be aware that this chapter is the complete reference doc for AutoOpts, so don't let it overwhelm you.\n" +
                "\n" +
                "AutoOpts incorporates a configuration file parser library. This functionality supports AutoOpts features and is also available separately through configFileLoad(3AutoOpts) and a selected subset of libopts exported functions.\n" +
                "\n" +
                "blocksort is a separately downloadable module that you can use as an example of how to integrate the libopts library component of AutoOpts in your project. The above referenced page also gives information on how to simply use AutoOpts.\n" +
                "\n" +
                "All that notwithstanding, some folks do not want to mess with dependencies on external libraries. There is now help for you, too: getopt(3C) and getopt_long(3GNU) can parse the AutoOpts options instead of the libopts library. It significantly reduces the set of available features, though.\n" +
                "\n" +
                "AutoFSM, a finite state machine generator, is included with AutoGen. It automatically generates easy-to-follow tables and a prototype implementation of a Finite State Machine.\n" +
                "\n" +
                "The snprintfv formatting library is included in the AutoGen distribution. It is a replacement for stdio formatting library. It is ");
        expected.expect(PortalException.class);
        phaseValidator.validatorForUpdate(1L,1L, phase);
    }

    @Test
    public void testValidatorForUpdateWhenNameHasBeenUse() throws SW_BadRequestException, ParseException {
        PhaseEntry phaseEntry=new PhaseEntryWrapper(new PhaseEntryMockData());
        when(phaseEntryLocalService.getByPhaseName(anyLong(), anyLong(), anyString())).thenReturn(phaseEntry);
        Phase phase=PhaseMockDataUtil.buildPhase();
        expected.expect(PortalException.class);
        phaseValidator.validatorForUpdate(1L,1L, phase);
    }

    @Test
    public void testValidatorForUpdateWhenTimeOfPhaseOutOfProjectStartDate() throws SW_BadRequestException, ParseException {
        Phase phase =PhaseMockDataUtil.buildPhase();
        phase.setStartDate(new Date(2003,02,01));
        phase.setEndDate(new Date(2010,01,01));
        ProjectEntry projectEntry=new ProjectEntryWrapper(new ProjectEntryMockData());
        projectEntry.setStartDate(new Date(2005,02,03));
        projectEntry.setEndDate(new Date(2010,01,01));
        when(projectEntryLocalService.fetchProjectEntry(anyLong())).thenReturn(projectEntry);
        expected.expect(PortalException.class);
        phaseValidator.validatorForUpdate(1L,1L, phase);
    }

    @Test
    public void testValidatorForUpdateWhenTimeOfPhaseOutOfProjectEndDate() throws SW_BadRequestException, ParseException {
        Phase phase =PhaseMockDataUtil.buildPhase();
        phase.setStartDate(new Date(2003,02,01));
        phase.setEndDate(new Date(2011,01,01));
        ProjectEntry projectEntry=new ProjectEntryWrapper(new ProjectEntryMockData());
        projectEntry.setStartDate(new Date(2003,02,01));
        projectEntry.setEndDate(new Date(2010,01,01));
        when(projectEntryLocalService.fetchProjectEntry(anyLong())).thenReturn(projectEntry);
        expected.expect(PortalException.class);
        phaseValidator.validatorForUpdate(1L,1L, phase);
    }

    @Test
    public void testValidatorForUpdateWhenStartDateAfterEndDate() throws SW_BadRequestException, ParseException {
        Phase phase =PhaseMockDataUtil.buildPhase();
        phase.setStartDate(new Date(2003,02,01));
        phase.setEndDate(new Date(2001,01,01));
        expected.expect(PortalException.class);
        phaseValidator.validatorForUpdate(1L,1L, phase);
    }

    @Test
    public void testValidateForExist() throws SW_NoSuchEntryException {
        when(phaseEntryLocalService.fetchPhaseEntry(anyLong())).thenReturn(null);
        expected.expect(PortalException.class);
        phaseValidator.validateForExist(1L);
    }


}
