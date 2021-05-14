package test.povtor;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class Lambda {

    private static String BASE_URL = "https://github.com/";
    private static String ISSUES = "Issues";
    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static String ISSUE_NUMBER = "#68";

    @Test
    public void testIssueSearch(){
        step("Открываем главную страницу", () -> {
            open (BASE_URL);
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $x("//input[@name = 'q']").click();
            $x("//input[@name = 'q']").sendKeys(REPOSITORY);
            $x("//input[@name = 'q']").submit();
        });

        step("Переходим в репозиторий " + REPOSITORY, () ->{
            $x("//a[@href = '/eroshenkoam/allure-example']").click();
        });

        step("Переходим в раздел " + ISSUES, () -> {
            $x("//span[@data-content ='" + ISSUES + "']").click();
        });

        step("Проверяем, что Issues с номером " + ISSUE_NUMBER + " существует", () ->{
            $x("//span[@class ='opened-by']").shouldHave(Condition.text(ISSUE_NUMBER));
        });
    }
}
