package test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import user.stories.ContactDetailsSectionStory;
import user.stories.EligibilitySectionStory;
import user.stories.FormSubmissionTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ContactDetailsSectionStory.class,
	EligibilitySectionStory.class,
	FormSubmissionTest.class
})
public class UserStoryTestSuite {

}
