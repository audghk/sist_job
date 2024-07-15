package day0417;

public class DataVO {

  private String name;
  private String url;
  private String img;

  public DataVO(String name, String url) {
    super();
    this.name = name;
    this.url = url;
  }

  public DataVO(String name, String url, String img) {
    super();
    this.name = name;
    this.url = url;
    this.img = img;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  @Override
  public String toString() {
    return "DataVO [name=" + name + ", url=" + url + "]";
  }

}
