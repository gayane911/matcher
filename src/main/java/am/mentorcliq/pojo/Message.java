package am.mentorcliq.pojo;

public class Message {

  private String text;
  private String level;

  public Message(String text, String level) {
    this.text = text;
    this.level = level;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }
}
