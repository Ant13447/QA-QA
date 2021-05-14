package test.povtor;

import io.qaguru.eroshenkoam.BaseS;
import org.junit.jupiter.api.Test;

public class Method {

    public BaseS steps = new BaseS();

    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static String ISSUE_NUMBER = "#68";


    @Test
    public void testIssueSearch(){

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryOpen();
        steps.ShouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
