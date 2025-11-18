package tests;

import data_provider.DataProviderBoards;
import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.TestNGListener;

import java.util.Random;

@Listeners(TestNGListener.class)
public class BoardsTests extends AppManager {

    @BeforeMethod
    public void login() {
        User user = User.builder().email("lizagindisqa@gmail.com").password("Tr@llo49").build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void createNewBoardPositiveTest() {
        int i = new Random().nextInt(1000);
        Board board = Board.builder()
                .boardTitle("MyBoard" + i).build();
        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnCreate();
        Assert.assertTrue(new MyBoardPage(getDriver()).validateBoardName(board.getBoardTitle()));
    }

    @Test
    public void createNewBoardNegativeTest_EmptyBoardTitle() {
        Board board = Board.builder()
                .boardTitle("").build();
        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.createNewBoard(board);
        boardsPage.btnCreateIsNotClickable();
        Assert.assertTrue(boardsPage.btnCreateIsNotClickable());
    }

    @Test(dataProvider = "newBoardDP", dataProviderClass = DataProviderBoards.class)
    public void createNewBoardPositiveDP(Board board) {
        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnCreate();
        Assert.assertTrue(new MyBoardPage(getDriver()).validateBoardName(board.getBoardTitle()));
    }

    @Test(dataProvider = "newBoardDPFromFile", dataProviderClass = DataProviderBoards.class)
    public void createNewBoardPositiveDPFromFile(Board board) {
        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnCreate();
        Assert.assertTrue(new MyBoardPage(getDriver()).validateBoardName(board.getBoardTitle()));
    }
}
