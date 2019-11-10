package com.trello.qa.tests;

import com.trello.qa.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BoardDeletionTest extends TestBase {

  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!app.getBoardHelper().isTherePersonalBoards()){
      app.getBoardHelper().createBoard();
    }
  }
  @Test
  public void deletionBoardTest() throws InterruptedException {
    int before = app.getBoardHelper().getPersnalBoardsCount();
    List<BoardData> listb = app.getBoardHelper().getBoardList();

   // app.getBoardHelper().clickOnFirstPrivateBoard();
   app.getBoardHelper().clickOnBoardByIndex(0);
    //Thread.sleep(10000);
    app.getBoardHelper().clickOnMoreButtonInBoardMenu();
    app.getBoardHelper().initBoardDeletion();
    app.getBoardHelper().confirmBoardDeletion();//.js-delete
    app.getBoardHelper().confirmFinishBoardDeletion();//.js-confirm.full
    app.getBoardHelper().returnToHomePage();


    int after = app.getBoardHelper().getPersnalBoardsCount();
    List<BoardData> listafter = app.getBoardHelper().getBoardList();
listb.remove(0);
    //Assert.assertEquals(before, after-1);
Assert.assertEquals(listb, listafter);
  }


}
