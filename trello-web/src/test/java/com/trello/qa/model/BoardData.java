package com.trello.qa.model;

import java.util.Objects;

public class BoardData {
  private  String boardName;
  private  String s;

  public BoardData setBoardName(String boardName) {
    this.boardName = boardName;
    return this;
  }

  public BoardData setS(String s) {
    this.s = s;
    return  this;
  }


  public String getBoardName() {
    return boardName;
  }

  @Override
  public String toString() {
    return "BoardData{" +
            "boardName='" + boardName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BoardData boardData = (BoardData) o;
    return Objects.equals(boardName, boardData.boardName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(boardName);
  }

  public String getS() {
    return s;
  }
// public String getS() {
  // }
}
