public class TargetedAd {

  public static void main(String[] args)
  {
    DataCollector collector = new DataCollector();
    collector.setData("socialMediaPosts.txt", "targetWords.txt");
//this creates a new object that will be used to collect data
    

String users = "";
//this will be where the usernames are stored

    for (int i = 0; i < 39; i++){
      String currentPost = collector.getNextPost();
      //this is the post
      boolean found = false;
      //this makes sure if the target word is in a certain post that it is serveying

      for (int j = 0; j < 20; j ++){
        String word = collector.getNextTargetWord();
        //this contains all 20 words in order to update the loop
        if(currentPost.indexOf(word) >= 0){
              found = true;
              //If the word is found the statement is set to true
           if(currentPost.contains("hotdog") || currentPost.contains("Hotdog")){
              found = false;
           }
        }
      }
      
      if (found == true){
        users += currentPost.substring(0, currentPost.indexOf(" ")) + " ";
        //Adds the username to the list if it has the key words
      }
    }

    collector.prepareAdvertisement("advertisement.txt", users, "Do you want your pets to be healthy? Buy Blue Buffalo pet food, suitable for both cats and dogs!");
    //this actually generates the ad that it is ment to
  }
  

}
