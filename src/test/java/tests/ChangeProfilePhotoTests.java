package tests;

import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlassianProfilePage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class ChangeProfilePhotoTests extends AppManager {

    @BeforeMethod
    public void login() {
        User user = User.builder().email("lizagindisqa@gmail.com").password("Tr@llo49").build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void changeProfilePhotoPosTest() {
        new BoardsPage(getDriver()).openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianProfilePage atlassianProfilePage = new AtlassianProfilePage(getDriver());
        atlassianProfilePage.uploadPhoto("src/main/resources/Tr2.jpg");
    }

}
