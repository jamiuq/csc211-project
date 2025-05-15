public class User
{
  private String username;
  private String password;

  public User(String username, String password) {this.username = username; this.password = password;}

  private String getUsername() {return username;}
  private void setUsername(String username) {this.username = username;}
  private String getPassword() {return password;}
  private void setPassword(String password) {this.password = password;}

  public String toString()
  {
    return "Username: " + username + ", Password: " + password;
  }
}
