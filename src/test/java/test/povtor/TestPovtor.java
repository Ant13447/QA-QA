package test.povtor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Link;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class TestPovtor {

    private static String BASE_URL = "https://github.com/";
    private static String ISSUES = "Issues";
    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static String ISSUE_NUMBER = "#68";

    @Test
    @DisplayName("Поиск Issue по номеру в репозитории")
    public void GitHub(){
        parameter("Repository",REPOSITORY);
        parameter("Issue Number",ISSUE_NUMBER);


        step("Открываем главную страницу", () -> {
            open (BASE_URL);
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $x("//input[@name = 'q']").click();
            $x("//input[@name = 'q']").sendKeys(REPOSITORY);
            $x("//input[@name = 'q']").submit();
        });

       step("Переходим в репозиторий " + REPOSITORY, () ->{
          // $x("//a[@href = '/" + REPOSITORY + "']").click();
           $x("//*[contains(@href, '"+ REPOSITORY +"')]").click(); //*[contains(@href, 'eroshenkoam/allure-example')]
       });

        step("Переходим в раздел " + ISSUES, () -> {
            $x("//span[@data-content ='" + ISSUES + "']").click();
        });

        step("Проверяем, что Issues с номером " + ISSUE_NUMBER + " существует", () ->{
            $x("//span[@class ='opened-by']").shouldHave(Condition.text(ISSUE_NUMBER));
        });

        sleep(2000);
    }

    @Test
    @DisplayName("Поиск новый Issue по номеру в репозитории")
    public void GitHub1(){

        SelenideLogger.addListener("allure", new AllureSelenide());

            open (BASE_URL);

            $x("//input[@name = 'q']").click();
            $x("//input[@name = 'q']").sendKeys(REPOSITORY);
            $x("//input[@name = 'q']").submit();

            // $x("//a[@href = '/" + REPOSITORY + "']").click();
            $x("//*[contains(@href, '"+ REPOSITORY +"')]").click(); //*[contains(@href, 'eroshenkoam/allure-example')]

            $x("//span[@data-content ='" + ISSUES + "']").click();

            $x("//span[@class ='opened-by']").shouldHave(Condition.text(ISSUE_NUMBER));

        sleep(2000);
    }
}
