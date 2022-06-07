public class TargetedAd {

  public static void main(String[] args)
  {
                  //Creates DataCollector Object and sets the required data.
    DataCollector collector = new DataCollector();
    collector.setData("socialMediaPosts.txt", "targetWords.txt");
                  //Empty string which will contain usernames.
    String users = "";                
    for (int i = 0; i < 39; i++)
    {
                  //String containing the post.
      String currentPost = collector.getNextPost();
                  //Boolean which will change to true depending on if its found or not
      boolean found = false;
      for (int j = 0; j < 20; j ++)
      {
        String word = collector.getNextTargetWord();
                  //String containing each of the 20 words which updates as the loop progresses.
        if(currentPost.indexOf(word) >= 0)
        {
              found = true;
                  //If a target word is found, the boolean is updated.
           if(currentPost.contains("hotdog") || currentPost.contains("Hotdog"))
           {
              found = false;
           }
        }
      }
      if (found == true){
        users += currentPost.substring(0, currentPost.indexOf(" ")) + " ";
                  //If true, it adds the username to the list
      }
    }
    collector.prepareAdvertisement("advertisement.txt", users, "Do you want your pets to be healthy? Buy Blue Buffalo pet food, suitable for both cats and dogs!");
                  //Sends out the advertisement to the users that are added
  }
  //end of class
}
