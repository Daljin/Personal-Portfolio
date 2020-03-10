package com.google.sps.data;

/** 
*   This class will store users image and message that are submitted.
**/
public final class ImageMessage {
  private final String message;
  private final String image;

  public ImageMessage(String message, String image) {
    this.message = message;
    this.image = image;
  }
}