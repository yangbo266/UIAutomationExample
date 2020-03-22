package test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.BGPLoginPageTest;
import pages.BusinessImpactPageTest;
import pages.CostDetailsPageTest;
import pages.DeclarePageTest;
import pages.EligibilityPageTest;
import pages.GrantPageTest;
import pages.OwnUserLoginPageTest;
import pages.ProposalPageTest;
import pages.ReviewPageTest;
import pages.SectorDevFuncAreaPageTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BGPLoginPageTest.class,
	BusinessImpactPageTest.class,
	CostDetailsPageTest.class,
	DeclarePageTest.class,
	EligibilityPageTest.class,
	GrantPageTest.class,
	OwnUserLoginPageTest.class,
	ProposalPageTest.class,
	ReviewPageTest.class,
	SectorDevFuncAreaPageTest.class
})
public class PageUnitTestSuite {

}
