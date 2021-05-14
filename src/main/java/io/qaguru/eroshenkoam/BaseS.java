package io.qaguru.eroshenkoam;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class BaseS {

    private static String BASE_URL = "https://github.com/";
    private static String ISSUES = "Issues";

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open (BASE_URL);
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $x("//input[@name = 'q']").click();
        $x("//input[@name = 'q']").sendKeys(repository);
        $x("//input[@name = 'q']").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepositoryFromSearch(String repository){
        $x("//*[contains(@href, '"+ repository +"')]").click();
    }

    @Step("Переходим в раздел ISSUES")
    public void openRepositoryOpen(){
        $x("//span[@data-content ='" + ISSUES + "']").click();
    }

    @Step("Проверяем, что Issues с номером {ISSUE_NUMBER} существует")
    public void ShouldSeeIssueWithNumber(String number){
        $x("//span[@class ='opened-by']").shouldHave(Condition.text(number));
    }
}
