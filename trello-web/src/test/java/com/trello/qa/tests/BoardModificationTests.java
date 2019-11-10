package com.trello.qa.tests;

import com.trello.qa.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BoardModificationTests extends  TestBase {
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!app.getBoardHelper().isTherePersonalBoards()){
      app.getBoardHelper().createBoard();
    }
  }
  @Test
  public void changeBoardName(){
    List<BoardData> listb = app.getBoardHelper().getBoardList();
    app.getBoardHelper().clickOnBoardByIndex(2);
    String bName = "BB";
    BoardData board= new BoardData().setBoardName(bName);
    app.getBoardHelper().changeBoardName(bName);
    List<BoardData> listafter = app.getBoardHelper().getBoardList();
   // Assert.assertTrue(app.getBoardHelper().findBoardByName(bName));
   listb.remove(2);
   listb.add(board);
Assert.assertEquals(new HashSet<Object>(listb), new HashSet<Object>(listafter));

  }


}
